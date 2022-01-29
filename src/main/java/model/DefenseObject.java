package model;


public abstract class DefenseObject {
	int durability;
	String name;
	Fighter owner;
	
	public DefenseObject(int durability, String name, Fighter owner) {
		this.durability = durability;
		this.name = name;
		this.owner = owner;
	}

	protected abstract boolean defends(weaponType wt); 
	
	

}
