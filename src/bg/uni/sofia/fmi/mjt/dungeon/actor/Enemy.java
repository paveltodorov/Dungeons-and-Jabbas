package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Enemy extends Actor {
	public Enemy(String name, int health, int mana, Weapon weapon, Spell spell) {
		super(name, health, mana, weapon, spell);
	}
}
