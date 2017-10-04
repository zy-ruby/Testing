package edu.umd.fcmd.guice.services;

import com.google.inject.Inject;

import edu.umd.fcmd.guice.interfaces.Connection;
import edu.umd.fcmd.guice.interfaces.FileSystem;
import edu.umd.fcmd.guice.interfaces.Persistance;

public class PersistanceOracle implements Persistance {
	private final FileSystem fileSystem;
	private final Connection connection;
	
	@Inject
	public PersistanceOracle(FileSystem fileSystem, Connection connection) {
		this.fileSystem = fileSystem;
		this.connection = connection;
	}
	
	
	@Override
	public String getType() {
		return "Oracle Persistance";
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
