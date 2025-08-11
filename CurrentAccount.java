public class CurrentAccount extends Account {
    private final double overdraftLimit; // allowed negative balance up to this absolute value

    public CurrentAccount(String ownerUserId, double initialBalance, double overdraftLimit) {
        super(ownerUserId, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
        // allow withdraw up to balance + overdraftLimit
        if (amount > (balance + overdraftLimit)) {
            System.out.println("Amount exceeds overdraft limit. Withdrawal denied.");
            return false;
        }
        balance -= amount;
        Transaction txn = new Transaction("WITHDRAW", amount, balance);
        transactions.add(txn);
        System.out.println("Withdrawal successful (overdraft allowed if needed). " + txn);
        return true;
    }

    @Override
    public void printSummary() {
        System.out.println("CurrentAccount " + accountNumber + " | Owner: " + ownerUserId + " | Balance: " + String.format("%.2f", balance) + " | OverdraftLimit: " + overdraftLimit);
    }
}
