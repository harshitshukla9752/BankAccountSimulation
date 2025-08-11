public class SavingsAccount extends Account {
    private final double interestRate; // percent, e.g., 4.5

    public SavingsAccount(String ownerUserId, double initialBalance, double interestRate) {
        super(ownerUserId, initialBalance);
        this.interestRate = interestRate;
    }

    // override withdraw: require minimum balance after withdrawal (example rule)
    @Override
    public boolean withdraw(double amount) {
        double minimumBalance = 100.0; // example minimum balance
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
        if ((balance - amount) < minimumBalance) {
            System.out.println("Withdrawal would breach minimum balance of " + minimumBalance + ". Withdrawal denied.");
            return false;
        }
        return super.withdraw(amount);
    }

    // add interest as a transaction
    public void addInterest() {
        double interest = balance * (interestRate / 100.0);
        balance += interest;
        Transaction txn = new Transaction("INTEREST", interest, balance);
        transactions.add(txn);
        System.out.println("Interest added: " + String.format("%.2f", interest) + ". " + txn);
    }

    @Override
    public void printSummary() {
        System.out.println("SavingsAccount " + accountNumber + " | Owner: " + ownerUserId + " | Balance: " + String.format("%.2f", balance) + " | InterestRate: " + interestRate + "%");
    }
}
