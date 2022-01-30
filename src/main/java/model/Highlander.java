package model;

public class Highlander extends Fighter {
	
	

	public Highlander() {
		super(150, new GreatSword(12, "Great Sword", weaponType.sword));
	}

	public Highlander(String type) {
		super(150, new GreatSword(12, "Great Sword", weaponType.sword), type);
	}

	
}
