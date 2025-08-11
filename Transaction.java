import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private static int txnCounter = 1000;
    private final String transactionId;
    private final String type; // "DEPOSIT" or "WITHDRAW"
    private final double amount;
    private final String timestamp;
    private final double balanceAfter;

    public Transaction(String type, double amount, double balanceAfter) {
        this.transactionId = "TXN" + (++txnCounter);
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | Amount: %.2f | BalanceAfter: %.2f",
                transactionId, timestamp, type, amount, balanceAfter);
    }
}
