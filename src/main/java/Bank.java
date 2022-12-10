import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import javax.swing.JButton

public class Bank {

    public Map<String, Account> users;

    public static double totalMoneyInBankBuilding = 0;

    protected static String something;
    Bank() {
        users = new HashMap<>(3);
    }

    public String toString() {

        String accounts = "";
        for(Account account: this.users.values()) {
            accounts = accounts.concat(account.toString().concat("\n"));

        }
        return accounts;
    }

    public static void main(String[] args) {

        Bank myBank = new Bank();

        myBank.users.put("username 1", new Account(1.2,"firstName", "lastName", "savings"));
        myBank.users.put("username 2",new Account(1.6543, "firstNyhgfrdame", "lasttfdName", "checking"));

        System.out.println(myBank.toString());
    }
}
