package com.pondeuse.enumerations;

public enum Instructions {

	DROITE('D', "Pivoter à droite"),
    GAUCHE('G', "Pivoter à gauche"),
    AVANCER('A', "Avancer");

    private String libelleInstruction;
    private char codeInstruction;

    private Instructions(char pCodeInstruction, String libelleInstruction) {
        this.libelleInstruction = libelleInstruction;
        this.codeInstruction = pCodeInstruction;
    }

    public String getLibelleInstruction() {
        return libelleInstruction;
    }

    public char getCodeInstruction() {
        return codeInstruction;
    }
}
