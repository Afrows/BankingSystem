public class Account extends Bank {

    protected String dateOfBirth;
    protected static String password;
    protected static int pin;
    protected static boolean verification;
    protected static boolean pinRestart;

    public Account(double accountBalance, String dateOfBirth) {
        super(accountBalance);
        this.dateOfBirth = dateOfBirth;
    }

    public Account() {

    }
}