package model;

public class GreatSword extends Weapon {

	private int cooldown;
	
	public GreatSword(int damage, String name, weaponType type) {
		super(damage, name, type);
		this.cooldown = 2;
	}

	@Override
	public int getDamage() {
		int dmg = this.damage;
		if (isOnCD()) {
			dmg = 0;
		}
		return dmg;
		
	}
	
	private boolean isOnCD() {
		boolean res = false;
		if(cooldown == 0) {
			cooldown = 2;
			res = true;
		}else {
			cooldown--;
		}
		
		return res;
	}
	
	
}
