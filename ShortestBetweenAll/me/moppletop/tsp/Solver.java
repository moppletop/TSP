package me.moppletop.tsp;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

public class Solver {

	/*
	 * The Solver class handles the solving of the problem. Its logic is explain
	 * inside the constructor.
	 */
	
	public Solver(List<Location> locsList) {
		System.out.println("Starting the calculations... HOLD ON TO YOUR HATS!!"); // YOLO

		long startTime = System.nanoTime(); //Saves the current time in nanoseconds.
		
		List<Location> sortedLocations = new ArrayList<>(); //Setup a list for storing the locations in the correct order.
		Location startLocation = locsList.get(0); //Assume the starting location is the first one in the list.
		double totalDistance = 0; //Total distance of all distances.
		int visited = 0; //Amount of locations visited.

		while (visited < locsList.size()) { //is the number of locations visited is less than the total number of locations, repeat
			Location shortest = null; //Initially we don't know what the shortest distance is, so put it equal to null.
			double shortestDistance = Double.MAX_VALUE; //The default shortest distance is going be the maximum value of a double.
			for (Location locs : locsList) { 
				if (locs.equals(startLocation)) //is the current location where we are checking the distances from.
					continue;
				if (sortedLocations.contains(locs)) //If the location has already be visited
					continue;
				if (shortest == null) { //If we don't know any distances
					shortest = locs;
					continue;
				}
				double distanceTo = startLocation.distanceTo(locs); //What is the distance between here and the location we are looping through
				if (startLocation.distanceTo(locs) < shortestDistance) { //Is the distance less than the shortest
					shortest = locs;
					shortestDistance = distanceTo;
				}
			}
			visited++; //Increment the number of cities visited
			totalDistance += shortestDistance; //Add to the total distance
			startLocation = shortest; //Put the shortest location to be the next starting location
			sortedLocations.add(shortest); //Add it to the sorted list of locations.
		}
		
		long timeTaken = System.nanoTime() - startTime; //Takes away the time when we started from the time now. 
		System.out.println("Finished in around, " + timeTaken + " nanoseconds or " + timeTaken / 1000000 + " milliseconds"); //Print the time
		System.out.println("Final distance: " + (int) totalDistance); //Cast to an integer, why not?
		EventQueue.invokeLater(new Runnable() { 

			//Run this code AFTER JSwing has been fully initialised.
			public void run() {
				System.out.println("Generating the graph");
				GraphBuilder.createAndShowGui(sortedLocations);
			}
		});
	}
}
