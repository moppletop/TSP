package me.moppletop.tsp;

public class Location {
	
	private String name;
	private Journey[] journies;

	public Location(String name) {
		this.name = name;
		this.journies = new Journey[0];
	}
	
	public void setJournies(Journey[] journies) {
		this.journies = journies;
	}
	
	public String getName() {
		return name;
	}
	
	public Journey[] getJournies() {
		return journies;
	}
	
}