import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private final Map<String, User> users = new HashMap<>(); // userId -> User
    private final Map<String, Account> accounts = new HashMap<>(); // accountNumber -> Account
    private final Map<String, List<String>> userAccounts = new HashMap<>(); // userId -> list of accountNumbers

    // create user
    public User createUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getUserId(), user);
        userAccounts.put(user.getUserId(), new ArrayList<>());
        System.out.println("Created user: " + user);
        return user;
    }

    // create savings account
    public Account createSavingsAccount(String userId, double initialDeposit, double interestRate) {
        if (!users.containsKey(userId)) {
            System.out.println("User not found: " + userId);
            return null;
        }
        SavingsAccount acc = new SavingsAccount(userId, initialDeposit, interestRate);
        accounts.put(acc.getAccountNumber(), acc);
        userAccounts.get(userId).add(acc.getAccountNumber());
        System.out.println("Created Savings Account: " + acc.getAccountNumber() + " for user " + userId);
        return acc;
    }

    // create current account
    public Account createCurrentAccount(String userId, double initialDeposit, double overdraftLimit) {
        if (!users.containsKey(userId)) {
            System.out.println("User not found: " + userId);
            return null;
        }
        CurrentAccount acc = new CurrentAccount(userId, initialDeposit, overdraftLimit);
        accounts.put(acc.getAccountNumber(), acc);
        userAccounts.get(userId).add(acc.getAccountNumber());
        System.out.println("Created Current Account: " + acc.getAccountNumber() + " for user " + userId);
        return acc;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public List<String> getAccountsOfUser(String userId) {
        return userAccounts.getOrDefault(userId, new ArrayList<>());
    }

    public void listAllUsers() {
        System.out.println("=== Users ===");
        for (User u : users.values()) {
            System.out.println(u);
        }
    }

    public void listAllAccounts() {
        System.out.println("=== Accounts ===");
        for (Account a : accounts.values()) {
            a.printSummary();
        }
    }
}
