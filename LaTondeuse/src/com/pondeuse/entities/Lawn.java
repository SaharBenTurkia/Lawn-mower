package com.pondeuse.entities;

public class Lawn {

	private Coordinates positionMax;
    

	public Lawn(Coordinates positionMax) {
		super();
		this.positionMax = positionMax;
	}

	public Coordinates getPositionMax() {
		return positionMax;
	}

	public void setPositionMax(Coordinates positionMax) {
		this.positionMax = positionMax;
	}

}
