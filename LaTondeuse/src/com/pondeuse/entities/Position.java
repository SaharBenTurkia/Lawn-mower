package com.pondeuse.entities;

import com.pondeuse.enumerations.Orientation;

public class Position {

	private Coordinates coordinates;
	private Orientation orientation;

	public Position(Coordinates coordinates, Orientation orientation) {
		super();
		this.coordinates = coordinates;
		this.orientation = orientation;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

}
