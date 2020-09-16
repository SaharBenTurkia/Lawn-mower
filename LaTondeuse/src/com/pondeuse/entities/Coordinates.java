package com.pondeuse.entities;

public class Coordinates {

	private int x;
	private int y;

	public Coordinates(int x, int y) {
		super();
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

	public boolean isBehindCoordinatesMax(Coordinates pCoordonnees) {
		return pCoordonnees.getX() >= 0 && pCoordonnees.getY() >= 0 && pCoordonnees.getX() <= this.x
				&& pCoordonnees.getY() <= this.y;
	}
}
