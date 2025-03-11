package bank;
import java.util.Scanner;

public class application {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);    
        BankAccount ChimtuBank = new BankAccount("sudhapusa", "547");
        ChimtuBank.showmenu();
        scanner.close();
    }
}

class BankAccount {
    int balance;
    int previoustranscations;
    String customername;
    String customerid;

    BankAccount(String cname, String cid) {
        customername = cname;
        customerid = cid;
    }

    void deposite(int amount) {
        if(amount != 0) {
            balance = balance + amount;
            previoustranscations = amount;
            System.out.println("Amount Deposited Successfully: " + amount);
        }
    }

    void withdraw(int amount) {
        if(amount != 0) {
            balance = balance - amount;
            previoustranscations = -amount;
            System.out.println("Amount Withdrawn Successfully: " + amount);
        }
    }

    void getprevioustranscations() {
        if(previoustranscations > 0) {
            System.out.println("Deposited: " + previoustranscations);
        } else if(previoustranscations < 0) {
            System.out.println("Withdrawn: " + Math.abs(previoustranscations));
        } else {
            System.out.println("No transactions found.");
        }
    }

    void showmenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome: " + customername);
        System.out.println("Your ID is: " + customerid);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("=================");
            System.out.println("Enter an option: ");
            System.out.println("=================");
            option = scanner.next().charAt(0);
            option = Character.toUpperCase(option);

            switch(option) {
                case 'A':
                    System.out.println("-------------->");
                    System.out.println("Balance: " + balance);
                    System.out.println("--------------->");
                    break;

                case 'B':
                    System.out.println("---------------->");
                    System.out.println("Enter the amount to deposit:");
                    System.out.println("----------------->");
                    int amount = scanner.nextInt();
                    deposite(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("---------------->");
                    System.out.println("Enter the amount to withdraw:");
                    System.out.println("----------------->");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("---------------->");
                    getprevioustranscations();
                    System.out.println("----------------->");
                    break;

                case 'E':
                    System.out.println("Thank you for using our bank. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while(option != 'E');

        scanner.close();
    }
}
