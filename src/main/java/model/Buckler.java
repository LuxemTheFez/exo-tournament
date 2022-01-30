package model;

public class Buckler extends DefenseObject {

	private boolean inUse;
	
	public Buckler(int durability, String name, Fighter owner) {
		super(durability, name, owner, 0, 0);
		this.inUse = true;
	}


	public Buckler(int durability, String name, Fighter owner, int damageReceivedReduction, int damageDealtReduction) {
		super(durability, name, owner, damageReceivedReduction, damageDealtReduction);
	}


	@Override
	public boolean parrying(weaponType wt) {
		if(isBroken()) {
			this.owner.setBuckler(null);
			
			return false;
		}
		if (wt==weaponType.axe && inUse) {
			this.durability-=1;
		}
		inUse = !inUse;
		
		return !inUse;
	}
	
	@Override
	protected boolean isBroken() {
		return (durability==0);
	}
	
}
