package com.pondeuse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pondeuse.constants.Constants;
import com.pondeuse.exceptions.MowerException;
import com.pondeuse.parser.parseMower;
import com.pondeuse.treatment.FormatLine;
import com.pondeuse.treatment.MowerTreatment;

public class Main {

	protected static List<String> resultList;

	public static void main(String... args) throws MowerException, IOException {
		if (args.length == 1) {
			File file = new File(args[0]);
			Main instance = new Main();
			resultList = instance.executeMowerTreatments(file);
		} else {
			throw new IllegalArgumentException();
		}
	}

	// read & validate file & execute mowers
	private List<String> executeMowerTreatments(File fichier) throws MowerException, IOException {
		if (!fichier.isFile()) {
			throw new MowerException(Constants.ERROR_INEXISTANT_FILE);
		} else {
			parseMower parser = new parseMower();
			Scanner scanner = new Scanner(fichier);
			try {
				TreatFirstLine(parser, scanner);
				return TreatNextLines(parser, scanner);
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
	}

	// treat first line in file
	protected void TreatFirstLine(parseMower parser, Scanner scanner) throws MowerException {
		if (scanner.hasNext()) {
			parser.setLawn(scanner.nextLine());
		}
		if (!scanner.hasNext()) {
			throw new MowerException(Constants.ERROR_INCORRECT_DATA);
		}
	}

	// return mower's position
	private List<String> TreatNextLines(parseMower parser, Scanner scanner) throws MowerException {
		List<String> positionList = new ArrayList<String>();
		while (scanner.hasNext()) {
			// read intial line
			parser.setMower(scanner.nextLine());

			if (scanner.hasNext()) {
				parser.setInstructions(scanner.nextLine());
				positionList.add(parseAndExecuteTreatment(parser));
			} else {
				throw new MowerException(Constants.ERROR_INCORRECT_DATA);
			}
		}
		return positionList;
	}

	// parse and execute mower's treatment
	private String parseAndExecuteTreatment(parseMower parser) throws MowerException {
		if (!parser.executeParse()) {
			throw new MowerException(Constants.ERROR_INCORRECT_DATA);
		} else {
			MowerTreatment treatment = new MowerTreatment();
			treatment.setLawn(FormatLine.formatLawnLine(parser.getLawn()));
			treatment.setPosition(FormatLine.formatMowerLine(parser.getMower()));
			treatment.setInstructionList(FormatLine.formatInstructionLine(parser.getInstructions()));
			treatment.executeInstructions();
			System.out.println(treatment);
			return treatment.toString();
		}
	}
}
