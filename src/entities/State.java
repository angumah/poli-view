package entities;

import java.util.List;

public class State {
	private int id;
	private String name;
	private int districts;
	
	public State(int id, String name, int districts) {
		this.id = id;
		this.name = name;
		this.districts = districts;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getDistricts() {
		return this.districts;
	}
}
