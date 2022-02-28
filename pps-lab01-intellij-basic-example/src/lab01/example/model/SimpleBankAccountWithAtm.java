package lab01.example.model;

public class SimpleBankAccountWithAtm extends AbstractBankAccount {

    enum WithdrawType implements WithdrawFee {
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

    enum DepositType implements DepositFee {
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
        withdraw(userID, amount, WithdrawType.NORMAL);
    }

    public void withdrawWithATM(int userID, double amount) {
        withdraw(userID, amount, WithdrawType.ATM);
    }

    @Override
    public void deposit(int userID, double amount) {
        deposit(userID, amount, DepositType.NORMAL);
    }

    public void DepositWithATM(int userID, double amount) {
        deposit(userID, amount, DepositType.ATM);
    }
}
