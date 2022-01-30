package model;

public class Armor extends DefenseObject {

	public Armor(int durability, String name, Fighter owner) {
		super(-1, name, owner, 3, 1);
	}
	
	

	public Armor(int durability, String name, Fighter owner, int damageReceivedReduction, int damageDealtReduction) {
		super(durability, name, owner, damageReceivedReduction, damageDealtReduction);
	}



	@Override
	public boolean parrying(weaponType wt) {
		return false;
	}



	@Override
	protected boolean isBroken() {
		return false;
	}

}
