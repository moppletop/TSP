package me.moppletop.tsp;

import java.util.ArrayList;
import java.util.List;

public class Initaliser {
	
	private List<Location> locations = new ArrayList<>();
	
	/*
	 * Swansea = 0 Carmarthen = 1 Landovery = 2 Brecon = 3 Aberaeron = 4
	 * Aberstwyth = 5 Landrindod Wells = 6 Barmouth = 7 Welshpool = 8 Porthmadog
	 * = 9 Corwen = 10 Bangor = 11
	 */
	
	public Initaliser() {
		locations.add(new Location("Swansea"));
		locations.add(new Location("Carmarthen"));
		locations.add(new Location("Landovery"));
		locations.add(new Location("Brecon"));
		locations.add(new Location("Aberaeron"));
		locations.add(new Location("Aberstwyth"));
		locations.add(new Location("Landrindod Wells"));
		locations.add(new Location("Barmouth"));
		locations.add(new Location("Welshpool"));
		locations.add(new Location("Porthmadog"));
		locations.add(new Location("Corwen"));
		locations.add(new Location("Bangor"));

		locations.get(0).setJournies(new Journey[] { new Journey(locations.get(1), 30), new Journey(locations.get(2), 35), new Journey(locations.get(3), 45) });
		locations.get(1).setJournies(new Journey[] { new Journey(locations.get(4), 30), });
		locations.get(2).setJournies(new Journey[] { new Journey(locations.get(5), 40), new Journey(locations.get(6), 45), });
		locations.get(3).setJournies(new Journey[] { new Journey(locations.get(6), 40), });
		locations.get(4).setJournies(new Journey[] { new Journey(locations.get(5), 30), });
		locations.get(5).setJournies(new Journey[] { new Journey(locations.get(6), 45), new Journey(locations.get(7), 45), });
		locations.get(5).setJournies(new Journey[] { new Journey(locations.get(6), 45), new Journey(locations.get(7), 45), });
		locations.get(6).setJournies(new Journey[] { new Journey(locations.get(8), 40), });
		locations.get(7).setJournies(new Journey[] { new Journey(locations.get(9), 35), new Journey(locations.get(10), 40), });
		locations.get(8).setJournies(new Journey[] { new Journey(locations.get(10), 45), });
		locations.get(9).setJournies(new Journey[] { new Journey(locations.get(11), 40), });
		locations.get(10).setJournies(new Journey[] { new Journey(locations.get(7), 40), new Journey(locations.get(11), 30), });

		System.out.println("Possible Journeys (Start > Distance > End)");
		for (Location location : locations)
			for (Journey journey : location.getJournies())
				System.out.println(location.getName() + " > " + journey.getDistance() + " > " + journey.getEndLocation().getName());
		System.out.println();
		System.out.println("Solution...");
		System.out.println();
		getShortestRoute();
	}
	
	public void getShortestRoute() {
		Location start = locations.get(0);
		System.out.println(start.getName());
		while (start != locations.get(locations.size() - 1)) {
			Location shortestJourney = null;
			int shortestDistance = Integer.MAX_VALUE;
			for (Journey journey : start.getJournies()) {
				if (journey.getDistance() < shortestDistance || shortestJourney == null) {
					shortestJourney = journey.getEndLocation();
					shortestDistance = journey.getDistance();
				}
			}
			start = shortestJourney;
			System.out.println(start.getName());
		}
	}
}
