package bg.uni.sofia.fmi.mjt.dungeon.actor;

public class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Position move(int i) {
		switch (i) {
		case 1:
			return new Position(x - 1, y);
		case 0:
			return new Position(x, y - 1);
		case 3:
			return new Position(x + 1, y);
		case 2:
			return new Position(x, y + 1);
		default:
			return new Position(x, y);
		}
	}
	/*
	 * public isValid(char[][] map) { return x >= 0 && y >= 0 && }
	 */
}
