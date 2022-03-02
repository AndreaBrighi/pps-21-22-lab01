package lab01.example.model;

public abstract class AbstractBankAccount implements BankAccount {
    private double balance;
    private final AccountHolder holder;

    /**
     * Interface that allow to calculate the fee of the transaction
     */
    interface Fee {
        double calculateFee(double amount);
    }

    protected AbstractBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    /**
     * Allows the deposit of an amount on the account, if the given userID corresponds to the register holder ID
     * of the bank account. This ID acts like an "identification token" .
     *
     * @param userID the id of the user that wants do the deposit
     * @param amount the amount of the deposit
     * @param fee    the fee that has to be applied for the transaction
     */
    protected void deposit(final int userID, final double amount, Fee fee) {
        if (checkUser(userID)) {
            this.balance = balance + amount - fee.calculateFee(amount);
        }
    }

    /**
     * Allows the withdrawal of an amount from the account, if the given userID corresponds to the register holder ID
     * of the bank account. This ID acts like an "identification token" .
     *
     * @param userID the id of the user that wants do the withdrawal
     * @param amount the amount of the withdrawal
     * @param fee    the fee that has to be applied for the transaction
     */
    protected void withdraw(final int userID, final double amount, Fee fee) {
        if (checkUser(userID) && isWithdrawAllowed(amount + fee.calculateFee(amount))) {
            this.balance = this.balance - (amount + fee.calculateFee(amount));
        }
    }

    private boolean isWithdrawAllowed(final double amount) {
        return this.balance >= amount;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
