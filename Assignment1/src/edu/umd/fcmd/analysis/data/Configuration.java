package edu.umd.fcmd.analysis.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Configuration implements Comparable<Configuration> {
	List<Option> options = new ArrayList<Option>();
	
	/**
	 * @return	the list of Options of the current Configuration
	 */
	public List<Option> getOptions() {
		return options;
	}
	
	/**
	 * Adds an Option to the current configuration
	 * 
	 * @param option
	 */
	public void addOption(Option option) {
		options.add(option);
		
		Collections.sort(options);
	}

	/**
	 * Determines if the current Configuration subsumes the argument Configuration.
	 * Configuration_A subsumes Configuration_B if it has every Option Configuration_B has. 
	 * 
	 * @param c
	 * 
	 * @return	the value true if the current Configuration subsumes the argument 
	 */
	public boolean subsumes(Configuration c) {
		if (options.size() < c.options.size()) {
			return false;
		}
		
		for (int x = 0; x < c.options.size(); x++) {
			if (!options.contains(c.options.get(x))) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Configurations are ordered by length then by the first differing option
	 * 
	 * @return	the value 0 if Configuration contains the same Options as the current Configuration
	 * 			the value less than 0 if ...
	 * 			the value greater than 0 if ...
	 */
	public int compareTo(Configuration c) {
		int size = Math.min(options.size(), c.options.size());
		int x = 0;
		
		while (x < size && options.get(x).compareTo(c.options.get(x)) == 0) {
			x++;
		}
		
		if (x == size) {
			return options.size() - c.options.size();
		}
		
		return options.get(x).compareTo(c.options.get(x));
	}
	
	public boolean equals(Object obj) {
		/** TODO
		 * implement equals() method 
		 */
		
		return false;
	}
	
	public int hashCode() {
		/** TODO
		 * implement hashCode() method
		 */
		
		return 42;
	}
	
	/**
	 * @return		string representation of the current Configuration
	 */
	public String toString() {
		String str = "";
		
		for (Option option : options) {
			str += option + " ";
		}
		
		return str.trim();
	}
}