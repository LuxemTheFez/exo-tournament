package model;

public abstract class Fighter {

	private int hp;
	private Weapon weapon;
	
	public Fighter(int hp, Weapon weapon) {
		this.hp = hp;
		this.weapon = weapon; 
	}
	
	public void engage(Fighter f) {
		int i = 1;
		System.out.println("Vie début");
		System.out.println(this.hp);
		System.out.println(f.getHp());

		while(this.isAlive() && f.isAlive()){
			
			
			System.out.println("\n-------------- Round : "+ i +" -----------------");
			System.out.println("---------------------------------------------\n");

			
			System.out.println("sword avant : "+this.hp);
			System.out.println("f avant : " + f.getHp());

			this.attack(f);
			f.attack(this);
			
			
			System.out.println("sword après : " + this.hp);
			System.out.println("f avant : " + f.getHp());
			i++;

		}
	}
	
	public void attack(Fighter f) {
		f.takeDamage(this.weapon.getDamage());
	}
	
	public boolean isAlive() {
		boolean res = true;
		if (this.hp<=0) {
			res = false;
		}
		
		return res;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void takeDamage(int dmg) {
		if(this.hp-dmg<0) {
			this.hp=0;
		}else {
			this.hp-=dmg;
		}
	}
	
	public int hitPoints(){
		return hp;
		
	}
	
	
	

	
}
