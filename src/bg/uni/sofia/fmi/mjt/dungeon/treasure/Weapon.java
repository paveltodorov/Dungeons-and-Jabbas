package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Weapon extends WeaponAndSpell {

	public Weapon(String name, int damage) {
		super(name, damage);
	}

	public String collect(Hero hero) {
		/*
		 * int currentWeaponDamage = 0; if(hero.getWeapon() != null) {
		 * currentWeaponDamage = hero.getWeapon().getDamage(); } if(super.damage >
		 * currentWeaponDamage) { hero.set }
		 */
		hero.equip(this);
		return "Weapon found! Damage points: " + super.damage;// hero.getWeapon().getDamage();
	}

}
