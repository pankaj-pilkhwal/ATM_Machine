import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int customerNumber;
    private int pinNumber;
    public double checkingBalance = 0;
    public double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }
    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }
    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }
    public double getSavingBalance() {
        return savingBalance;
    }

    public double calcCheckingWithdrawn(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }
    public double calcSavingWithdrawn(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }
    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public void getCheckingWithdrawnInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Enter the Amount you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdrawn(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        }else {
            System.out.println("Balance cannot be Negative." + "\n");
        }
    }
    public void getSavingWithdrawnInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from Saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdrawn(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        }else {
            System.out.println("Balance cannot be Negative." + "\n");
        }
    }

    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to deposit to your Checking Account: ");
        double amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount cannot be Negative.");
            return;
        }
        calcCheckingDeposit(amount);
        System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
    }
    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to deposit to your Saving Account: ");
        double amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount cannot be Negative.");
            return;
        }
        calcSavingDeposit(amount);
        System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
    }

}
