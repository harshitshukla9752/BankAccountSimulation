import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private static int accCounter = 100000; // starting account number
    protected final String accountNumber;
    protected final String ownerUserId;
    protected double balance;
    protected final List<Transaction> transactions;

    public Account(String ownerUserId, double initialBalance) {
        this.accountNumber = "AC" + (++accCounter);
        this.ownerUserId = ownerUserId;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        // initial transaction (account creation)
        transactions.add(new Transaction("ACCOUNT_OPEN", initialBalance, initialBalance));
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public double getBalance() {
        return balance;
    }

    // deposit common behavior
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        Transaction txn = new Transaction("DEPOSIT", amount, balance);
        transactions.add(txn);
        System.out.println("Deposit successful. " + txn);
    }

    // withdraw - subclasses may override for special rules (e.g., overdraft or interest)
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }
        balance -= amount;
        Transaction txn = new Transaction("WITHDRAW", amount, balance);
        transactions.add(txn);
        System.out.println("Withdrawal successful. " + txn);
        return true;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void printSummary() {
        System.out.println(this.getClass().getSimpleName() + " " + accountNumber + " | Owner: " + ownerUserId + " | Balance: " + String.format("%.2f", balance));
    }

    public void printTransactionHistory() {
        System.out.println("Transaction history for account " + accountNumber + ":");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
