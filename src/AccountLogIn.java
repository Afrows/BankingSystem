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
            textBorder();
            System.out.println("Enter your username or email: ");
            String userLog = user.nextLine();
                if (userLog.equalsIgnoreCase(emailAddress)) {
                    break;
                }
                else {
                    textBorder();
                    System.out.println("This email is not registered in our system.");
                    textBorder();
                    delay();
                }
        } while (true);

        spacing();

        do {
            textBorder();
            System.out.println("Enter your password: ");
            String passwordCheck = pass.nextLine();
                if (passwordCheck.equals(password)) {
                    pinVerification();
                    break;
                }
                else {
                    textBorder();
                    System.out.println("The password is incorrect");
                    attempt++;
                    textBorder();
                    delay();
                }
        } while (true);

        spacing();

        if (attempt == 3) {
                do {
                    textBorder();
                    System.out.println("""
                        You have made three attempts, would you like to reset your password?
                        1. Yes, reset password.
                        2. No.""");
                    String resetPass = attemptTry.nextLine();

                        switch (Integer.parseInt(resetPass)) {
                            case 1 -> forgotPassword();
                            case 2 -> logIn();
                            default -> {
                                textBorder();
                                System.out.println("Please enter either 1 or 2.");
                                textBorder();
                                delay();
                            }
                        }
                } while (true);
            }
    }

    public void forgotPassword() {
        Scanner forgotP = new Scanner(System.in);

        do {
            textBorder();
            System.out.println("""
                    Would you like to reset your password?
                    1. Yes
                    2. No""");
            String choice = forgotP.nextLine();
            switch (Integer.parseInt(choice)) {
                case 1 -> {
                    AccountCreation resetPass = new AccountCreation();
                    resetPass.createPassword();
                }
                case 2 -> {
                    MainMenu main = new MainMenu();
                    System.out.println(main);
                }
                default -> {
                    textBorder();
                    System.out.println("Please enter either 1 or 2.");
                    textBorder();
                    delay();
                }
            }
        } while (true);
    }

    public void pinVerification() {
        Scanner pinEntry = new Scanner(System.in);

        if (verification) {
            do {
                textBorder();
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
                textBorder();
                System.out.println("Please enter the digits for your pin.");
                textBorder();
                delay();
                }
            } while (true);
        }
    }

    public void pinReset() {
        pinAttempt = 0;
        Scanner pinChoice = new Scanner(System.in);

        do {
            textBorder();
            System.out.println("""
                    You have made 3 attempts so far, would you like to reset your pin?
                    1. Yes
                    2. No
                    """);
            String pinC = pinChoice.nextLine();
            switch (Integer.parseInt(pinC)) {
                case 1 -> {
                    AccountCreation newPin = new AccountCreation();
                    pinRestart = true;
                    newPin.createPin();
                }
                case 2 -> logIn();
            }
        } while (true);
    }

    public void depositOrWithdraw() {
        Scanner dow = new Scanner(System.in);
        Money account = new Money();
        MainMenu exit = new MainMenu();

        do {
            textBorder();
            System.out.println("Welcome " + customerName + ", Which services would you like to use?\n " +
                    "1. Deposit\n 2. Withdraw\n 3. Check Balance\n 4. Settings\n 5. Log Out\n 6. Close App\n ");
            textBorder();
            String service = dow.nextLine();
                switch (Integer.parseInt(service)) {
                    case 1 -> account.deposit();
                    case 2 -> account.withdraw();
                    case 3 -> account.showBalance();
                    case 6 -> exit.exit();
                    default -> System.out.println("Please type a number for the service you want to use.");
                }
        } while (true);
    }
}