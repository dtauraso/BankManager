public class Account {

    private double balance;
    private String firstName;
    private String lastName;
    private String accountKind;

    Account(double balance, String firstName, String lastName, String accountKind) {
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountKind = accountKind;
    }
    public void setupAccount(double balance, String firstName, String lastName, String accountKind) {

        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountKind = accountKind;
    }
    @Override
    public String toString() {
        return this.balance + " " + this.firstName + " " + this.lastName + " " + this.accountKind;
    }
    // deposit
    // withdraw
    // checkBalance
}
