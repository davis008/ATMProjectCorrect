import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    /* Validate Login information customer number and pin number */

    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {
                /*
                 * Accounts in a HashMap, key = customer number, value = pin
                 * number
                 */
                data.put(1234, 1234);
                data.put(6780, 1230);


                System.out.print("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
                x = 2;
            }
            for (Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getSaving();
                }
            }
            System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n");
        } while (x == 1);
    }


        /* Display Saving Account Menu with selections */

        public void getSaving() {
            System.out.println("Account: ");
            System.out.println("Type 1 - Balance");
            System.out.println("Type 2 - Withdrawal");
            System.out.println("Type 3 - Deposit");
            System.out.println("Type 4 - Quit");
            System.out.print("Menu: ");

            selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()) + "\n");
                    break;

                case 2:
                    getSavingWithdrawInput();
                    break;

                case 3:
                    getSavingDepositInput();
                    break;

                case 4:
                    System.out.println("Do you want to quit?");
                    Scanner scan = new Scanner(System.in);
                    choice = scan.nextLine();
                    System.exit(0);
                    break;

                default:
                    System.out.println("\n" + "Invalid choice." + "\n");
                    getSaving();
            }
        }

        int selection;
        String choice = "y";
    }