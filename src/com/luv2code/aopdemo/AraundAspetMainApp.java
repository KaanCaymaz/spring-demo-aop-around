package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.FortunaService;

public class AraundAspetMainApp {
	
	private static Logger myLogger =  Logger.getLogger(AraundAspetMainApp.class.getName());
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		FortunaService fortunaService = context.getBean("fortunaService",FortunaService.class);
		
		myLogger.info("\n\n Main Program: AroundAspectApp");
		myLogger.info("Calling getFortuna()");
		
		Boolean tripWire= true;
		String data = fortunaService.getFortuna(tripWire);
		
		myLogger.info("\n\n MyFortuna is : "+ data);
		myLogger.info("Finished");
				
		context.close();
	}

}
