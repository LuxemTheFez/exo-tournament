package model;


public abstract class DefenseObject {
	protected int durability;
	protected int damageReceivedReduction;
	protected int damageDealtReduction;

	String name;
	Fighter owner;
	
	public DefenseObject(int durability, String name, Fighter owner, int damageReceivedReduction, int damageDealtReduction) {
		this.durability = durability;
		this.name = name;
		this.owner = owner;
		this.damageReceivedReduction = damageReceivedReduction;
		this.damageDealtReduction = damageDealtReduction;
	}

	public abstract boolean parrying(weaponType wt);
	

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public int getDamageReceivedReduction() {
		return damageReceivedReduction;
	}

	public void setDamageReceivedReduction(int damageReceivedReduction) {
		this.damageReceivedReduction = damageReceivedReduction;
	}

	public int getDamageDealtReduction() {
		return damageDealtReduction;
	}

	public void setDamageDealtReduction(int damageDealtReduction) {
		this.damageDealtReduction = damageDealtReduction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Fighter getOwner() {
		return owner;
	}

	public void setOwner(Fighter owner) {
		this.owner = owner;
	}

	protected abstract boolean isBroken(); 
	
	

}
