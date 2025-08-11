public class Account extends Bank {

    protected String dateOfBirth;
    protected String password;
    protected int pin;
    protected boolean verification;

    public Account(String accountNumber, double accountBalance, String customerName,
                   String emailAddress, int phoneNumber, String dateOfBirth, String password, int pin) {
        super(accountNumber, accountBalance, customerName, emailAddress, phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.pin = pin;
    }

    public Account() {
        super();
    }

    public boolean has2FA() {
        return true;
    }

    public void verification() {
        return;
    }

    public void homeAddress() {
        return;
    }
}
