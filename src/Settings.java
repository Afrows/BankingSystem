import java.util.Scanner;

public class Settings extends Bank {
    Account account = new Account();
    AccountCreation create = new AccountCreation();

    private String softwareVersion;

    public Settings(double accountBalance, Account account, AccountCreation create, String softwareVersion) {
        super(accountBalance);
        this.account = account;
        this.create = create;
        this.softwareVersion = softwareVersion;
    }

    private MainMenu menu;
    public Settings(MainMenu menu) {
        this.menu = menu;
    }

    public void mainMenuSettings() {
        Scanner options = new Scanner(System.in);
        do {
            textBorder();
            System.out.println("""
                    1. Forgot Password?
                    2. Software Version
                    3. Log out
                    4. Exit""");
            String settingsChoice = options.nextLine();
            switch (Integer.parseInt(settingsChoice)) {
                case 1 -> passwordChange();
                case 2 -> System.out.println(softwareVersion);
                case 3 -> menu.options();
                case 4 -> menu.exit();
                default -> {
                    System.out.println("Please enter a number between 1-4.");
                    delay();
                }
            }
        } while (true) ;
    }

    public void settings() {
        Scanner options = new Scanner(System.in);
        do {
            textBorder();
            System.out.println("""
                    1. Change password.
                    2. Account Details.
                    3. Update Details.
                    4. Software version
                    5. Log out
                    6. Exit""");
            String settingsChoice = options.nextLine();
            switch (Integer.parseInt(settingsChoice)) {
                case 1 -> create.createPassword();
                case 2 -> personalDetails();
                case 3 -> updateDetails();
                case 4 -> {
                    System.out.println(softwareVersion);
                    delay();
                }
                case 5 -> menu.options();
                case 6 -> menu.exit();
                default -> {
                    System.out.println("Please select a number between 1-6.");
                    delay();
                }
            }
        } while (true);
    }

    private void personalDetails() {
        Account account = new Account();
        textBorder();
        System.out.println("Full Name: " + customerName +
                "\nDate of birth: " + account.dateOfBirth +
                "\nEmail: " + emailAddress);
        textBorder();
        delay();
        delay();
        settings();
    }

    public void passwordChange() {
        Scanner emailAuthentication = new Scanner (System.in);
        Scanner dobVerification = new Scanner (System.in);
        do {
            textBorder();
            System.out.println("Please enter the email for the password you have forgotten: ");
            String emailVerify = emailAuthentication.nextLine();
            if (emailVerify.equals(emailAddress)) {
                textBorder();
                System.out.println("Please enter the date of birth for the account (DD/MM/YYYY Format): ");
                String dobVerify = dobVerification.nextLine();
                if (dobVerify.equals(account.dateOfBirth)) {
                    create.createPassword();
                }
                else {
                    System.out.println("The date of birth doesn't match with out records.");
                    delay();
                    passwordChange();
                }
            }
            else {
                System.out.println("This email is not recognised.");
                delay();
                passwordChange();
            }
        } while (true);
    }

    public void updateDetails() {
        Scanner changeDetails = new Scanner(System.in);
        do {
            System.out.println("""
                    Which details would you like to change?
                    1. Change Email
                    2. Change Password
                    3. Change Date of birth
                    4. Change pin""");
            String option = changeDetails.nextLine();
            switch (Integer.parseInt(option)) {
                case 1 -> changeEmail();
                case 2 -> create.createPassword();
                case 3 -> changeDOB();
                case 4 -> {
                    Account.pinRestart = true;
                    create.createPin();
                }
            }
        } while (true);
    }

    public void changeEmail() {
        do {
            System.out.println("Please enter your current email: ");
            Scanner currentEmail = new Scanner(System.in);
            Scanner newEmail = new Scanner(System.in);
            String currentE = currentEmail.nextLine();
            if (currentE.equalsIgnoreCase(emailAddress)) {
                System.out.println("Enter your new email: ");
                String newE = newEmail.nextLine();
                if (newE.contains("@gmail") || newE.contains("@hotmail")
                        || newE.contains("@outlook") || newE.contains("@Yahoo")) {
                    emailAddress = newE;
                    break;
                } else {
                    textBorder();
                    System.out.println("Emails we support are: Gmail, Hotmail, Yahoo & Outlook");
                    textBorder();
                    delay();
                    changeEmail();
                }
            }
            else {
                System.out.println("The email you provided doesn't match to the one on our system. Please Try Again");
                delay();
                changeEmail();
            }
        } while (true);
    }

    public void changeDOB() {
        Scanner currentDOB = new Scanner(System.in);
        Scanner newDOB = new Scanner(System.in);
        do {
            int changeLimit = 0;
            int changesLeft = 2;
            System.out.println("Please enter your current date of birth (DD/MM/YYYY Format): ");
            String currentD = currentDOB.nextLine();
            if (currentD.equalsIgnoreCase(account.dateOfBirth)) {
                System.out.println("""
                        Enter your new date of birth.
                        Please note that you have a limit on how many times you can change your date of birth.
                        Number of changes left:""" + changesLeft);
                String newD = newDOB.nextLine();
                if ((newD.contains("/") && newD.length() == 10 && Integer.parseInt(newD.substring(6)) > 1909 &&
                        Integer.parseInt(newD.substring(6)) < 2025-17)) {
                    int age = (2025 - Integer.parseInt(newD.substring(6)));
                    System.out.println("Great, you are " + age + " years old.");
                    changeLimit++;
                    changesLeft--;
                    settings();
                    delay();
                }
                else {
                    System.out.println("Please enter your date of birth in the DD/MM/YYYY Format");
                    changeDOB();
                }
            }
            else {
                System.out.println("The date of birth does not match with the one we have in our records.");
                changeDOB();
            }
        } while (true);

    }
}
