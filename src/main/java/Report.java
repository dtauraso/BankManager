import java.util.ArrayList;
import java.util.HashMap;

public class Report {
    // reporting on the transactions
    ArrayList<String> transactionUnits;
    ArrayList<String> months;
    Report() {
        transactionUnits = new ArrayList<String>();
        months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

    }
    public String makeReport (HashMap<Integer, Month> monthTransactions, ArrayList<Transaction> transactions) {

        for(Integer i: monthTransactions.keySet()) {
            Month currentMonth = monthTransactions.get(i);
            transactionUnits.add(this.months.get(i));
            for(Integer j: currentMonth.getTransactionIDs()) {
                Transaction transaction = transactions.get(j);
                transactionUnits.add("\n  ");
                transactionUnits.add(transaction.toString());
            }
            transactionUnits.add("\n");

        }
        String history = "";
        for(String unit: transactionUnits) {
            history = history.concat(unit);
        }
        return history;
    }

}
