Bank System – Java OOP Project
Overview
This is a Java console-based banking system demonstrating Object-Oriented Programming (OOP) concepts such as inheritance, encapsulation, polymorphism, and abstraction.
The system allows users to create accounts, make deposits/withdrawals, and keep track of transaction history.
It supports auto-generated Account Numbers and Transaction IDs, and handles Savings and Current account types with their own withdrawal rules.

Folder Structure
bash
Copy
Edit
BankSystem/
 ├── Main.java              # Program entry point & user interaction
 ├── User.java              # Represents a bank customer
 ├── Account.java           # Abstract base class for accounts
 ├── SavingsAccount.java    # Savings account implementation
 ├── CurrentAccount.java    # Current account implementation
 ├── Transaction.java       # Transaction record model
 ├── Bank.java              # Bank management logic
Features
✅ Create new Savings or Current accounts
✅ Auto-generate Account Numbers & Transaction IDs
✅ Deposit funds
✅ Withdraw funds with account-specific rules
✅ Store & view full transaction history
✅ Display user and account details
✅ Unique account type handling using inheritance
✅ Separate transaction logs per account

Requirements
Java 8 or above

IDE (IntelliJ IDEA, Eclipse, VS Code) or terminal

How to Run
Clone or download the project

Open terminal in BankSystem/

Compile all files:

bash
Copy
Edit
javac *.java
Run:

bash
Copy
Edit
java Main
Sample Console Flow
pgsql
Copy
Edit
Welcome to Bank System!
1. Create Account
2. Deposit
3. Withdraw
4. View Transactions
5. Exit
Enter choice: 1
Enter name: Rahul Sharma
Select Account Type: 1. Savings  2. Current
1
Account created successfully!
Account Number: ACC1001
Key Concepts Demonstrated
Encapsulation → Private fields with getters/setters

Inheritance → Savings & Current accounts extend Account class

Polymorphism → Overridden withdraw methods for each account type

Abstraction → Common account behavior in Account abstract class

Static ID Generation → Auto increment for accounts & transactions

Data Storage → ArrayList for transactions and user accounts

Future Expectations & Improvements
Planned Enhancements
Persistence Layer

Currently, data is in-memory only.

Add database support (MySQL/PostgreSQL/MongoDB) to store users, accounts, and transactions permanently.

Authentication System

Implement login with username/password for each user.

Hash passwords with BCrypt or SHA-256.

Interest Calculation

Automatically calculate & credit interest to SavingsAccount at the end of each month.

Multiple Users per Account (Joint Accounts)

Allow accounts to have more than one authorized user.

Transaction Limits

Add daily withdrawal limits and overdraft facility for CurrentAccount.

Export Transaction History

Export as CSV or PDF for printing or emailing.

Graphical Interface

Upgrade from CLI to JavaFX or Swing for better UI.

REST API Integration

Turn this into a backend service with Spring Boot and expose APIs.

Possible Changes for Better Scalability
Replace ArrayList with HashMap<String, Account> for O(1) account lookup.

Create a TransactionService class to handle all transaction logic separately.

Use UUID instead of incremental IDs for account & transaction numbers.

Implement design patterns like Singleton (for Bank) and Factory (for creating accounts).

License
This project is for learning purposes only and has no warranty.
