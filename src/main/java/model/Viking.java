package model;

public class Viking extends Fighter {

	public Viking() {
		super(120, new Weapon(6, "1 hand axe",weaponType.axe));
	}

	public Viking equip(String nom) {
		switch (nom) {
		case "buckler":
			this.setBuckler(new Buckler(3, "buckler",this));
			break;

		default:
			break;
		}
		
		return this;
		
	}

}
