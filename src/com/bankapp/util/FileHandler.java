package com.bankapp.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String ACCOUNT_FILE = "accounts.txt";
    private static final String TRANSACTION_FILE = "transactions.txt";

    // save acc
    public void saveAccount(String data) {

        try (FileWriter writer = new FileWriter(ACCOUNT_FILE, true)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            System.out.println("Error saving account: " + e.getMessage());
        }
    }

    // load acc
    public List<String> loadAccounts() {

        List<String> accounts = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(ACCOUNT_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {
                accounts.add(line);
            }

        } catch (IOException e) {
            System.out.println("No previous accounts found.");
        }

        return accounts;
    }

    // save txn
    public void saveTransaction(String data) {

        try (FileWriter writer = new FileWriter(TRANSACTION_FILE, true)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    //  load txn
    public List<String> loadTransactions() {

        List<String> transactions = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(TRANSACTION_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {
                transactions.add(line);
            }

        } catch (IOException e) {
            System.out.println("No transaction history found.");
        }

        return transactions;
    }
}