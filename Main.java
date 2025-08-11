import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Mini Bank System");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create User");
            System.out.println("2. Create Account for User (Savings/Current)");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. View Account Transaction History");
            System.out.println("6. List User Accounts");
            System.out.println("7. List All Users");
            System.out.println("8. List All Accounts");
            System.out.println("9. Add Interest to Savings Account");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine().trim();
                    bank.createUser(name, email);
                }
                case 2 -> {
                    System.out.print("Enter userId (e.g., U1001): ");
                    String userId = sc.nextLine().trim();
                    System.out.print("Choose account type (1 = Savings, 2 = Current): ");
                    int t = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Initial deposit amount: ");
                    double init = Double.parseDouble(sc.nextLine().trim());
                    if (t == 1) {
                        System.out.print("Enter interest rate (percent): ");
                        double rate = Double.parseDouble(sc.nextLine().trim());
                        bank.createSavingsAccount(userId, init, rate);
                    } else {
                        System.out.print("Enter overdraft limit: ");
                        double overd = Double.parseDouble(sc.nextLine().trim());
                        bank.createCurrentAccount(userId, init, overd);
                    }
                }
                case 3 -> {
                    System.out.print("Enter account number: ");
                    String accNo = sc.nextLine().trim();
                    Account acc = bank.getAccount(accNo);
                    if (acc == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.print("Enter deposit amount: ");
                    double amt = Double.parseDouble(sc.nextLine().trim());
                    acc.deposit(amt);
                }
                case 4 -> {
                    System.out.print("Enter account number: ");
                    String accNo = sc.nextLine().trim();
                    Account acc = bank.getAccount(accNo);
                    if (acc == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.print("Enter withdrawal amount: ");
                    double amt = Double.parseDouble(sc.nextLine().trim());
                    acc.withdraw(amt);
                }
                case 5 -> {
                    System.out.print("Enter account number: ");
                    String accNo = sc.nextLine().trim();
                    Account acc = bank.getAccount(accNo);
                    if (acc == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    acc.printTransactionHistory();
                }
                case 6 -> {
                    System.out.print("Enter userId: ");
                    String userId = sc.nextLine().trim();
                    List<String> accs = bank.getAccountsOfUser(userId);
                    if (accs.isEmpty()) {
                        System.out.println("No accounts for this user or user not found.");
                    } else {
                        System.out.println("Accounts for user " + userId + ":");
                        for (String a : accs) {
                            System.out.println(a);
                        }
                    }
                }
                case 7 -> bank.listAllUsers();
                case 8 -> bank.listAllAccounts();
                case 9 -> {
                    System.out.print("Enter savings account number: ");
                    String accNo = sc.nextLine().trim();
                    Account acc = bank.getAccount(accNo);
                    if (acc instanceof SavingsAccount) {
                        ((SavingsAccount) acc).addInterest();
                    } else {
                        System.out.println("Not a Savings Account or account not found.");
                    }
                }
                case 10 -> {
                    System.out.println("Exiting. Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
