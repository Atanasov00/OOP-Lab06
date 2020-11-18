package it.unibo.oop.lab.exception2;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

	private static final double INITIAL_AMOUNT = 1_000_0;
	private static final int INITIAL_ATM_TRANSACTION = 10;
    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
    	
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	AccountHolder usr1 = new AccountHolder("Atanas", "Atanasov", 111);
    	AccountHolder usr2 = new AccountHolder("Andrea", "Foschi", 112);
    	
    	BankAccount account1 = new StrictBankAccount(usr1.getUserID(), INITIAL_AMOUNT, INITIAL_ATM_TRANSACTION);
    	BankAccount account2 = new StrictBankAccount(usr2.getUserID(), INITIAL_AMOUNT, INITIAL_ATM_TRANSACTION);
    	
    	try {
    		account1.withdraw(usr1.getUserID(), 100);
    		account2.withdraw(usr2.getUserID(), 1000);
    		for(int i = 0; i < INITIAL_ATM_TRANSACTION; i++) {
    			account1.withdrawFromATM(usr1.getUserID(), 1);
    		}
    	}
    	catch(WrongAccountHolderException | NotEnoughFoundsException | TransactionsQuotaException e){
    		Assert.assertNotNull(e);
    		System.out.println(e.getMessage());
    	}
    }
}
