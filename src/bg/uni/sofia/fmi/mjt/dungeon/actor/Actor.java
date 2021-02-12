package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Actor {
	private String name;
	protected int health;
	protected int mana;
	protected Weapon weapon;
	protected Spell spell;

	Actor(String name, int health, int mana, Weapon weapon, Spell spell) {
		this.name = name;
		this.health = health;
		this.mana = mana;
		this.spell = spell;
		this.weapon = weapon;
	}

	Actor(String name, int health, int mana) {
		this.name = name;
		this.health = health;
		this.mana = mana;
		this.spell = null;
		this.weapon = null;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getMana() {
		return mana;
	}

	public boolean isAlive() {
		return health > 0;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public Spell getSpell() {
		return spell;
	}

	public void takeDamage(int damagePoints) // - отнема кръв на врага (кръвта не може да бъде по-малко от 0)
	{
		health -= damagePoints;
		if (health < 0) {
			health = 0;
		}
	}

	public int attack() {
		int weaponDamage = 0;
		int spellDamage = 0;
		if (weapon != null) {
			weaponDamage = weapon.getDamage();
		}

		if (spell != null) {
			spellDamage = spell.getDamage();
		}
		/*
		 * if(spell == null && weapon == null) { return 0; } else { if(weaponDamage >=
		 * spellDamage) { return weaponDamage; } else { if(spell.getManaCost() >= mana)
		 * { mana -= spellDamage; return spellDamage; } else { return weaponDamage; } }
		 * }
		 */
		if (weaponDamage >= spellDamage || spell == null || spell.getManaCost() > mana) {
			return weaponDamage;
		} else {
			mana -= spell.getManaCost();
			return spellDamage;
		}
	}

}

