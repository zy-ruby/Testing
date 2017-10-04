package edu.umd.fcmd.guice.application;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

import edu.umd.fcmd.guice.interfaces.*;
import edu.umd.fcmd.guice.services.*;

public class LoggedModule extends AbstractModule {
	public void configure() {
		bind(Authentication.class).to(AuthenticationTSL.class);
		bind(Frontend.class).to(FrontendGWT.class);
		bind(Middleware.class).to(MiddlewareJBoss.class);
		bind(Persistance.class).to(PersistanceOracle.class);
		bind(FileSystem.class).to(FileSystemNFS.class);
		bind(Connection.class).to(ConnectionJDBC.class);
		LoggingInterceptor log = new LoggingInterceptor();
		bindInterceptor(Matchers.subclassesOf(Frontend.class), Matchers.any(), 
				log);
		bindInterceptor(Matchers.subclassesOf(Middleware.class), Matchers.any(), 
				log);
		bindInterceptor(Matchers.subclassesOf(Persistance.class), Matchers.any(), 
				log);
		
	}
}
