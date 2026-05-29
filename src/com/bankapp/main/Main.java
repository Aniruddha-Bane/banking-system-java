package com.bankapp.main;

import java.util.Scanner;

import com.bankapp.model.BankAccount;
import com.bankapp.service.BankService;
import com.bankapp.util.InputHandler;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InputHandler input =
                new InputHandler(scanner);

        BankService service =
                new BankService();

        BankAccount account =
                new BankAccount(
                        "Aniruddha",
                        4503,
                        50000,
                        "Savings"
                );

        boolean running = true;

        while (running) {

            showMenu();

            int choice =
                    input.getMenuChoice();

            switch (choice) {

                case 1:

                    double depositAmount =
                            input.getAmount(
                                    "Enter deposit amount: "
                            );

                    service.deposit(
                            account,
                            depositAmount
                    );

                    break;

                case 2:

                    double withdrawAmount =
                            input.getAmount(
                                    "Enter withdrawal amount: "
                            );

                    service.withdraw(
                            account,
                            withdrawAmount
                    );

                    break;

                case 3:

                    service.checkBalance(account);

                    break;

                case 4:

                    showAccountDetails(account);

                    break;

                case 5:

                    running = false;

                    System.out.println(
                            "Exiting system..."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }

        scanner.close();
    }

    // MENU

    public static void showMenu() {

        System.out.println(
                "\n========================"
        );

        System.out.println(
                " BANK ACCOUNT SYSTEM "
        );

        System.out.println(
                "========================"
        );

        System.out.println("1. Deposit");

        System.out.println("2. Withdraw");

        System.out.println("3. Check Balance");

        System.out.println("4. Account Details");

        System.out.println("5. Exit");

        System.out.print("Choose option: ");
    }

    // ACCOUNT DETAILS

    public static void showAccountDetails(
            BankAccount account
    ) {

        System.out.println(
                "\nAccount Holder: "
                        + account.getAccountHolder()
        );

        System.out.println(
                "Account Number: "
                        + account.getAccountNumber()
        );

        System.out.println(
                "Account Type: "
                        + account.getAccountType()
        );

        System.out.println(
                "Balance: "
                        + account.getBalance()
        );
    }
}