package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount extends AbstractBankAccount {

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(int userID, double amount) {
        deposit(userID, amount, a -> 0);
    }

    @Override
    public void withdraw(int userID, double amount) {
        withdraw(userID, amount, a -> 0);
    }
}
