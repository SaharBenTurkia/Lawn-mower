package com.pondeuse.treatment;

import java.util.ArrayList;
import java.util.List;

import com.pondeuse.entities.Coordinates;
import com.pondeuse.entities.Position;
import com.pondeuse.entities.Lawn;
import com.pondeuse.enumerations.Instructions;
import com.pondeuse.enumerations.Orientation;

public class FormatLine {

	private static final String SPACE_STRING = " ";

	private FormatLine() {

	}

	// recup mower's position
	public static Position formatMowerLine(String mowerLine) {
		String[] elts = mowerLine.split(SPACE_STRING);
		Coordinates pMowerCoordinates = new Coordinates(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
		Orientation mowerOrientation = getOrientation(elts[2].charAt(0));
		return new Position(pMowerCoordinates, mowerOrientation);
	}

	// recup lawn
	public static Lawn formatLawnLine(String lignePelouse) {
		String[] elts = lignePelouse.split(SPACE_STRING);
		return new Lawn(new Coordinates(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
	}

	// recup instruction list enum
	public static List<Instructions> formatInstructionLine(String ligneInstruction) {
		List<Instructions> listInstruction = new ArrayList<Instructions>();
		for (char instruction : ligneInstruction.toCharArray()) {
			listInstruction.add(getInstruction(instruction));
		}
		return listInstruction;
	}

	// recup orientation enum corresponding to character
	public static Orientation getOrientation(char cOrientation) {
		for (Orientation orientation : Orientation.values()) {
			if (orientation.getCodeOrientation() == cOrientation) {
				return orientation;
			}
		}
		return null;
	}

	// recup instruction enum
	public static Instructions getInstruction(char cInstruction) {
		for (Instructions instruction : Instructions.values()) {
			if (instruction.getCodeInstruction() == cInstruction) {
				return instruction;
			}
		}
		return null;
	}
}
