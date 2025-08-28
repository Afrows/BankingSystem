import java.util.Scanner;

public class MainMenu extends Bank {
    Scanner options = new Scanner(System.in);
    AccountLogIn log = new AccountLogIn(this);
    AccountCreation create = new AccountCreation(this);
    Settings settings = new Settings(this);

    public MainMenu() {
    }

    public void options() {

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
                   case 3 -> settings.mainMenuSettings();
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