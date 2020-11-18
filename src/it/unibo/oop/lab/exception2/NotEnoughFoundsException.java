package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends UnsupportedOperationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1159808475879283028L;

	@Override
	public String getMessage() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "There isn't enough money for complete the draw operation";
	}
	
}
