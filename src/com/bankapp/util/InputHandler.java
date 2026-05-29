package com.bankapp.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    private Scanner scanner;

    public InputHandler(Scanner scanner) {

        this.scanner = scanner;
    }

    // MENU CHOICE INPUT

    public int getMenuChoice() {

        while (true) {

            try {

                return scanner.nextInt();

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input! Enter numbers only."
                );

                scanner.nextLine();
            }
        }
    }

    // AMOUNT INPUT

    public double getAmount(String message) {

        while (true) {

            try {

                System.out.print(message);

                return scanner.nextDouble();

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid amount! Enter valid number."
                );

                scanner.nextLine();
            }
        }
    }
}