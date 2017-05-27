package pl.microblog;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.microblog.config.WebConfiguration;
import pl.microblog.service.UserService;

@Configuration
@ComponentScan({"pl.microblog"})
public class Application {
	
	public static void main(String[] args){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		new WebConfiguration(ctx.getBean(UserService.class));
		ctx.registerShutdownHook();
	}
	
	/*
	 * 1. Zrobic rejestracje
	 * 2. walidacja?
	 */

}
