package it.unibo.oop.lab.exception1;

import java.util.Arrays;

public class NotEnoughBatteryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -288979685441144222L;

	public NotEnoughBatteryException() {
		super();
	}

	@Override
	public String toString() {
		return "The robot cannot move yet, the battery is exhausted";
	}
	
	public String getMessage() {
        return this.toString();
    }
}
