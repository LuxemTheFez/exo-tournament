package model;

enum weaponType{
	sword,
	axe
}

public class Weapon {
	
	protected int damage;
	private String name;
	private weaponType type;
	
	public Weapon(int damage, String name, weaponType type) {
		super();
		this.damage = damage;
		this.name = name;
		this.type = type;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public weaponType getType() {
		return type;
	}

	public void setType(weaponType type) {
		this.type = type;
	}
	

	
	
}
