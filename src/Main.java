
class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public static final double MIN_BALANCE = 50000.0;
    public static final double TRANSFER_FEE_RATE = 0.02;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        if (ownerName == null || ownerName.isEmpty()) {
            System.out.println("Error: Owner name must not be empty.");
        } else if (initialBalance < MIN_BALANCE) {
            System.out.println("Error: Initial balance for " + ownerName + " must be >= " + MIN_BALANCE);
        } else {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
            this.balance = initialBalance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(ownerName + " deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit failed for " + ownerName + ": Amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            System.out.println(ownerName + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Withdrawal failed for " + ownerName + ". Invalid amount or minimum balance constraint violated.");
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        double fee = amount * TRANSFER_FEE_RATE;
        double totalDeduction = amount + fee;
        if (amount > 0 && (balance - totalDeduction) >= MIN_BALANCE) {
            this.balance -= totalDeduction;
            recipient.balance += amount; 
            System.out.println(ownerName + " transferred " + amount + " to " + recipient.getOwnerName() + " (Fee: " + fee + ")");
        } else {
            System.out.println("Transfer failed. Insufficient funds to cover amount + fee, or minimum balance rule violated for " + ownerName);
        }
    }

    public void payBill(String billName, double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            System.out.println(ownerName + " paid bill '" + billName + "' for " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Bill payment '" + billName + "' failed for " + ownerName + ". Minimum balance rule violated.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("001", "Nguyen Phan Vi", 1000000.0);
        BankAccount acc2 = new BankAccount("002", "Nguyen Cong Tai", 500000.0);
        BankAccount acc3 = new BankAccount("003", "Tran Duc Thang", 10000.0); 

        System.out.println("\nInitial balances");
        System.out.println(acc1.getOwnerName() + ": " + acc1.getBalance());
        System.out.println(acc2.getOwnerName() + ": " + acc2.getBalance());
        System.out.println();

        System.out.println("Deposits");
        acc1.deposit(250000.0); 
        acc2.deposit(-50.0);  
        System.out.println();

        System.out.println("Withdrawals");
        acc2.withdraw(50000.0);
        acc1.withdraw(5000000.0); 
        System.out.println();

        System.out.println("Transfers");
        acc1.transfer(acc2, 300000.0); 
        acc2.transfer(acc1, 800000.0); 
        System.out.println();

        System.out.println("PayBills");
        acc1.payBill("Electricity", 45000.0); 
        acc2.payBill("Internet", 999000.0); 
        System.out.println();

        System.out.println("--- Final balances ---");
        System.out.println(acc1.getOwnerName() + ": " + acc1.getBalance());
        System.out.println(acc2.getOwnerName() + ": " + acc2.getBalance());
    }
}