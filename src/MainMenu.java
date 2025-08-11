import java.util.Scanner;

public class MainMenu extends Bank {


    public MainMenu(String accountNumber, double accountBalance, String customerName,
                    String emailAddress, int phoneNumber) {
        super(accountNumber, accountBalance, customerName, emailAddress, phoneNumber);

    }

    public MainMenu() {
        System.out.println(options());
    }

    public boolean options() {
        StringBuilder border = new StringBuilder();
        border.append("*".repeat(64));
        Scanner options = new Scanner(System.in);

       do {
           System.out.println(border + "\n" + border +
                   "\n\n" + """
                Welcome to Solace Banking. Please choose an option below.
                1. Log In
                2. Create an account
                3. Settings
                4. Exit\n
                """ + border + "\n" + border);
           String choice = options.nextLine();

           try {
               if (choice.equals("1")) {
                   AccountLogIn log = new AccountLogIn();
                   break;
               }
               else if (choice.equals("2")) {
                   AccountCreation create = new AccountCreation();
                   System.out.println(create);
                   break;
               }
               else if (choice.equals("3")) {
                   System.out.println("Under Maintenance");
               }
               else if (choice.equals("4")) {
                   System.out.println(exit());
                   break;
               }
               else
                   continue;
           } catch (NumberFormatException e) {
               System.out.println("Please enter a number between 1-4.");
           }


       } while (true);

        return false;
    }

    public boolean exit() {

        System.out.println("Thank you for using our services, Goodbye.");
        return true;
    }
}
