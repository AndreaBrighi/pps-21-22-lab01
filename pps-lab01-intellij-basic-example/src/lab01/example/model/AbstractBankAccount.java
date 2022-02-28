package lab01.example.model;

public abstract class AbstractBankAccount implements BankAccount {
    private double balance;
    private final AccountHolder holder;

    interface WithdrawFee {
        double calculateFee(double amount);
    }

    interface DepositFee {
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

    protected void deposit(final int userID, final double amount, DepositFee fee) {
        if (checkUser(userID)) {
            this.balance = balance + amount - fee.calculateFee(amount);
        }
    }

    protected void withdraw(final int userID, final double amount, WithdrawFee fee) {
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
