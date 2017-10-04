package edu.umd.fcmd.guice.services;

import com.google.inject.Inject;

import edu.umd.fcmd.guice.interfaces.*;

public class FrontendGWT implements Frontend {
	private final Authentication authentication;
	
	@Inject
	public FrontendGWT(Authentication authentication) {
		this.authentication = authentication;
	}
	
	@Override
	public String getType() {
		return "GWT Frontend";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		// Frontend depends on an Authentication service
		authentication.run();
		
		return true;
	}
}
