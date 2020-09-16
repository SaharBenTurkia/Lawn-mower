package com.pondeuse.treatment;

import com.pondeuse.constants.Constants;
import com.pondeuse.entities.Coordinates;
import com.pondeuse.entities.Position;
import com.pondeuse.enumerations.Instructions;
import com.pondeuse.enumerations.Orientation;
import com.pondeuse.exceptions.MowerException;

public class InstructionTreatment {

	private InstructionTreatment() {

	}

	// move forward tondeuse & return the new coordinates
	// parameters: position Tondeuse & position limit
	public static Coordinates moveForwardTondeuse(Position position, Coordinates coordinatesMax)
			throws MowerException {
		Coordinates nextCoordinates = null;
		int x, y;
		switch (position.getOrientation()) {
		case NORTH:
			x = position.getCoordinates().getX();
			y = position.getCoordinates().getY() + 1;
			break;
		case EAST:
			x = position.getCoordinates().getX() + 1;
			y = position.getCoordinates().getY();
			break;
		case SOUTH:
			x = position.getCoordinates().getX();
			y = position.getCoordinates().getY() - 1;
			break;
		case WEST:
			x = position.getCoordinates().getX() - 1;
			y = position.getCoordinates().getY();
			break;
		default:
			throw new MowerException(Constants.INCORRECT_POSITION);
		}
		nextCoordinates = new Coordinates(x, y);
		// if the new coordinates are behind of lawn, we keep the last position
		if (nextCoordinates != null && coordinatesMax.isBehindCoordinatesMax(nextCoordinates)) {
			return nextCoordinates;
		} else {
			return position.getCoordinates();
		}
	}

	// turn right la tondeuse & return the new coordinates
	public static Orientation pivoterDroite(Orientation orientation) throws MowerException {
		Orientation nextOrientation = null;
		switch (orientation) {
		case NORTH:
			nextOrientation = Orientation.EAST;
			break;
		case EAST:
			nextOrientation = Orientation.SOUTH;
			break;
		case SOUTH:
			nextOrientation = Orientation.WEST;
			break;
		case WEST:
			nextOrientation = Orientation.NORTH;
			break;
		default:
			throw new MowerException(Constants.INCORRECT_ORIENTATION);
		}
		return nextOrientation;
	}

	// turn left la tondeuse & return the new coordinates
	public static Orientation pivoterGauche(Orientation orientation) throws MowerException {
		Orientation nextOrientation = null;
		switch (orientation) {
		case NORTH:
			nextOrientation = Orientation.WEST;
			break;
		case EAST:
			nextOrientation = Orientation.NORTH;
			break;
		case SOUTH:
			nextOrientation = Orientation.EAST;
			break;
		case WEST:
			nextOrientation = Orientation.SOUTH;
			break;
		default:
			throw new MowerException(Constants.INCORRECT_ORIENTATION);
		}
		return nextOrientation;
	}

	// execute only one instruction ( A, D ou G)
	public static void executeInstruction(Position position, Instructions instruction, Coordinates coordonnesMax)
			throws MowerException {

		switch (instruction) {
		case AVANCER:
			position.setCoordinates(InstructionTreatment.moveForwardTondeuse(position, coordonnesMax));
			break;
		case DROITE:
			position.setOrientation(InstructionTreatment.pivoterDroite(position.getOrientation()));
			break;
		case GAUCHE:
			position.setOrientation(InstructionTreatment.pivoterGauche(position.getOrientation()));
			break;
		default:
			throw new MowerException(Constants.INSTRUCTION_INCORRECTE);
		}
	}
}
