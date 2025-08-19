public class Account extends Bank {

    protected String dateOfBirth;
    protected static String password;
    protected static int pin;
    protected static boolean verification;
    protected static boolean pinRestart;

    public Account(String accountNumber, double accountBalance, String customerName,
                   String emailAddress, int phoneNumber, String dateOfBirth, String password, int pin) {
        super(accountNumber, accountBalance, customerName, emailAddress, phoneNumber);
        this.dateOfBirth = dateOfBirth;
    }

    public Account() {
    }
}
