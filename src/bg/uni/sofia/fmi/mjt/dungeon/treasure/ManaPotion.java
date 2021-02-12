package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class ManaPotion extends Potion {

	public ManaPotion(int points) {
		super(points);
	}

	public String collect(Hero hero) {
		int mana = hero.getMana();
		hero.takeMana(super.points);
		int newMana = hero.getMana();
		int added = newMana - mana;
		return "Mana potion found! " + added + " mana points added to your hero!";
	}

}
