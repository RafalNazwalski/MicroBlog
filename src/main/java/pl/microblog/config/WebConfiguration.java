package pl.microblog.config;

import static spark.Spark.*;

import java.util.*;

import freemarker.ext.beans.HashAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.microblog.model.Message;
import pl.microblog.model.User;
import pl.microblog.service.MessageService;
import pl.microblog.service.UserService;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;
import java.util.Map;

@Component
public class WebConfiguration {

	private UserService userService;
	private MessageService messageService;

	@Autowired
	public WebConfiguration(UserService userService, MessageService messageService){
		this.userService = userService;
		this.messageService = messageService;
		staticFileLocation("/public");
		port(50000);
		setRoutes();
		
	}
	
	public void setRoutes(){
		get("/", (request,response) -> {
			return new ModelAndView(null, "index.ftl");
		}, new FreeMarkerEngine());
		
		
		post("/", (request,response) -> {
			String login = request.queryParams("login");
			String password = request.queryParams("password");
			User user = userService.getUserBylogin(login);
			if(user != null) user.setPassword(password);

			Map<String, String> errorsWhileLogin = userService.validateUser(user);
			if(errorsWhileLogin.isEmpty()){
				addUserToSession(request, user);
				response.redirect("/blog");
			}

			return modelAndView(errorsWhileLogin, "index.ftl");
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
			User loggedUser = getUserFromSession(request);
			Map<String, List<String>> userInfo = new TreeMap<>();
			List<String> users;

			users = userService.getAllUsers();
			List<Message> messagesLoggedUser = messageService.getMessageByUser(loggedUser);
			List<String> messagesText = new ArrayList<>();
			messagesLoggedUser.forEach(message -> messagesText.add(message.getText()));

			userInfo.put("users", users);
			userInfo.put("messages",messagesText);

			return new ModelAndView(userInfo, "blog.ftl");
		}, new FreeMarkerEngine());
		before("/blog", (request, response) -> {
			User authUser = getUserFromSession(request);
			if(authUser == null) {
				response.redirect("/");
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
			Map<String, String> errorsWhileRegister = userService.getErrorsWhileRegister(user);
			
			if(errorsWhileRegister.isEmpty()){
				userService.createUser(user);
				return modelAndView(null, "registerSuccess.ftl");
			}else{
				return modelAndView(errorsWhileRegister, "register.ftl");
			}
			
		}, new FreeMarkerEngine());
		before("/register", (request, response) -> {
			User authUser = getUserFromSession(request);
			if(authUser != null) {
				response.redirect("/blog");
			}
		});


		post("/blog/addmessage",(request,response) -> {
			User loggedUser = getUserFromSession(request);
			Message message = new Message();
			message.setAuthor(loggedUser.getId());
			message.setDate(new Date());
			String text = request.queryParams("postText");
			message.setText(text);
			messageService.addMessage(message);
			response.redirect("/blog");
			return modelAndView(null,"");
		}, new FreeMarkerEngine());
		before("/blog/addmessage", (request, response) -> {
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
