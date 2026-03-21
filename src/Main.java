package HW04;

class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(name + " deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Deposit failed for " + name + ": Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(name + " withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Withdrawal failed for " + name + ". Check amount or balance.");
        }
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}