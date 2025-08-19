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
        StringBuilder border = new StringBuilder();
        border.append("*".repeat(64));
        Scanner options = new Scanner(System.in);
        AccountLogIn log = new AccountLogIn();
        AccountCreation create = new AccountCreation();

       do {
           System.out.println(border + "\n" + border +
                   """
                \n
                Welcome to Solace Banking. Please choose an option below.
                1. Log In
                2. Create an account
                3. Settings
                4. Exit\n
                """ + border + "\n" + border);
           String choice = options.nextLine();

           try {
               switch (Integer.parseInt(choice)) {
                   case 1 -> log.logIn();
                   case 2 -> create.accountType();
                   case 3 -> System.out.println("Under Maintenance");
                   case 4 -> exit();
               }
           } catch (NumberFormatException e) {
               System.out.println("Please enter a number between 1-4.");
           }
       } while (true);
    }

    public void exit() {
        System.out.println("Thank you for using our services, Goodbye.");
    }
}
