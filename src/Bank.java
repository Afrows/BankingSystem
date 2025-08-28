public class Bank {

    protected double accountBalance;
    protected static String customerName;
    protected static String emailAddress;

    public Bank(double accountBalance) {
        this.accountBalance = accountBalance;
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

    public void loading() throws InterruptedException {
        String message = "Loading";
        for (int i = 0; i < 4; i++) {
            System.out.println("\r" + message + ".".repeat(i));
            Thread.sleep(500);
        }

    }
}