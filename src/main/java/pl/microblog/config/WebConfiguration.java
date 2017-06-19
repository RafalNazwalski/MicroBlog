package pl.microblog.config;

import static spark.Spark.*;

import freemarker.template.Template;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.microblog.Application;
import pl.microblog.model.User;
import pl.microblog.service.UserService;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

import javax.security.auth.login.Configuration;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			List<String> users;

			users = userService.getAllUsers();

			for (String user : users){
			System.out.println("Users: " + user);
			}
		});
		
		
		get("/register", (request,response) -> {
			return new ModelAndView(null, "register.ftl");
		}, new FreeMarkerEngine());
		
		
		post("/register", (request,response) -> {
			String firstname = request.queryParams("firstname");
			String lastname = request.queryParams("lastname");
			String login = request.queryParams("login");
			String password = request.queryParams("password");
			User user = new User(firstname,lastname,login,password);
			userService.createUser(user);
			return modelAndView(null, "registerSuccess.ftl");
		}, new FreeMarkerEngine());
		before("/register", (request, response) -> {
			User authUser = getUserFromSession(request);
			if(authUser != null) {
				response.redirect("/blog");
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
