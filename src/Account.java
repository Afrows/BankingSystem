public class Account extends Bank {

    private String dateOfBirth;
    private String password;
    private int pin;

    public Account(String accountNumber, double accountBalance, String customerName,
                   String email, int phoneNumber, String dateOfBirth, String password, int pin) {
        super(accountNumber, accountBalance, customerName, email, phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.pin = pin;
    }



    public boolean has2FA() {

    }

    public void verification() {

    }

    public void homeAddress() {

    }
}
