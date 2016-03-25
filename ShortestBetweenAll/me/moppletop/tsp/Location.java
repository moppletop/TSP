package me.moppletop.tsp;

import java.util.Random;

public class Location {
	
	/*
	 * The Location object stores the data about a "city". Each city has its own
	 * location which contains an x and y value. This is used to calculate the
	 * distances and plot the points on the graph. In real-life the x and y
	 * values could be longitude and latitude values.
	 */
	
	private int x;
	private int y;

	// Constructs the location object. With no parameters we generate
	// random x and y coordinates.
	public Location() {
		Random random = new Random();
		this.x = random.nextInt(100) + 1;
		this.y = random.nextInt(100) + 1;
	}
	
	// Constructs a location at given x and y coordinates
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Gets the distance to given location via Pythagora's theorem
	public double distanceTo(Location loc) {
		int x = Math.abs(getX() - loc.getX());
		int y = Math.abs(getY() - loc.getY());
		return Math.sqrt((x * x) + (y * y));
	}

	// Returns the x value.
	public int getX() {
		return x;
	}
	
	// Returns the y value.
	public int getY() {
		return y;
	}
}