package com.bankapp.main;

import java.util.Scanner;

import com.bankapp.model.BankAccount;
import com.bankapp.service.BankService;
import com.bankapp.util.InputHandler;
import com.bankapp.util.FileHandler;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InputHandler input = new InputHandler(scanner);

        BankService service = new BankService();

        FileHandler fileHandler = new FileHandler();

        // LOAD OLD DATA (optional display)
        System.out.println("\n===== Previous Accounts =====");
        for (String acc : fileHandler.loadAccounts()) {
            System.out.println(acc);
        }

        System.out.println("\n===== Previous Transactions =====");
        for (String t : fileHandler.loadTransactions()) {
            System.out.println(t);
        }

        // CURRENT ACCOUNT (demo single user)
        BankAccount account = new BankAccount(
                "Aniruddha",
                4503,
                50000,
                "Savings"
        );

        boolean running = true;

        while (running) {

            showMenu();

            int choice = input.getMenuChoice();

            switch (choice) {

                case 1: // DEPOSIT
                    double depositAmount =
                            input.getAmount("Enter deposit amount: ");

                    service.deposit(account, depositAmount);

                    fileHandler.saveTransaction(
                            "Deposited: " + depositAmount +
                                    " | Balance: " + account.getBalance()
                    );

                    break;

                case 2: // WITHDRAW
                    double withdrawAmount =
                            input.getAmount("Enter withdrawal amount: ");

                    service.withdraw(account, withdrawAmount);

                    fileHandler.saveTransaction(
                            "Withdrawn: " + withdrawAmount +
                                    " | Balance: " + account.getBalance()
                    );

                    break;

                case 3: // BALANCE
                    service.checkBalance(account);
                    break;

                case 4: // ACCOUNT DETAILS
                    showAccountDetails(account);

                    fileHandler.saveAccount(
                            "Account viewed: " +
                                    account.getAccountHolder() +
                                    " | " + account.getAccountNumber()
                    );

                    break;

                case 5: // EXIT
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    // MENU
    public static void showMenu() {

        System.out.println("\n========================");
        System.out.println(" BANK ACCOUNT SYSTEM ");
        System.out.println("========================");

        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Account Details");
        System.out.println("5. Exit");

        System.out.print("Choose option: ");
    }

    // ACCOUNT DETAILS
    public static void showAccountDetails(BankAccount account) {

        System.out.println("\nAccount Holder: " + account.getAccountHolder());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Balance: " + account.getBalance());
    }
}