package bg.uni.sofia.fmi.mjt.dungeon;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Position;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Enemy;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Treasure;

public class GameEngine {
	private char[][] map;
	private Hero hero;
	private Enemy[] enemies;
	private Treasure[] treasures;
	private int lastTreasureIndex;
	private int lastEnemyIndex;
	private boolean gameIsOver;

	public GameEngine(char[][] map, Hero hero, Enemy[] enemies, Treasure[] treasures) {
		this.map = map;
		this.hero = hero;
		this.enemies = enemies;
		this.treasures = treasures;
		lastTreasureIndex = 0;
		lastEnemyIndex = 0;
		gameIsOver = false;
		Position pos = findInitialPosition();
		hero.setPosition(pos);
		map[pos.getX()][pos.getY()] = 'H';
	}

	public char[][] getMap() {
		return map;
	}

	public Position findInitialPosition() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 'S') {
					return new Position(i, j);
				}
			}
		}
		return null;
	}

	public String moveTo(Position pos) {
		map[hero.getPosition().getX()][hero.getPosition().getY()] = '.'; // old position
		hero.setPosition(pos);
		map[hero.getPosition().getX()][hero.getPosition().getY()] = 'H';
		return "You moved successfully to the next position.";
	}

	public String fightWithEnemy(Position pos) {
		Enemy enemy = enemies[lastEnemyIndex];
		lastEnemyIndex++;
		boolean heroAttacks = true;
		while (hero.isAlive() && enemy.isAlive()) {
			if (heroAttacks) {
				enemy.takeDamage(hero.attack());
				heroAttacks = false;
			} else {
				hero.takeDamage(enemy.attack());
				heroAttacks = true;
			}
		}

		if (hero.isAlive()) {
			moveTo(pos);
			return "Enemy died.";
		} else {
			return "Hero is dead! Game over!";
		}
	}

	public String collectTreasure(Position pos) {
		Treasure t = treasures[lastTreasureIndex];
		lastTreasureIndex++;
		moveTo(pos);
		return t.collect(hero);
	}

	public String makeMove(int command) {
		if (gameIsOver) {
			return null;
		}
		if (command < 0 || command > 5) {
			return "Unknown command entered.";
		}
		Position newPosition = hero.getPosition().move(command);
		if (newPosition.getX() < 0 || newPosition.getY() < 0 || newPosition.getX() >= map.length
				|| newPosition.getY() >= map[0].length) {
			return "Wrong move. There is an obstacle and you cannot bypass it.";
		}

		switch (map[newPosition.getX()][newPosition.getY()]) {
		case 'S':
			return moveTo(newPosition);
		case '.':
			return moveTo(newPosition);
		case '#':
			return "Wrong move. There is an obstacle and you cannot bypass it.";
		case 'E':
			return fightWithEnemy(newPosition);
		case 'T':
			return collectTreasure(newPosition);
		case 'G': {
			gameIsOver = true;
			return "You have successfully passed through the dungeon. Congrats!";
		}
		default:
			return "Unknown command entered.";
		}
	}
}
