public class Bank {

    private String accountNumber;
    private double accountBalance;
    protected static  String customerName;
    protected static String emailAddress;
    private int phoneNumber;

    public Bank(String accountNumber, double accountBalance, String customerName, String emailAddress, int phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.phoneNumber = phoneNumber;
    }

    public Bank() {

    }

    public void spacing() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void textBorder() {
        StringBuilder border = new StringBuilder();
        border.append("*".repeat(64));
        System.out.println("\n" + border + "\n" + border +
                "\n");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
