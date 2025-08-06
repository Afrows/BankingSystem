import java.util.Scanner;

public class AccountCreation extends Account {

    private long userID;
    private String account;

    public AccountCreation(String accountNumber, double accountBalance, String customerName,
                           String email, int phoneNumber, String dateOfBirth, String password, String account, int pin, long userID) {
        super(accountNumber, accountBalance, customerName, email, phoneNumber, dateOfBirth, password, pin);
        this.userID = userID;
        this.account = account;
    }



    public void accountType() {
        StringBuilder border = new StringBuilder();
        border.append("*".repeat(12));

        Scanner accountType = new Scanner(System.in);

        do {
            System.out.println(border + " \n" +
                    border + " \n" +
                    " \n " + "Hello, what Account type would you like to have? \n 1. Current Account\n2. Savings Account\n" +
                    border + "\n" +
                    border);
        String type = accountType.nextLine();

        try {
            if (type.equals("1")) {
                currentAccount();
                break;
            }
            else if (type.equals("2")) {
                savingsAccount();
                break;
            } else
                continue;
        } catch (NullPointerException e) {
            System.out.println(border + " \n" +
                    border + " \n" + "Please press 1 for a Current Account or 2 for a Savings Account." +
                    border + " \n" +
                            border);
        }
    } while (true);
}

    public void currentAccount() {
        Scanner verifyChoiceC = new Scanner(System.in);

        do {
        System.out.println("""
                Welcome. Thank you for choosing us as your bank.
                You have selected a Current Account with us, is that correct?
                1. Yes
                2. No""");
            String verify = verifyChoiceC.nextLine();

            try {
                if (verify.equals("1")) {
                    account = "Current Account";
                    nameInformation();
                    break;
                }
                else if (verify.equals("2")) {
                    accountType();
                    break;
                }
                else
                    continue;
            } catch (NullPointerException f) {
                System.out.println("Please press either 1 or 2.");
            }
        } while (true);
    }

    public void savingsAccount() {
        Scanner verifyChoiceS = new Scanner(System.in);

        do {
            System.out.println("""
                    Welcome. Thank you for choosing us as your bank.
                    You have selected a Savings Account with us, is that correct?
                    1. Yes
                    2. No""");
            String verify = verifyChoiceS.nextLine();

            try {
                if (verify.equals("1")) {
                    account = "Savings Account";
                    nameInformation();
                    break;
                }
                else if (verify.equals("2")) {
                    accountType();
                    break;
                }
                else
                    continue;
            } catch (NullPointerException f) {
                System.out.println("Please press either 1 or 2.");
            }
        } while (true);

    }

    public void nameInformation() {

        Scanner name = new Scanner(System.in);

        do {
                System.out.println("Thank you for confirming that you want a " +
                        account + ".\n Please enter your full name: ");
                customerName = name.nextLine();

               try {
                   if (customerName.isBlank()) {
                       continue;
                   } else if (customerName.length() > 3) {
                       break;
                   } else
                       continue;
               } catch (NullPointerException e) {
                   System.out.println("Please enter your full name");
               }

        } while (true);

    }

}
