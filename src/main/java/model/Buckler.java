package model;

public class Buckler extends DefenseObject {

	private boolean inUse;
	
	public Buckler(int durability, String name, Fighter owner) {
		super(durability, name, owner);
		this.inUse = true;
	}


	@Override
	protected boolean defends(weaponType wt) {
		if(isBroken()) {
			this.owner.setDefenseObject(null);
			
			return false;
		}
		if (wt==weaponType.axe && inUse) {
			this.durability-=1;
		}

		inUse = !inUse;
		return !inUse;
	}
	
	private boolean isBroken() {
		return (durability==0);
	}
	
}
