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

    private final Report transactionReport;

    Account() {
        this.balance = 0.0;
        this.firstName = "";
        this.lastName = "";
        this.accountKind = "";
        this.currentMonth = -1;
        this.transactions = new ArrayList<Transaction>();
        this.monthTransactions = new HashMap<Integer, Month>();
        this.transactionReport = new Report();

    }
    Account(Double balance, String firstName, String lastName, String accountKind) {
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountKind = accountKind;
        this.currentMonth = -1;
        this.transactions = new ArrayList<Transaction>();
        this.monthTransactions = new HashMap<Integer, Month>();
        this.transactionReport = new Report();

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
    private void updateAccount(Boolean isAdded, Double newAmount, Integer month) {

        if(isAdded) {
            this.balance += newAmount;
        }
        else {
            this.balance -= newAmount;
        }

        this.transactions.add(new Transaction(true, newAmount));
        initMonthTransactions(month);
        Month currentMonth = this.monthTransactions.get(month);
        currentMonth.getTransactionIDs().add(this.transactions.size() - 1);
        currentMonth.setBalance(this.balance);

        if(isAdded) {
            currentMonth.setMonthBalance(currentMonth.getMonthBalance() + newAmount);
        }
        else {
            currentMonth.setMonthBalance(currentMonth.getMonthBalance() - newAmount);
        }
    }
    public void deposit(Double newAmount, Integer month) {
        this.updateAccount(true, newAmount, month);
    }
    public void withdraw(Double newAmount, Integer month) {

        this.updateAccount(false, newAmount, month);
    }
    public String getReport() {
        return this.transactionReport.makeReport(this.monthTransactions, this.transactions);
    }
}
