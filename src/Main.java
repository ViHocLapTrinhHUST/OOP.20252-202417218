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

    public void transfer(BankAccount target, double amount) {
        double fee = amount * 0.02; 
        double total = amount + fee;

        if (amount > 0 && balance >= total) {
            this.balance -= total;
            target.balance += amount; 
            System.out.println(name + " transferred $" + amount + " to " + target.getName() + " (Fee: $" + fee + ")");
        } else {
            System.out.println("Transfer failed. Not enough money for " + name);
        }
    }

    public void payBill(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(name + " paid a bill of $" + amount);
        } else {
            System.out.println("Bill payment failed for " + name);
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
        BankAccount acc1 = new BankAccount("Nguyen Phan Vi", 1000.0);
        BankAccount acc2 = new BankAccount("Nguyen Cong Tai", 500.0);
        BankAccount acc3 = new BankAccount("Tran Duc Thang", 1500.0);

        System.out.println("--- Initial balances ---");
        System.out.println(acc1.getName() + ": $" + acc1.getBalance());
        System.out.println(acc2.getName() + ": $" + acc2.getBalance());
        System.out.println(acc3.getName() + ": $" + acc3.getBalance());
        System.out.println();

        System.out.println("--- 4 Deposits ---");
        acc1.deposit(250.0); 
        acc2.deposit(100.0);
        acc3.deposit(-50.0);  
        acc1.deposit(1000.0); 
        System.out.println();

        System.out.println("--- 4 Withdrawals ---");
        acc2.withdraw(50.0);
        acc3.withdraw(200.0); 
        acc1.withdraw(5000.0); 
        acc3.withdraw(150.0);
        System.out.println();

        System.out.println("--- 4 Transfers ---");
        acc1.transfer(acc2, 300.0); 
        acc2.transfer(acc3, 100.0); 
        acc3.transfer(acc1, 2000.0); 
        acc3.transfer(acc1, 150.0);
        System.out.println();

        System.out.println("--- 4 PayBills ---");
        acc1.payBill(45.5); 
        acc2.payBill(12.0); 
        acc3.payBill(300.0);
        acc2.payBill(999.0); 
        System.out.println();

        System.out.println("--- Final balances ---");
        System.out.println(acc1.getName() + ": $" + acc1.getBalance());
        System.out.println(acc2.getName() + ": $" + acc2.getBalance());
        System.out.println(acc3.getName() + ": $" + acc3.getBalance());
    }
}