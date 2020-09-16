package com.pondeuse.treatment;

import java.util.ArrayList;
import java.util.List;

import com.pondeuse.entities.Position;
import com.pondeuse.entities.Lawn;
import com.pondeuse.enumerations.Instructions;
import com.pondeuse.exceptions.MowerException;

public class MowerTreatment {

	private Lawn lawn;
	private Position position;
	private List<Instructions> instructionList;

	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setInstructionList(List<Instructions> pInstructionList) {
		this.instructionList = pInstructionList;
		if (pInstructionList == null) {
			instructionList = new ArrayList<Instructions>();
		}
	}

	// execute the group of instructions per mower
	public void executeInstructions() throws MowerException {
		for (Instructions instruction : instructionList) {
			InstructionTreatment.executeInstruction(position, instruction, this.lawn.getPositionMax());
		}
	}

	@Override
	public String toString() {
		return position.getCoordinates().getX() + " " + position.getCoordinates().getY() + " "
				+ position.getOrientation().getCodeOrientation();
	}
}
