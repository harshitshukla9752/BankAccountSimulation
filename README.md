# Bank Account Simulation – Java OOP Project

## 📌 Overview
This is a Java console-based banking system demonstrating **Object-Oriented Programming (OOP)** concepts such as **Inheritance, Encapsulation, Polymorphism, and Abstraction**.  
The system allows users to:
- Create Savings or Current accounts
- Deposit and withdraw funds (with account-specific rules)
- Automatically generate **Account Numbers** and **Transaction IDs**
- Keep track of a complete transaction history

---

## 📂 Folder Structure
BankAccountSimulation/
├── Main.java # Program entry point & console menu
├── User.java # Represents a bank customer
├── Account.java # Abstract base class for all accounts
├── SavingsAccount.java # Savings account implementation
├── CurrentAccount.java # Current account implementation
├── Transaction.java # Transaction record model
├── Bank.java # Bank management logic & operations
├── output-1.png # Screenshot of program output
├── output-2.png
├── output-3.png
├── output-4.png
├── output-5.png
├── output-6.png
├── output-7.png
├── output-8.png
└── README.md

---

## ✅ Features
- Create **Savings** or **Current** accounts
- Auto-generate **Account Numbers** & **Transaction IDs**
- Deposit funds
- Withdraw funds with account-specific rules
- Store & view full transaction history
- Display user and account details
- Separate transaction logs per account
- Inheritance for account types, overriding withdrawal logic

---

## 🛠 Requirements
- Java 8 or above  
- IDE (VS Code, IntelliJ IDEA, Eclipse) **or** Terminal

---

## ▶️ How to Run
1. **Clone** or **Download** this repository
2. Open a terminal inside `BankAccountSimulation/`
3. Compile all `.java` files:
   ```bash
   javac *.java
   java Main

---

📚 Key OOP Concepts Demonstrated
Encapsulation → Private fields with getters & setters

Inheritance → SavingsAccount and CurrentAccount extend Account

Polymorphism → Overridden withdraw methods for account types

Abstraction → Common account behavior in Account abstract class

Static ID Generation → Auto-increment for accounts & transactions

Data Storage → ArrayList for transactions and user accounts

🔮 Future Enhancements
Persistence Layer

Store data in a database (MySQL/PostgreSQL/MongoDB) instead of memory

Authentication System

Login with username/password, password hashing (BCrypt/SHA-256)

Interest Calculation

Automatically credit interest to Savings accounts monthly

Joint Accounts

Multiple users per account

Transaction Limits

Daily withdrawal limit and overdraft for Current accounts

Export Transaction History

Save as CSV or PDF

Graphical Interface

JavaFX or Swing for better UI

REST API Integration

Build backend services with Spring Boot

⚙️ Possible Changes for Scalability
Replace ArrayList with HashMap<String, Account> for O(1) lookups

Add TransactionService class to handle transaction logic separately

Use UUID instead of incremental IDs for accounts & transactions

Implement Singleton (Bank) and Factory (Account creation) patterns

📜 License
This project is for learning purposes only and comes with no warranty.
