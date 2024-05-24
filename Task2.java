package codealpha;

import java.util.Scanner;

public class Task2 {
    private static double balance = 0;
    private static Scanner scanner = new Scanner(System.in);

		    public static void main(String[] args) {
		        boolean exit = false;
		        int option;
		        System.out.println("Have a nice day ..............Welcome to  Banking Application!");

		        while (!exit) {
		            System.out.println("1. Deposit");
		            System.out.println("2. Withdraw");
		            System.out.println("3. Check Balance");
		            System.out.println("4. Exit");
		            System.out.print("select an option: ");
		            option = scanner.nextInt();

		            switch (option) {
		                case 1:
		                    deposit();
		                    break;
		                case 2:
		                    withdraw();
		                    break;
		                case 3:
		                    checkBalance();
		                    break;
		                case 4:
		                    exit = true;
		                    System.out.println("Thank you for using  Banking Application!");
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
		            }
		        }
		    }

		    private static void deposit() {
		        System.out.print("Enter amount to deposit: ");
		        double amount = scanner.nextDouble();
		        if (amount > 0) {
		            balance += amount;
		            System.out.println("Deposit successful. Current balance: " + balance);
		        } else {
		            System.out.println("Invalid amount. Please enter a positive number.");
		        }
		    }

		    private static void withdraw() {
		        System.out.print("Enter amount to withdraw: ");
		        double amount = scanner.nextDouble();
		        if (amount > 0 && amount <= balance) {
		            balance -= amount;
		            System.out.println("Withdrawal successful. Current balance: " + balance);
		        } else {
		            System.out.println("Invalid amount or insufficient balance.");
		        }
		    }

		    private static void checkBalance() {
		        System.out.println("Current balance: " + balance);

	}

}
