# 🏪 Market Management System

## 📖 Overview
The **Market Management System** is a desktop application developed as a **Second Year Computer Science – Information Systems** course project.  
It aims to help market administrators efficiently manage products, customers, suppliers, sales, and receipts, while also supporting a **customer loyalty points system**.

The system provides tools for tracking inventory, monitoring sales, managing receipts, and analyzing sales data based on specific dates.

---

## 🎯 Features

### 🧑‍💼 Administrator Functions
- Manage products, customers, categories, and suppliers
- Track:
  - Product quantities
  - Selling prices
  - Purchasing prices
  - Sales transactions
- Generate and store sales receipts
- Filter sales and receipts by specific date

### 📦 Product Management
- Each product belongs to a category and a supplier
- Each product includes:
  - Selling price
  - Purchasing price
  - Available quantity
  - Reward (selling) points

### 👥 Customer Management & Loyalty System
- Customers earn **points** when purchasing products
- Points are automatically added to the customer’s balance
- Customers can **redeem points** to purchase products
- Points balance is updated after every transaction

---

## 🧩 System Modules
- Customers
- Categories
- Suppliers
- Products
- Sales
- Receipts
- Loyalty Points Management

---

## 🛠️ Technologies Used
- Programming Language: Java
- Database: MySQL
- GUI: Java Swing
- IDE: NetBeans

---

## 📊 Reporting & Filtering
- View all sales transactions
- Filter receipts and sales by:
  - Specific date
- Track total sales and product movement

---

## 🎓 Academic Context
- Course: Information Systems
- Level: Second Year – Computer Science
- Project Type: Team Project

---

## 🤝 Team Contribution
This project was developed as a **team project**.  
All team members contributed to the system design, implementation, and testing.

---

## 📌 Notes
- This project is intended for educational purposes.
- The system can be extended with additional features such as:
  - User roles and permissions
  - Monthly sales reports
  - Exporting receipts to PDF

---

## ▶️ How to Run / Install

### Prerequisites
- Java JDK 8 or later
- NetBeans IDE (recommended)
- MySQL Server
- MySQL Connector/J (JDBC)

## ▶️ How to Run / Install

### Prerequisites
- Java JDK 8 or later
- NetBeans IDE (recommended)
- MySQL Server
- MySQL Connector/J (JDBC Driver)

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
2. **Open the project**
  - Open NetBeans
  - Select File → Open Project
  - Choose the cloned project folder
3. **Add MySQL Connector/J**
  - Download MySQL Connector/J
  - In NetBeans:
    - Right-click the project → Properties
    - Go to Libraries
    - Click Add JAR/Folder
    - Select the MySQL Connector/J .jar file
4. **Create the database**
  - Open MySQL
  - Create a new database (e.g. marketsystem)
  - Import the provided SQL file (if available)
5. **Configure database connection**
  - Open the file:
      ```
      DatabaseConnection.java
  - Update the following values:
     ```java
    static final String DB_URL = "jdbc:mysql://localhost/marketsystem";
    static final String USER = "root";
    static final String PASS = "root";
6. **Run the application**
  - Click Run Project in NetBeans
  - The application will connect to the database and start normally
