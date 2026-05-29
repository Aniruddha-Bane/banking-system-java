package com.bankapp.service;

import com.bankapp.model.BankAccount;
import com.bankapp.util.FileHandler;

public class BankService {

    private FileHandler fileHandler = new FileHandler();

    public void deposit(BankAccount account, double amount) {

        if (amount <= 0) {
            System.out.println("Deposit must be positive.");
            return;
        }

        account.setBalance(account.getBalance() + amount);

        fileHandler.saveTransaction(
                "DEPOSIT: " + amount +
                        " | Balance: " + account.getBalance()
        );

        System.out.println("Deposit successful.");
    }

    public void withdraw(BankAccount account, double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance.");
            return;
        }

        account.setBalance(account.getBalance() - amount);

        fileHandler.saveTransaction(
                "WITHDRAW: " + amount +
                        " | Balance: " + account.getBalance()
        );

        System.out.println("Withdrawal successful.");
    }

    public void checkBalance(BankAccount account) {
        System.out.println("Balance: " + account.getBalance());
    }
}