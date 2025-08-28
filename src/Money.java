import java.util.Scanner;

public class Money extends Bank {

    private AccountLogIn redo;
    public Money(AccountLogIn redo) {
        this.redo = redo;
    }

    private double value;
    private boolean sufficientFunds;
    protected boolean overdraft;
    protected double overdraftLimit;

    public Money(double accountBalance, double value, boolean sufficientFunds, boolean overdraft, double overdraftLimit) {
        super(accountBalance);
        this.value = value;
        this.sufficientFunds = sufficientFunds;
        this.overdraft = overdraft;
        this.overdraftLimit = overdraftLimit;
    }

    public Money() {

    }

    public void hasSufficientFunds() {
        if (accountBalance - value < 0) {
            sufficientFunds = !(accountBalance - value < 0);
        }
    }

    public void hasOverdraft() {
        if (overdraft) {
            overdraftLimit = -800;
            sufficientFunds = !(accountBalance - value < overdraftLimit);
        }
    }

    public void deposit() {
        Scanner depositQ = new Scanner(System.in);
        Scanner depositM = new Scanner(System.in);
         do {
             spacing();
             textBorder();
             System.out.println("""
                     Would you like to deposit?
                     1. Yes
                     2. No\n""");
             String depositA = depositQ.nextLine();
             try {
             if (Integer.parseInt(depositA) == 1) {
                 System.out.println("How much would like to deposit?");
                 value = depositM.nextDouble();
                 if (value > 0) {
                     this.accountBalance = value;
                     loading();
                     System.out.println("You have successfully deposited £" + value + ". Your current balance now is £" + accountBalance);
                     delay();
                 }
                 else {
                     System.out.println("You can't deposit with a number below 0");
                     continue;
                 }

                 value = 0;
                 break;
             } else if (depositA.equals("2")) {
                 redo.depositOrWithdraw();
             }
             } catch (NumberFormatException e) {
                 System.out.println("Please enter either 1 or 2");
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         } while (true);
    }

    public void withdraw() {
        Scanner withdrawQ = new Scanner(System.in);
        Scanner withdrawM = new Scanner(System.in);
        hasOverdraft();
        hasSufficientFunds();
        do {
            spacing();
            textBorder();
            System.out.println("""
                    Would you like to withdraw?
                    1. Yes
                    2. No""");
            String withdrawA = withdrawQ.nextLine();
            try {
                if (Integer.parseInt(withdrawA) == 1 && Integer.parseInt(withdrawA) < 0) {
                    System.out.println("How much would you like to withdraw?");
                    value = withdrawM.nextDouble();
                    if (sufficientFunds || overdraft) {
                        accountBalance = accountBalance - value;
                    }
                    else {
                        System.out.println("You don't have enough money to withdraw that amount.");
                        continue;
                    }
                    loading();
                    System.out.println("You have successfully withdrew £" + value + ". Your current balance now is £" + accountBalance);
                    delay();
                    value = 0;
                    break;
                    }
                } catch (NumberFormatException e) {
                System.out.println("Please press either 1 or 2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (true);

    }

    public void showBalance() {
        System.out.println("You have £" + this.accountBalance + " in your account.");
        delay();
        redo.depositOrWithdraw();
    }
}