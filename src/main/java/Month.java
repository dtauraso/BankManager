import java.util.ArrayList;

public class Month {

    // list of transaction ids for the month
    private ArrayList<Integer> transactionIDs;

    // total balance for the month
    private Double monthBalance;
    private Double balance;

    Month() {
        this.transactionIDs = new ArrayList<Integer>();
        this.balance = 0.0;
        this.monthBalance = 0.0;
    }
    public ArrayList<Integer> getTransactionIDs() {
        return this.transactionIDs;
    }
    public double getBalance() {
        return this.balance;
    }
    public double getMonthBalance() {
        return this.monthBalance;
    }
    public void setBalance(Double newBalance) {
        this.balance = newBalance;
    }
    public void setMonthBalance(Double newBalance) {
        this.monthBalance = newBalance;
    }
}
