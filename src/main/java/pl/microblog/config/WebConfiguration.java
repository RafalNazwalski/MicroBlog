package pl.microblog.config;

import static spark.Spark.*;

import pl.microblog.service.UserService;
import spark.ModelAndView;
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
		
	}
	
	

}
