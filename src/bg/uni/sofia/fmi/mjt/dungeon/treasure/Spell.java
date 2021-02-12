package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Spell extends WeaponAndSpell {

	public Spell(String name, int damage, int manaCost) {
		super(name, damage);
		this.manaCost = manaCost;
	}

	private int manaCost;

	public String collect(Hero hero) {
		hero.learn(this);
		return "Spell found! Damage points: " + hero.getSpell().getDamage() + ", Mana cost: " + manaCost;
	}

	public int getManaCost() {
		return manaCost;
	}
	/*
	 * public void setManaCost(int manaCost) { this.manaCost = manaCost; }
	 */

}
