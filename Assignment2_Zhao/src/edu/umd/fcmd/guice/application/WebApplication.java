package edu.umd.fcmd.guice.application;

import com.google.inject.Injector;
import com.google.inject.Guice;

public class WebApplication {
	private WebServer server;
	
	public void run() {
		System.out.println("starting web application...");
	
		
		// create guice injector and server here
		Injector injector = Guice.createInjector(new StandardModule());
		server = injector.getInstance(WebServer.class);
//		server = ???;

		server.run();
		
		System.out.println("web application finished.");
	}

	public static void main(String[] args) {
		WebApplication app = new WebApplication();

		app.run();
	}
}
