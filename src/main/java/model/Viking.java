package model;

public class Viking extends Fighter {

	public Viking() {
		super(120, new Weapon(6, "1 hand axe",weaponType.axe));
		// TODO Auto-generated constructor stub
	}

	public Viking equip(String nom) {
		switch (nom) {
		case "buckler":
			this.setDefenseObject(new Buckler(3, "buckler",this));
			break;

		default:
			break;
		}
		
		return this;
		
	}

}
