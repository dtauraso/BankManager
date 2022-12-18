import java.util.HashMap;

public class Bank {

    public HashMap<String, Account> users;

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
        myBank.users.put("username 2", new Account(1.6543, "first Nyhgfrdame", "last tfdName", "checking"));

        myBank.users.get("username 1").deposit(20.0, 0);
        myBank.users.get("username 1").deposit(20.0, 0);
        myBank.users.get("username 1").withdraw(10.0, 0);

        myBank.users.get("username 1").deposit(30.0, 1);
        myBank.users.get("username 1").deposit(30.0, 1);
        myBank.users.get("username 1").withdraw(20.0, 1);
        myBank.users.get("username 1").deposit(40.0, 2);
        myBank.users.get("username 1").deposit(40.0, 2);
        myBank.users.get("username 1").withdraw(30.0, 2);

        Account user = myBank.users.get("username 1");
        System.out.println(user.getReport());

    }
}
