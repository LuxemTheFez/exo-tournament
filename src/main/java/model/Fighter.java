package model;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Fighter {

	private int hp;
	private Weapon weapon;
	private Buckler buckler;
	private Armor armor;
	
	public Fighter(int hp, Weapon weapon) {
		this.hp = hp;
		this.weapon = weapon;
	}
	
	public void engage(Fighter f) {
		int round = 1;
		System.out.println("Vie début");
		System.out.println(this.hp);
		System.out.println(f.getHp());

		while(this.isAlive() && f.isAlive()){
			
			
			System.out.println("\n-------------- Round : "+ round +" -----------------");
			System.out.println("---------------------------------------------\n");

			
			System.out.println("sword avant : "+this.hp);
			System.out.println("f avant : " + f.getHp());

			this.attack(f);
			f.attack(this);
			
			
			System.out.println("sword après : " + this.hp);
			System.out.println("f avant : " + f.getHp());
			round++;

		}
	}
	
	public void attack(Fighter f) {
		int dmg = producedDamage();	
		
		if (dmg>0) {
			f.takeDamage(dmg, this.weapon.getType());
		}
	}
		



	
	private int producedDamage() {
		int dmg = this.weapon.getDamage();
		if(armor!=null) {
			dmg-=armor.getDamageDealtReduction();
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
			System.out.println(dmgAfterReduction);
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
