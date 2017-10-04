package edu.umd.fcmd.guice.services;

import com.google.inject.Inject;

import edu.umd.fcmd.guice.interfaces.*;

public class PersistanceMySQL implements Persistance {
	private final FileSystem fileSystem;
	private final Connection connection;
	
	@Inject
	public PersistanceMySQL(FileSystem fileSystem, Connection connection) {
		this.fileSystem = fileSystem;
		this.connection = connection;
	}
	
	@Override
	public String getType() {
		return "MySQL Persistance";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		fileSystem.run();
		connection.run();
		
		return true;
	}
}
