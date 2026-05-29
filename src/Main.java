import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount("Aniruddha",4503,50000);
        boolean running = true;
        while(running){
            showMenu();
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();

                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();

                    account.withdraw(withdrawalAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    showAccountDetails(account);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting system . . . ");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
    public static void showMenu()
    {
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
    public static void showAccountDetails(BankAccount account){
        System.out.println("\nAccount Holder: " + account.accountHolder );
        System.out.println("Account Number: " + account.accountNumber );
        System.out.println("Balance: " + account.balance);
    }
}
