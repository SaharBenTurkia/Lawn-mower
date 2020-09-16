package com.pondeuse.exceptions;

public class MowerException extends Exception{

	private static final long serialVersionUID = 1L;
    private String message;

    public MowerException(String m) {
        
        super(m);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
