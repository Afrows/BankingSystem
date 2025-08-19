import java.util.Scanner;

public class AccountCreation extends Account {

    private String account;

    public AccountCreation(String accountNumber, double accountBalance, String customerName,
                           String emailAddress, int phoneNumber, String dateOfBirth, String password, String account, int pin) {
        super(accountNumber, accountBalance, customerName, emailAddress, phoneNumber, dateOfBirth, password, pin);
        this.account = account;
    }

    public AccountCreation() {
    }

    public void accountType() {
        StringBuilder border = new StringBuilder();
        border.append("*".repeat(30));

        Scanner accountType = new Scanner(System.in);

        do {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }

            System.out.println(border + " \n" +
                    border + """
                    \n
                    Hello, what Account type would you like to have?
                    1. Current Account
                    2. Savings Account\n\n
                    """+
                    border + "\n" +
                    border);
            String type = accountType.nextLine();

            try {
                switch (Integer.parseInt(type)) {
                    case 1 -> currentAccount();
                    case 2 -> savingsAccount();
                }
            } catch (NullPointerException e) {
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                System.out.println(border + " \n" +
                        border + """
                        
                        Please press 1 for a Current Account or 2 for a Savings Account.
                        
                        """ +
                        border + " \n" +
                        border);
                }
        } while (true);
    }

    public void currentAccount() {
        Scanner verifyChoiceC = new Scanner(System.in);

        do {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
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
                } else if (verify.equals("2")) {
                    accountType();
                    break;
                }
            } catch (NullPointerException f) {
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                System.out.println("Please press either 1 or 2.");
            }
        } while (true);
    }

    public void savingsAccount() {
        Scanner verifyChoiceS = new Scanner(System.in);

        do {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
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
                } else if (verify.equals("2")) {
                    accountType();
                    break;
                }
            } catch (NullPointerException e) {
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                System.out.println("Please press either 1 or 2.");
            }
        } while (true);
    }

    public void nameInformation() {
        Scanner name = new Scanner(System.in);
        do {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            System.out.println("Thank you for confirming that you want a " +
                    account + ".\n Please enter your full name: ");
            customerName = name.nextLine();

            try {
                if (customerName.isBlank()) {
                    continue;
                } else if (customerName.length() > 3) {
                    dobInformation();
                    break;
                }
            } catch (NullPointerException e) {
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                System.out.println("Please enter your full name: ");
            }
        } while (true);
    }

    public void dobInformation() {
        Scanner dob = new Scanner(System.in);

        do {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            System.out.println("Please enter your date of birth in a DD/MM/YYYY format: ");
            dateOfBirth = dob.nextLine();

            if (dateOfBirth.contains("/") && dateOfBirth.length() == 10) {
                int age = (2025 - Integer.parseInt(dateOfBirth.substring(6)));
                System.out.println("You are " + age + " years old.");
                emailInformation();
                break;
            }
        } while (true);
    }


    public void emailInformation() {
        Scanner email = new Scanner(System.in);

        do {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            System.out.println("Please enter your email address: ");
            emailAddress = email.nextLine();

            {
                if (emailAddress.contains("@gmail") || emailAddress.contains("@hotmail")
                        || emailAddress.contains("@outlook") || emailAddress.contains("@Yahoo")) {
                    enableTwoFactor();
                    break;
                } else {
                    System.out.println("Emails we support are: Gmail, Hotmail, Yahoo & Outlook");
                }
            }
        } while (true);
    }

    public void enableTwoFactor() {
        Scanner twoFactor = new Scanner(System.in);
        do {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            System.out.println("""
                    Would you like to enable two factor authentication?
                    1. Yes
                    2. No
                    """);
            String TFA = twoFactor.nextLine();

           try {
               if (TFA.equals("1")) {
                   createPin();
                   verification = true;
               } else if (TFA.equals("2")) {
                    createPassword();
                    verification = false;
               }
           } catch (NullPointerException e) {
               System.out.println("""
                       Would you like to enable two factor authentication?
                    1. Yes
                    2. No
                    """);
           }
        } while (true);
    }

    public void createPin() {
        Scanner makePin = new Scanner(System.in);

        do {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            System.out.println("Please enter a 6 digit pin: ");
            String newPin = makePin.nextLine();

           try {
               if (newPin.length() == 6) {
                   pin = Integer.parseInt(newPin);
                   verification = true;
                   if (pinRestart) {
                       MainMenu main = new MainMenu();
                       System.out.println(main);
                   }
                   else {
                       createPassword();
                       break;
                   }
               }
           } catch (NumberFormatException e) {
               System.out.println("The pin can only be integers!");
           }
        } while (true);
    }

    public void createPassword() {
        Scanner makePassword = new Scanner(System.in);

        do {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            System.out.println("Please create a password: ");
            password = makePassword.nextLine();

            if (password.length() > 7) {
                MainMenu main = new MainMenu();
                System.out.println(main);
                break;
            }
            else {
                System.out.println("Password needs to be more than 7 Characters!");
            }
        } while (true);
    }
}
