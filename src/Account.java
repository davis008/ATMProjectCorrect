import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    // Create a DecimalFormat object for formatting output.
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    /* Set the customer number */

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    /* Get the customer number */

    public int getCustomerNumber() {
        return customerNumber;
    }

    /* Set the pin number */

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    /* Get the pin number */

    public int getPinNumber() {
        return pinNumber;
    }

    /* Get Saving Account Balance */

    public double getSavingBalance() {
        return Balance;
    }



    /* Calculate Saving Account withdrawal */

    public double calcSavingWithdraw(double amount) {
        Balance = (Balance - amount);
        return Balance;
    }


    /* Calculate Saving Account deposit */

    public double calcSavingDeposit(double amount) {
        Balance = (Balance + amount);
        return Balance;
    }


    /* Customer Saving Account Withdraw input */

    public void getSavingWithdrawInput() {
        //for(count=0;count<4;count++) {
            System.out.println("Saving Account Balance: " + moneyFormat.format(Balance));
            System.out.print("Amount you want to withdraw from Saving Account: ");
            double amount = input.nextDouble();
            if ((amount < TRANSACTION_WITHDRAWAL_LIMIT && (amount < DAILY_WITHDRAWAL_LIMIT)) && ((Balance - amount) >= 0)) {
                calcSavingWithdraw(amount);
                System.out.println("New  Account balance: " + Balance + "\n");
            } else {
                System.out.println("Balance cannot be Negative");
            }
        //}
        }

    /* Customer Saving Account Deposit input */
    public void getSavingDepositInput() {
        for(count=0;count<4;count++) {

            if (Balance > 0) {
                System.out.println("Saving Account Balance: " + moneyFormat.format(Balance));
            }

            System.out.print("Enter Amount you want to deposit from Saving Account: ");
            double amount = input.nextDouble();
            if (((amount < TRANSACTION_DEPOSIT_LIMIT && (amount < DAILY_DEPOSIT_LIMIT)) && ((Balance + amount) >= 0))) {
                calcSavingDeposit(amount);
                System.out.println("New  Account balance: " + Balance + "\n");
            } else {
                System.out.println("Balance cannot be Negative");
            }
        }
        }
    private int customerNumber;
    private int count;
    private int pinNumber;
    private double Balance = 0;

    private final int DAILY_DEPOSIT_LIMIT = 150000;
    private final int TRANSACTION_DEPOSIT_LIMIT = 40000;

    private final int DAILY_WITHDRAWAL_LIMIT = 50000;
    private final int TRANSACTION_WITHDRAWAL_LIMIT = 20000;

}