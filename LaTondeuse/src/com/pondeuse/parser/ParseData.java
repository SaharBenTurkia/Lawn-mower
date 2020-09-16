package com.pondeuse.parser;

import com.pondeuse.enumerations.Instructions;
import com.pondeuse.enumerations.Orientation;

public class ParseData {

	public static boolean parseMower(String mower) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.NORTH.getCodeOrientation()).append("|")
				.append(Orientation.SOUTH.getCodeOrientation()).append("|")
				.append(Orientation.EAST.getCodeOrientation()).append("|")
				.append(Orientation.WEST.getCodeOrientation());
		return mower.matches("(\\d+) (\\d+) (" + stringBuilder.toString() + ")");
	}

	public static boolean parseListInstruction(String instructions) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(Instructions.AVANCER.getCodeInstruction()).append("|")
				.append(Instructions.DROITE.getCodeInstruction()).append("|")
				.append(Instructions.GAUCHE.getCodeInstruction()).append(")+");

		return instructions.matches(stringBuilder.toString());
	}

	public static boolean parseLawn(String lawn) {
		return lawn.matches("(\\d+) (\\d+)");
	}
}
