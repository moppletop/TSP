package me.moppletop.tsp;

public class Journey {
	
	// private Location startLocation;
	private Location endLocation;
	private int distance;

	public Journey(Location endLocation, int distance) {
		// this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.distance = distance;
	}
	
	// public Location getStartLocation() {
	// return startLocation;
	// }
	
	public Location getEndLocation() {
		return endLocation;
	}

	public int getDistance() {
		return distance;
	}
}