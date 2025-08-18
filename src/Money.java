public class Money extends Bank {

    public Money(String accountNumber, double accountBalance, String customerName, String emailAddress, int phoneNumber) {
        super(accountNumber, accountBalance, customerName, emailAddress, phoneNumber);
    }

    public Money() {
    }

    public boolean deposit() {

        return false;
    }

    public boolean withdraw() {

        return false;
    }

    public boolean showBalance() {

        return false;
    }
}
