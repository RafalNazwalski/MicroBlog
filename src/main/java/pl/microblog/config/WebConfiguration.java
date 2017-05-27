package pl.microblog.config;

import static spark.Spark.*;

import pl.microblog.model.User;
import pl.microblog.service.UserService;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

public class WebConfiguration {
	
	private UserService userService;
	
	public WebConfiguration(UserService userService){
		this.userService = userService;
		staticFileLocation("/public");
		setRoutes();
		
	}
	
	public void setRoutes(){
		get("/", (request,response) -> {
			return new ModelAndView(null, "index.ftl");
		}, new FreeMarkerEngine());
		
		
		post("/", (request,response) -> {
			String login = request.queryParams("login");
			String password = request.queryParams("password");
			User user = new User();
			user.setLogin(login);
			userService.encodePassword(password);
			user.setPassword(password);
			boolean validateUser = userService.validateUser(user);
			if(validateUser){
				addUserToSession(request, user);
				response.redirect("/blog");
			}
			response.redirect("/");
			return modelAndView(null, "");
		}, new FreeMarkerEngine());
		before("/", (request, response) -> {
			User authUser = getUserFromSession(request);
			if(authUser != null) {
				response.redirect("/blog");
			}
		});
		
		get("/logout", (request,reponse) -> {
			removeUserFromSession(request);
			reponse.redirect("/");
			return new ModelAndView(null, "");
		}, new FreeMarkerEngine());
		
		
		
		get("/blog", (request,reponse) -> {
			return new ModelAndView(null, "blog.ftl");
		}, new FreeMarkerEngine());
		before("/blog", (request, response) -> {
			User authUser = getUserFromSession(request);
			if(authUser == null) {
				response.redirect("/");
			}
		});
		
	}
	
	
	private void addUserToSession(Request request, User u) {
		request.session().attribute("user", u);
		
	}

	private void removeUserFromSession(Request request) {
		request.session().removeAttribute("user");
		
	}

	private User getUserFromSession(Request request) {
		return request.session().attribute("user");
	}
	
}
