import java.util.Scanner;

public class AccountLogIn extends Account {

    private static int attempt;
    private static int pinAttempt;

    public AccountLogIn(String accountNumber, double accountBalance, String customerName, String emailAddress,
                        int phoneNumber, String dateOfBirth, String password, int pin, int attempt, boolean pinRestart) {
        super(accountNumber, accountBalance, customerName, emailAddress, phoneNumber, dateOfBirth, password, pin);
    }

    public AccountLogIn() {
        System.out.println(logIn());
    }

    public static boolean logIn() {
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
                    continue;
        } while (true);

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        do {
            System.out.println("Enter your password: ");
            String passwordCheck = pass.nextLine();
                if (passwordCheck.equals(password)) {
                    break;
                }
                else {
                    System.out.println("The password is incorrect");
                    attempt++;
                    continue;
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
                        if (resetPass.equals("1")) {
                            forgotPassword();
                            break;
                        }
                        else if (resetPass.equals("2")) {
                            logIn();
                            break;
                        }
                        else
                            continue;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter either 1 or 2.");
                    }
                } while (true);

        }
        return false;
    }

    public static void forgotPassword() {
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
                    System.out.println(resetPass.createPassword());
                    break;
                }
                else if (choice.equals("2")) {
                    MainMenu main = new MainMenu();
                    System.out.println(main);
                    break;
                }
                else
                    continue;
            } catch (NumberFormatException e) {
                System.out.println("Please enter either 1 or 2.");
            }
        } while (true);
    }

    public static void pinVerification() {
        Scanner pinEntry = new Scanner(System.in);

        if (verification) {
            do {
            System.out.println("Please enter your pin: ");
            String enteredPin = pinEntry.nextLine();
            try {
                if (enteredPin.equals(pin)) {
                    break;
                }
                else if (pinAttempt == 3) {
                    pinReset();
                    break;
                }
                else
                    pinAttempt++;
                continue;
            } catch (NumberFormatException e) {
                System.out.println("Please enter the digits for your pin.");
                }
            } while (true);
        }
    }

    public static void pinReset() {
        pinAttempt = 0;
        Scanner pinChoice = new Scanner(System.in);

        do {
            System.out.println("""
                    You have made 3 attempts so far, would you like to reset your pin?
                    1. Yes
                    2. No
                    """);
            String pinC = pinChoice.nextLine();
            if (pinC.equals("1") {
                AccountCreation newPin = new AccountCreation();
                pinRestart = true;
                System.out.println(newPin.createPin());

            }
        } while (true);
    }
}
