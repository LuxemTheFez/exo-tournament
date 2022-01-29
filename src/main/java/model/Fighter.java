package model;

public abstract class Fighter {

	private int hp;
	private Weapon weapon;
	private DefenseObject defenseObject;
	
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
		DefenseObject object = f.getDefenseObject();
		
		if(object != null) {
			if(!object.defends(this.weapon.getType())) {
				f.takeDamage(this.weapon.getDamage());	
			}
		}else{
			f.takeDamage(this.weapon.getDamage());	
		}
		
	}
	
	public boolean isAlive() {
		boolean res = true;
		if (this.hp<=0) {
			res = false;
		}
		
		return res;
	}
	
	public void takeDamage(int dmg) {
		if(this.hp-dmg<0) {
			this.hp=0;
		}else {
			this.hp-=dmg;
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

	public DefenseObject getDefenseObject() {
		return defenseObject;
	}

	public void setDefenseObject(DefenseObject defenseObject) {
		this.defenseObject = defenseObject;
	}	
}
