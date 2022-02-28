import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest {

    @BeforeEach
    @Override
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testWithdrawATM() {
        SimpleBankAccountWithAtm bankAccount = (SimpleBankAccountWithAtm) this.bankAccount;
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdrawWithATM(1, 79);
        assertEquals(20, bankAccount.getBalance());
    }

    @Test
    void testDepositATM() {
        SimpleBankAccountWithAtm bankAccount = (SimpleBankAccountWithAtm) this.bankAccount;
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.DepositWithATM(1, 21);
        assertEquals(120, bankAccount.getBalance());
    }
}