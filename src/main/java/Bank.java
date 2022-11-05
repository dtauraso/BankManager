import java.util.ArrayList;
import java.util.Map;
//import javax.swing.JButton

public class Bank {

    // handling online money deposits and withdrawals
    public Map<String, Account> users;

    // handling physical money deposits and withdrawals
    public ArrayList<Teller> tellers;
    public static double totalMoneyInBankBuilding = 0;

    protected static String something;
    Bank() {
    }

    public String toString() {

        String accounts = "";
        for(Account account: this.users.values()) {
            accounts = accounts.concat(account.toString().concat(" "));
        }
        return accounts;
    }

    // addUser
    public void addUser(String userName, double balance, String firstName, String lastName, String accountKind) {
        this.users.put(userName, new Account(balance, firstName, lastName, accountKind));

    }
    // deleteUser
    public void deleteUser(String userName) {
        this.users.remove(userName);
    }
    public static void main(String[] args) {

        Bank myBank = new Bank();

//        myBank.users.get(0).setupAccount(1.2, "firstName", "lastName", "savings");
//        myBank.users.get(1).setupAccount(1.6543, "firstNyhgfrdame", "lasttfdName", "checking");

        System.out.println("test");
    }
}
