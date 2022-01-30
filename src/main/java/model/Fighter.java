package model;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Fighter {

	private int hp;
	private int hpMax;
	private Weapon weapon;
	private Buckler buckler = null;
	private Armor armor = null;
	private boolean isBerserk = false;
	private boolean isVicious = false;
	private boolean isVeteran = false;
	private int blow = 0;
	
	public Fighter(int hp, Weapon weapon) {
		this.hp = hp;
		this.weapon = weapon;
	}
	
	public Fighter(int hp, Weapon weapon, String type) {
		this.hp = hp;
		this.hpMax = hp;
		this.weapon = weapon;
		this.isVeteran = type=="Veteran";
		this.isVicious = type=="Vicious";
		this.blow = type=="Vicious" ? 2: 0;
	}
	
	public void engage(Fighter f) {
		int round = 1;

		while(this.isAlive() && f.isAlive()){


			this.attack(f);
			f.attack(this);

		}
	}
	
	public void attack(Fighter f) {
		int dmg = producedDamage();	
		
		if (dmg>0) {
			f.takeDamage(dmg, this.weapon.getType());
		}
	}
		
	
	public boolean isBerserk() {
		if (isBerserk) {
			return isBerserk;
		}
		double percent = (30 * hpMax) / 100;
		isBerserk =  percent >= (double) hp;
		
		return isBerserk;
		
	}


	
	private int producedDamage() {
		int dmg = this.weapon.getDamage();
		if (isBerserk()) {
			dmg*=2;
		}
		if(armor!=null) {
			dmg-=armor.getDamageDealtReduction();
		}
		if(isVicious && blow>0) {
			dmg+=20;
			blow--;
		}
		return dmg;
		
	}
	
	
	private int damageMitigation(int incomingDamge) {
		int dmg = incomingDamge;
		if(armor!=null) {
			dmg-=armor.getDamageReceivedReduction();
		}
		
		return dmg;
	}
	
	private boolean isAlive() {
		boolean res = true;
		if (this.hp<=0) {
			res = false;
		}
		
		return res;
	}
	
	public void takeDamage(int dmg, weaponType type) {
			int dmgAfterReduction = damageMitigation(dmg);
			if (buckler!=null) {
				if(buckler.parrying(type)) {
					dmgAfterReduction = 0;
				}
			}
			if(this.hp-dmgAfterReduction<0) {
				this.hp=0;
			}else {
				this.hp-=dmgAfterReduction;
			}	
	}
	

	
	//Setter&Getter
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}


	
	public int hitPoints(){
		return hp;
		
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Buckler getBuckler() {
		return buckler;
	}

	public void setBuckler(Buckler buckler) {
		this.buckler = buckler;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	
}
