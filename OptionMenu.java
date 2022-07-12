
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$' 0.00");

   static HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() throws IOException {
        int x = 1;
        do{
            try {
                data.put(12345, 1234);
                data.put(54321, 1122);

                System.out.println("Welcome to the ATM Project!");

                System.out.println("Enter your Customer Number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter you Pin Number");
                setPinNumber(menuInput.nextInt());
            }catch (Exception e) {
                System.out.println(" Invalid Characters. Only Numbers." + "\n" );
                x = 2;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            }else {
                System.out.println("Wrong Customer Number or Pin Number.");
                x = 2;
            }
        }while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");

        int selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You for using the ATM. Visit again.");
                break;
            default:
                System.out.println("\nInvalid Choice");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("type 2 - Withdraw Balance");
        System.out.println("type 3 - Deposit Funds");
        System.out.println("type 4 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: "+ moneyFormat.format(getCheckingBalance()));
                break;
            case 2:
                getCheckingWithdrawnInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using the ATM. Visit again.");
                break;
            default:
                System.out.println("\nInvalid Choice");
        }
    }

    public void getSaving() {
        System.out.println("Saving Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("type 2 - Withdraw Balance");
        System.out.println("type 3 - Deposit Funds");
        System.out.println("type 4 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: "+ moneyFormat.format(getSavingBalance()));
                break;
            case 2:
                getSavingWithdrawnInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using the ATM. Visit again.");
                break;
            default:
                System.out.println("\nInvalid Choice");
        }

    }

}
