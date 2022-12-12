public class Transaction {

    private Boolean isAdded;
    private Double amount;
    Transaction(boolean isAdded, Double amount) {
        this.amount = amount;
        this.isAdded = isAdded;
    }

    @Override
    public String toString() {
        return (this.isAdded? "+ ": "- ") + this.amount.toString();
    }
}
