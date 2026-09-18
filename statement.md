# Canteen Management System - Project Statement

## 1. Problem Statement
Traditional campus canteen operations rely heavily on manual order processing, paper billing, and cash transactions. This reliance causes significant bottlenecks during peak hours, resulting in long waiting lines, human errors during order taking, and accounting discrepancies. Furthermore, canteens lack real-time stock tracking, leading to unfulfilled orders during stock-outs, and lack persistent transaction logs for historical auditing.

## 2. Scope of the Project
The **Canteen Management System** is a console-based Java application designed to digitize and automate ordering, inventory control, and transaction auditing.

### In-Scope
* **Role-Based Interfaces:** Distinct operational modes for Students (ordering & checkout) and Vendors (inventory management).
* **Digital Wallet Integration:** Automated payment validation, balance tracking, and cashless checkout processing.
* **Dynamic Inventory Control:** Automatic stock reduction upon purchase and manual inventory restocking by vendors.
* **Error Handling & Validation:** Custom domain exceptions (`InvalidOrderException`) for insufficient funds, invalid item IDs, or depleted stock.
* **Audit Persistence:** Logging all transactions, restocking events, and system errors with timestamps to `canteen_audit.log`.

### Out-of-Scope (Future Enhancements)
* Graphical User Interface (GUI) or web interface integration.
* External payment gateway integration (e.g., UPI, credit cards).
* Relational database integration (MySQL/PostgreSQL).

## 3. Target Users
* **Students / Customers:** Campus users who browse food menus, add items to a cart, pay via digital wallet balance, and review receipts.
* **Canteen Vendors / Administrators:** Canteen staff responsible for monitoring inventory levels, replenishing food stock, and reviewing transaction logs.

## 4. High-Level Features
* **Role-Based Access Control:** User prompt to toggle between Student and Vendor operational modes.
* **Interactive Catalog & Cart System:** Live display of menu items, item prices, stock availability, dynamic order aggregation, and receipt formatting.
* **Digital Wallet & Checkout Processing:** Instant balance verification and fund deduction upon purchase completion.
* **Inventory Restocking Dashboard:** Vendor capabilities to track live stock and add inventory units.
* **Persistent Audit Logging:** Java File I/O system logger recording runtime events and exceptions to a persistent text file.
