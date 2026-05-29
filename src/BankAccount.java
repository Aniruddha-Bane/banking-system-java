public class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    public BankAccount(String accountHolder,int accountNumber,double balance)
    {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // deposit
    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("Deposit amount must be positive.");
            return;

        }
        balance += amount;

        System.out.println("Deposit successful.");
        System.out.println("Updated balance: " + balance);

    }
    //withdraw
    public void withdraw(double amount){

        if (amount <= 0){
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > balance){
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawal successful.");
        System.out.println("Remaining balance: " + balance);
    }

    //getters
    public String getAccountHolder(){
        return accountHolder;

    }
    public int getAccountNumber(){
        return accountNumber;

    }
    public double getBalance(){
        return balance;

    }
}