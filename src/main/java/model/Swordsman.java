package model;

public class Swordsman extends Fighter {

	public Swordsman() {
		super(100, new Weapon(5, "1 hand sword", weaponType.sword));
		
	}
	
	public Swordsman equip(String nom) {
		switch (nom) {
		case "buckler":
			this.setBuckler(new Buckler(3, "buckler",this));
			break;
		case "armor":
			this.setArmor(new Armor(3, "armor",this));
			break;
		default:
			break;
		}
		
		return this;
		
	}
	
	

}
