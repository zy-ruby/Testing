package edu.umd.fcmd.guice.application;


import edu.umd.fcmd.guice.services.*;
import edu.umd.fcmd.guice.interfaces.*;

import com.google.inject.AbstractModule;

public class StandardModule extends AbstractModule {
	public void configure() {
		bind(Authentication.class).to(AuthenticationSSL.class);
		bind(Frontend.class).to(FrontendHTML.class);
		bind(Middleware.class).to(MiddlewareTomcat.class);
		bind(Persistance.class).to(PersistanceMySQL.class);
		bind(FileSystem.class).to(FileSystemNTFS.class);
		bind(Connection.class).to(ConnectionPooled.class);
	}
}
