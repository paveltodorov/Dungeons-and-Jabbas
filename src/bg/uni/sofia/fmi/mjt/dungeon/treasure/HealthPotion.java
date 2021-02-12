package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class HealthPotion extends Potion {

	public HealthPotion(int healingPoints) {
		super(healingPoints);
	}

	public String collect(Hero hero) {
		int health = hero.getHealth();
		hero.takeHealing(super.points);
		int newHealth = hero.getHealth();
		int added = newHealth - health;
		return "Health potion found! " + added + " health points added to your hero!";
	}

}
