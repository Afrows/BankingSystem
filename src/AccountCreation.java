import java.util.Scanner;

public class AccountCreation extends Account {

    private long userID;
    private String account;

    public AccountCreation(String accountNumber, double accountBalance, String customerName,
                           String emailAddress, int phoneNumber, String dateOfBirth, String password, String account, int pin, long userID) {
        super(accountNumber, accountBalance, customerName, emailAddress, phoneNumber, dateOfBirth, password, pin);
        this.userID = userID;
        this.account = account;
    }

    public AccountCreation() {
        super();
        System.out.println(accountType());
    }

    public boolean accountType() {
        StringBuilder border = new StringBuilder();
        border.append("*".repeat(30));

        Scanner accountType = new Scanner(System.in);

        do {
            System.out.flush();
            System.out.println(border + " \n" +
                    border + " \n" +
                    " \n" + "Hello, what Account type would you like to have? \n1. Current Account\n2. Savings Account\n\n" +
                    border + "\n" +
                    border);
            String type = accountType.nextLine();

            try {
                if (type.equals("1")) {
                    currentAccount();
                    break;
                } else if (type.equals("2")) {
                    savingsAccount();
                    break;
                } else
                    continue;
            } catch (NullPointerException e) {
                System.out.flush();
                System.out.println(border + " \n" +
                        border + " \n" + "Please press 1 for a Current Account or 2 for a Savings Account." +
                        border + " \n" +
                        border);
            }
        } while (true);
        return false;
    }

    public void currentAccount() {
        Scanner verifyChoiceC = new Scanner(System.in);

        do {
            System.out.flush();
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
                } else
                    continue;
            } catch (NullPointerException f) {
                System.out.flush();
                System.out.println("Please press either 1 or 2.");
            }
        } while (true);
        return;
    }

    public void savingsAccount() {
        Scanner verifyChoiceS = new Scanner(System.in);

        do {
            System.out.flush();
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
                } else
                    continue;
            } catch (NullPointerException f) {
                System.out.flush();
                System.out.println("Please press either 1 or 2.");
            }
        } while (true);
        return;
    }

    public void nameInformation() {

        Scanner name = new Scanner(System.in);

        do {
            System.out.flush();
            System.out.println("Thank you for confirming that you want a " +
                    account + ".\n Please enter your full name: ");
            customerName = name.nextLine();

            try {
                if (customerName.isBlank()) {
                    continue;
                } else if (customerName.length() > 3) {
                    dobInformation();
                    break;
                } else
                    continue;
            } catch (NullPointerException e) {
                System.out.flush();
                System.out.println("Please enter your full name: ");
            }

        } while (true);
        return;
    }

    public void dobInformation() {
        Scanner dob = new Scanner(System.in);

        do {
            System.out.flush();
            System.out.println("Please enter your date of birth in a DD/MM/YYYY format: ");
            dateOfBirth = dob.nextLine();

            if (dateOfBirth.contains("/") && dateOfBirth.length() == 10) {
                int age = (2025 - Integer.parseInt(dateOfBirth.substring(6)));
                System.out.println("You are " + age + " years old.");
                emailInformation();
                break;
            } else
                continue;
        } while (true);

        return;
    }


    public void emailInformation() {
        Scanner email = new Scanner(System.in);

        do {
            System.out.flush();
            System.out.println("Please enter your email address: ");
            emailAddress = email.nextLine();

            {
                if (emailAddress.contains("@gmail") || emailAddress.contains("@hotmail") || emailAddress.contains("@outlook") || emailAddress.contains("@Yahoo")) {
                    enableTwoFactor();
                    break;
                } else {
                    System.out.println("Emails we support are: Gmail, Hotmail, Yahoo & Outlook");
                    continue;
                }
            }
        } while (true);
        return;
    }

    public void enableTwoFactor() {
        Scanner twoFactor = new Scanner(System.in);

        do {
            System.out.flush();
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
               else
                   continue;
           } catch (NullPointerException e) {
               System.out.println("""
                       Would you like to enable two factor authentication?
                    1. Yes
                    2. No
                    """);
           }
            return;
        } while (true);
    }

    public void createPin() {
        Scanner makePin = new Scanner(System.in);

        do {
            System.out.flush();
            System.out.println("Please enter a 6 digit pin: ");
            String newPin = makePin.nextLine();

           try {
               if (newPin.length() == 6) {
                   pin = Integer.parseInt(newPin);
                   createPassword();
                   break;
               }
           } catch (NumberFormatException e) {
               System.out.println("The pin can only be integers!");
           }
        } while (true);
        return;
    }

    public  void createPassword() {
        Scanner makePassword = new Scanner(System.in);

        do {
            System.out.flush();
            System.out.println("Please create a password: ");
            password = makePassword.nextLine();

            if (password.length() > 7) {
                break;
            }
            else {
                System.out.println("Password needs to be more than 7 Characters!");
                continue;
            }
        } while (true);
        return;
    }


}
