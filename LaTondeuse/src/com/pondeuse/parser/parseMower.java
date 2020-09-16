package com.pondeuse.parser;

public class parseMower {

	private String lawn; // pelouse
	private String mower; // tondeuse
	private String instructions;

	public parseMower() {
		this.lawn = "";
		this.mower = "";
		this.instructions = "";
	}

	// Return true if mower's informations are incorrect else false
	public boolean executeParse() {
		return ParseData.parseMower(mower) && ParseData.parseLawn(lawn)
				&& ParseData.parseListInstruction(instructions);
	}

	public String getLawn() {
		return lawn;
	}

	public void setLawn(String lawn) {
		this.lawn = lawn;
	}

	public String getMower() {
		return mower;
	}

	public void setMower(String mower) {
		this.mower = mower;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

}
