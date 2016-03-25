package me.moppletop.tsp;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	/**
	 * This little program uses "greedy" algorithm logic to find a solution to
	 * the "Travelling Salesmen Problem". It will print out the time taken to
	 * complete the algorithm as well as construct a graph of all the cities
	 * with the "shortest" route possible by the programs standards.
	 *
	 * This program was built on Java 8 and uses the JSwing API for GUI
	 * creation.
	 *
	 * @author Sam
	 */
	
	// Inital method called on startup
	public static void main(String[] args) {
		List<Location> locations = new ArrayList<>();
		for (int i = 0; i < 20; i++)
			// This creates 20 locations with random x and y coordinates
			locations.add(new Location());
		new Solver(locations);
	}
}