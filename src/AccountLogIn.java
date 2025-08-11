import java.util.Scanner;

public class AccountLogIn extends Account {

    private int attempt;

    public AccountLogIn(String accountNumber, double accountBalance, String customerName, String emailAddress, int phoneNumber, String dateOfBirth, String password, int pin, int attempt) {
        super(accountNumber, accountBalance, customerName, emailAddress, phoneNumber, dateOfBirth, password, pin);
        this.attempt = attempt;
    }

    public AccountLogIn() {
        System.out.println(logIn());
    }

    public boolean logIn() {
        Scanner user = new Scanner(System.in);
        Scanner pass = new Scanner(System.in);
        Scanner attemptTry = new Scanner(System.in);

        do {
            System.out.println("Enter your username or email: ");
            String userLog = user.nextLine();

                if (userLog.equals(emailAddress)) {
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

    public void forgotPassword () {

    }
}
