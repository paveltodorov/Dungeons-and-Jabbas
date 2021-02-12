package bg.uni.sofia.fmi.mjt.dungeon;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Enemy;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Position;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.HealthPotion;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Treasure;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.ManaPotion;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Hero hero = new Hero("Pavel", 20, 5, new Position(0, 0));

		Weapon weapon1 = new Weapon("w1", 1);
		Weapon weapon2 = new Weapon("w2", 3);
		Weapon weapon3 = new Weapon("w3", 4);

		Spell spell1 = new Spell("s1", 3, 4);
		Spell spell2 = new Spell("s2", 4, 2);
		Spell spell3 = new Spell("s3", 3, 1);

		Enemy enemy1 = new Enemy("e1", 6, 5, weapon1, spell1);
		Enemy enemy2 = new Enemy("e1", 6, 5, weapon2, spell2);
		Enemy enemy3 = new Enemy("e1", 6, 5, weapon3, spell3);

		Treasure t3 = new HealthPotion(3);
		Treasure t2 = new Weapon("w1", 2);
		Treasure t1 = new Spell("s2", 5, 2);

		Enemy[] enemies = { enemy1, enemy2, enemy3 };
		Treasure[] treasures = { t1, t2, t3, weapon1 };

		// hero.equip(weapon1);
		// hero.learn(spell1);

		// hero.learn(spell2);
		/*
		 * System.out.println("Health "+hero.getHealth());
		 * System.out.println("Mana "+hero.getMana());
		 * System.out.println("attack "+hero.attack() );
		 * System.out.println("Health "+hero.getHealth());
		 * System.out.println("Mana "+hero.getMana());
		 * System.out.println("attack "+hero.attack() );
		 * System.out.println("attack "+hero.attack() );
		 */
		char[][] map = new char[5][10];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++)
		// for(int j = 0;j<10;j++)
		{
			map[i] = sc.next().toCharArray();
			// char[5][10] map = {'h','f'} ;
		}

		GameEngine game = new GameEngine(map, hero, enemies, treasures);
		for (int m = 0; m < 30; m++) {
			int cmd = sc.nextInt();
			System.out.println(game.makeMove(cmd));
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.out.println("Health" + hero.getHealth());
			System.out.println("Mana" + hero.getMana());
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		/*
		 * S.##.....T #T##..###. #.###E###E #.E...###. ###T#####G
		 */

	}

}
