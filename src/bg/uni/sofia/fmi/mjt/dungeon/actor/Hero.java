package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Hero extends Actor {
	private int maxHealth;
	private int maxMana;
	Position position;

	public Hero(String name, int health, int mana, Position position) {
		super(name, health, mana);
		this.position = position;
		maxHealth = super.health;
		maxMana = super.mana;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void takeHealing(int healingPoints) {
		if (health > 0) {
			health += healingPoints;
			if (health > maxHealth) {
				health = maxHealth;
			}
		}
	}

	public void takeMana(int manaPoints) {
		mana += manaPoints;
		if (mana > maxMana) {
			mana = maxMana;
		}
	}

	public void equip(Weapon weapon) {
		if (super.weapon == null || super.weapon.getDamage() < weapon.getDamage()) {
			super.weapon = weapon;
		}
	}

	public void learn(Spell spell) {
		if (super.spell == null || super.spell.getDamage() < spell.getDamage()) {
			super.spell = spell;
		}
	}
} 
	 
	 
	 
	 