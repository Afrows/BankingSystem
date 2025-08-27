import java.util.Scanner;

public class MainMenu extends Bank {

    public MainMenu(String accountNumber, double accountBalance, String customerName,
                    String emailAddress, int phoneNumber) {
        super(accountNumber, accountBalance, customerName, emailAddress, phoneNumber);

    }

    public MainMenu() {
        options();
    }

    public void options() {
        Scanner options = new Scanner(System.in);
        AccountLogIn log = new AccountLogIn();
        AccountCreation create = new AccountCreation();
        Settings setting = new Settings();

       do {
           textBorder();
           System.out.println("""
                Welcome to Solace Banking. Please choose an option below.
                1. Log In
                2. Create an account
                3. Settings
                4. Exit
                """);
           textBorder();
           String choice = options.nextLine();
               switch (Integer.parseInt(choice)) {
                   case 1 -> log.logIn();
                   case 2 -> create.accountType();
                   case 3 -> setting.mainMenuSettings();
                   case 4 -> exit();
                   default -> {
               textBorder();
               System.out.println("Please enter a number between 1-4.");
               textBorder();
               delay();
               }
           }
       } while (true);
    }

    public void exit() {
        textBorder();
        System.out.println("Thank you for using our services, Goodbye.");
        textBorder();
        delay();
        System.exit(0);
    }
}