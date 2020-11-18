package it.unibo.oop.lab.exception2;

public class TransactionsQuotaException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2515369372793088961L;

	@Override
	public String getMessage() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "Error: the number of ATM transactions reached the maximum transaction allowed.";
	}

	
	
}
