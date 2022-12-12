import java.util.ArrayList;
import java.util.HashMap;

public class Account {

    private Double balance;
    private final String firstName;
    private final String lastName;
    private final String accountKind;

    private Integer currentMonth;
    private final ArrayList<Transaction> transactions;

    private final HashMap<Integer, Month> monthTransactions;

    Account(Double balance, String firstName, String lastName, String accountKind) {
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountKind = accountKind;
        this.currentMonth = -1;
        this.transactions = new ArrayList<Transaction>();
        this.monthTransactions = new HashMap<Integer, Month>();

    }
    @Override
    public String toString() {
        return  this.balance + " " +
                this.firstName + " " +
                this.lastName + " " +
                this.accountKind + "\n";
    }
    private void initMonthTransactions(Integer month) {
        if(this.currentMonth != month) {
            this.currentMonth = month;
            this.monthTransactions.put(month, new Month());
        }
    }
    public void deposit(Double newAmount, Integer month) {
        this.balance += newAmount;
        this.transactions.add(new Transaction(true, newAmount));
        initMonthTransactions(month);

        Month currentMonth = this.monthTransactions.get(month);
        currentMonth.getTransactionIDs().add(this.transactions.size() - 1);

        currentMonth.setBalance(this.balance);
        currentMonth.setMonthBalance(currentMonth.getMonthBalance() + newAmount);

    }
    public void withdraw(Double amount, Integer month) {
        this.balance -= amount;
        this.transactions.add(new Transaction(false, amount));
        initMonthTransactions(month);

        Month currentMonth = this.monthTransactions.get(month);
        currentMonth.getTransactionIDs().add(this.transactions.size() - 1);

        currentMonth.setBalance(this.balance);
        currentMonth.setMonthBalance(currentMonth.getMonthBalance() - amount);


    }
    public String viewTransactions(Integer month) {

        String transactionHistory = "";
        Integer currentMonth = -1;
        for(int i: this.monthTransactions.get(month).getTransactionIDs()) {
            Transaction transaction = this.transactions.get(i);
            if(!month.equals(currentMonth)) {
                currentMonth = month;
                transactionHistory = transactionHistory.concat("\n");
                transactionHistory = transactionHistory.concat(month.toString());
                transactionHistory = transactionHistory.concat("\n");
            }
            transactionHistory = transactionHistory.concat(transaction.toString());
            transactionHistory = transactionHistory.concat("\n");
        }
        return transactionHistory;
    }
    public String getTransactionReport() {

        String transactionHistory = "";
        // list of transactions by month
        for(Integer month: this.monthTransactions.keySet()) {
            transactionHistory = transactionHistory.concat(viewTransactions(month));
            Month currentMonth = this.monthTransactions.get(month);
            transactionHistory = transactionHistory.concat(String.valueOf(currentMonth.getMonthBalance()));
            transactionHistory = transactionHistory.concat("\n");
            transactionHistory = transactionHistory.concat(String.valueOf(currentMonth.getBalance()));

        }

        return transactionHistory;
    }
}
