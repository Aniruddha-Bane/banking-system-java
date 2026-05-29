package com.bankapp.service;

import com.bankapp.model.BankAccount;

public class BankService {

    // DEPOSIT

    public void deposit(BankAccount account,
                        double amount) {

        if (amount <= 0) {

            System.out.println(
                    "Deposit amount must be positive."
            );

            return;
        }

        double updatedBalance =
                account.getBalance() + amount;

        account.setBalance(updatedBalance);

        System.out.println("Deposit successful.");

        System.out.println(
                "Updated balance: "
                        + account.getBalance()
        );
    }

    // WITHDRAW

    public void withdraw(BankAccount account,
                         double amount) {

        if (amount <= 0) {

            System.out.println(
                    "Withdrawal amount must be positive."
            );

            return;
        }

        if (amount > account.getBalance()) {

            System.out.println(
                    "Insufficient balance."
            );

            return;
        }

        double updatedBalance =
                account.getBalance() - amount;

        account.setBalance(updatedBalance);

        System.out.println("Withdrawal successful.");

        System.out.println(
                "Remaining balance: "
                        + account.getBalance()
        );
    }

    // CHECK BALANCE

    public void checkBalance(BankAccount account) {

        System.out.println(
                "Current balance: "
                        + account.getBalance()
        );
    }
}