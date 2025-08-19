import java.util.Scanner;

public class AccountLogIn extends Account {

    private static int attempt;
    private static int pinAttempt;

    public AccountLogIn(String accountNumber, double accountBalance, String customerName, String emailAddress,
                        int phoneNumber, String dateOfBirth, String password, int pin) {
        super(accountNumber, accountBalance, customerName, emailAddress, phoneNumber, dateOfBirth, password, pin);
    }

    public AccountLogIn() {

    }

    public void logIn() {
        Scanner user = new Scanner(System.in);
        Scanner pass = new Scanner(System.in);
        Scanner attemptTry = new Scanner(System.in);

        do {
            System.out.println("Enter your username or email: ");
            String userLog = user.nextLine();
                if (userLog.equalsIgnoreCase(emailAddress)) {
                    break;
                }
                else {
                    System.out.println("This email is not registered in our system.");
                }
        } while (true);

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        do {
            System.out.println("Enter your password: ");
            String passwordCheck = pass.nextLine();
                if (passwordCheck.equals(password)) {
                    pinVerification();
                    break;
                }
                else {
                    System.out.println("The password is incorrect");
                    attempt++;
                }
        } while (true);

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        if (attempt == 3) {
                do {
                    System.out.println("""
                        You have made three attempts, would you like to reset your password?
                        1. Yes, reset password.
                        2. No.""");
                    String resetPass = attemptTry.nextLine();

                    try {
                        switch (Integer.parseInt(resetPass)) {
                            case 1 -> forgotPassword();
                            case 2 -> logIn();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter either 1 or 2.");
                    }
                } while (true);
        }
    }

    public void forgotPassword() {
        Scanner forgotP = new Scanner(System.in);

        do {
            System.out.println("""
                    Would you like to reset your password?
                    1. Yes
                    2. No""");
            String choice = forgotP.nextLine();

            try {
                if (choice.equals("1")) {
                    AccountCreation resetPass = new AccountCreation();
                    resetPass.createPassword();
                    break;
                }
                else if (choice.equals("2")) {
                    MainMenu main = new MainMenu();
                    System.out.println(main);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter either 1 or 2.");
            }
        } while (true);
    }

    public void pinVerification() {
        Scanner pinEntry = new Scanner(System.in);

        if (verification) {
            do {
            System.out.println("Please enter your pin: ");
            String enteredPin = pinEntry.nextLine();
            try {
                if (Integer.parseInt(enteredPin) == pin) {
                    depositOrWithdraw();
                    break;
                }
                else if (!verification) {
                    depositOrWithdraw();
                    break;
                }
                else if (pinAttempt == 3) {
                    pinReset();
                    break;
                }
                else
                    pinAttempt++;
            } catch (NumberFormatException e) {
                System.out.println("Please enter the digits for your pin.");
                }
            } while (true);
        }
    }

    public void pinReset() {
        pinAttempt = 0;
        Scanner pinChoice = new Scanner(System.in);

        do {
            System.out.println("""
                    You have made 3 attempts so far, would you like to reset your pin?
                    1. Yes
                    2. No
                    """);
            String pinC = pinChoice.nextLine();
            if (pinC.equals("1")) {
                AccountCreation newPin = new AccountCreation();
                pinRestart = true;
                newPin.createPin();
            }
            else if (pinC.equals("2")){
                logIn();
            }
        } while (true);
    }

    public static void depositOrWithdraw() {
        Scanner dow = new Scanner(System.in);
        Money account = new Money();

        do {
            System.out.println("Welcome " + customerName + ", Which services would you like to use?\n " +
                    "1. Deposit\n 2. Withdraw\n 3. Check Balance\n 4. Settings\n 5. Log Out\n 6. Close App\n ");
            String service = dow.nextLine();
                switch (Integer.parseInt(service)) {
                    case 1 -> System.out.println(account.deposit());
                    case 2 -> System.out.println(account.withdraw());
                    case 3 -> System.out.println(account.showBalance());
                    default -> System.out.println("Please type a number for the service you want to use.");
                }
        } while (true);
    }
}
