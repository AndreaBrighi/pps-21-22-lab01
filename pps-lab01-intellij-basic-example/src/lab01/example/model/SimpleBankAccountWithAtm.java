package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account with Atm allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 * These actions can be done via ATM
 */
public class SimpleBankAccountWithAtm extends AbstractBankAccount {

    /**
     * The ways that can be done a transaction.
     * Each of them have different fee
     */
    private enum TransactionType implements Fee {
        ATM {
            @Override
            public double calculateFee(double amount) {
                return 1;
            }
        },
        NORMAL {
            @Override
            public double calculateFee(double amount) {
                return 0;
            }
        }
    }

    public SimpleBankAccountWithAtm(AccountHolder accountHolder, int balance) {
        super(accountHolder, balance);
    }

    @Override
    public void withdraw(int userID, double amount) {
        withdraw(userID, amount, TransactionType.NORMAL);
    }

    /**
     * Allows the withdrawal of an amount from the account via ATM, if the given userID corresponds to the register holder ID
     * of the bank account. This ID acts like an "identification token" .
     *
     * @param userID the id of the user that wants do the withdrawal
     * @param amount the amount of the withdrawal
     */
    public void withdrawWithATM(int userID, double amount) {
        withdraw(userID, amount, TransactionType.ATM);
    }

    @Override
    public void deposit(int userID, double amount) {
        deposit(userID, amount, TransactionType.NORMAL);
    }

    /**
     * Allows the deposit of an amount on the account via ATM, if the given userID corresponds to the register holder ID
     * of the bank account. This ID acts like an "identification token" .
     *
     * @param userID the id of the user that wants do the deposit
     * @param amount the amount of the deposit
     */
    public void DepositWithATM(int userID, double amount) {
        deposit(userID, amount, TransactionType.ATM);
    }
}
