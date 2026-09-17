# Canteen System

A Java-based command line application (CLI) designed to automate canteen ordering, digital wallet payments, stock management, and transaction management. Built using core Object Oriented Programming (OOP) principles and robust Java File I/O.

---

## Key Features

### Student Role
* **Food catalog:** Browse live menu items, prices, and available stock.
* **Order cart:** Add items and desired quantities to a cart.
* **Digital wallet:** Automatic balance validation and payment deduction during checkout.
* **Receipt generation:** Displays bought item's printouts upon successful checkout.

### Vendor / Admin Role
* **Stock monitoring:** Inspect realntime stock levels across all menu items.
* **Restock management:** Replenish item quantities directly from the administrative dashboard.
* **Audit notice:** Quick reference to persisted transaction logs.

### System & Non-Functional Features
* **Custom Exception Handling:** Catches cases such as insufficient wallet funds, depleted stock, or invalid item IDs (`InvalidOrderException`).
* **Persistent Audit Logging:** Logs system events, completed orders, restock events, and runtime errors to `canteen_audit.log` (`CanteenLogger`).

---

## File Structure


CanteenSystem/
* InvalidOrderException.java  # Custom exception for domain-specific errors
* MenuItem.java               # Entity class for food items and stock
* User.java                   # Abstract base class for system users
* Student.java                # Student user representation with wallet logic
* Vendor.java                 # Vendor/Admin user representation
* Order.java                  # Cart aggregator, bill calculation, receipt formatter
* CanteenLogger.java          # File I/O helper for audit logging
* CanteenManager.java         # Core business controller for catalog & checkout
* MainApp.java                # Main entry point containing menu loops


---

## OOP Architecture Highlights

* **Inheritance & Polymorphism:** `User` serves as an abstract parent class extended by `Student` and `Vendor`, enforcing polymorphic option rendering via `displayMenuOptions()`.
* **Encapsulation:** Object state (such as prices, stock, and wallet balances) is encapsulated with private field access controlled via getters and transactional update methods.
* **Abstraction:** Business logic (`CanteenManager`) and storage operations (`CanteenLogger`) are separated from user interface rendering (`MainApp`).

---

## How to Run in VS Code

### Prerequisites
1. **Java Development Kit (JDK 8 or higher):** Installed and configured on your computer.
2. **Visual Studio Code:** Installed on your computer.
3. **Extension Pack for Java:** Installed in VS Code (by Microsoft).

### Step-by-Step Instructions

1. **Open Folder in VS Code:**
   * Launch VS Code.
   * Go to `File` > `Open Folder...`.
   * Select the `CanteenSystem` project folder.

2. **Open the Main Application File:**
   * In the Explorer pane on the left, click on `MainApp.java` to open it.

3. **Run the Program:**
   * Click the **Run** button (play icon) at the top-right corner of VS Code.
   * Alternatively, press `F5` or `Ctrl+F5`.

4. **Interact with the Application:**
   * The program will run inside the built-in VS Code Terminal panel at the bottom.
   * Type your selections and press `Enter` to interact with the student and vendor menus.

---

## Audit Logs

All operational logs (successful checkouts, vendor restocks, and caught exceptions) automatically append to a text file created in the project directory named:

```text
canteen_audit.log
```
