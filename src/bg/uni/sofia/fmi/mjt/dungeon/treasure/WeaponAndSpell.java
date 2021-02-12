package bg.uni.sofia.fmi.mjt.dungeon.treasure;

public abstract class WeaponAndSpell implements Treasure {
	private String name;
	protected int damage;

	WeaponAndSpell(String name, int damage) {
		this.setName(name);
		this.setDamage(damage);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}
