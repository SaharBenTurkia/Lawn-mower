package com.pondeuse.enumerations;

public enum Orientation {

	NORTH('N', "Nord"), EAST('E', "est"), WEST('W', "ouest"), SOUTH('S', "sud");

	private char codeOrientation;
	private String libelleOrientation;

	private Orientation(char pCodeOrientation, String pLibelleOrientation) {
		this.codeOrientation = pCodeOrientation;
		this.libelleOrientation = pLibelleOrientation;
	}

	public char getCodeOrientation() {
		return codeOrientation;
	}

	public String getLibelleOrientation() {
		return libelleOrientation;
	}
}
