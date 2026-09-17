import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CanteenManager manager = new CanteenManager();

        System.out.println("===============================");
        System.out.println("   Welcome to Canteen System   ");
        System.out.println("===============================");

        System.out.print("Select System Role (1: Student, 2: Vendor): ");
        int roleChoice = sc.nextInt();
        sc.nextLine();

        if (roleChoice == 1) {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            Student student = new Student(name, 50.0);
            Order currentOrder = new Order("ORD" + (System.currentTimeMillis() % 10000), student.getUsername());

            boolean running = true;
            while (running) {
                student.displayMenuOptions();
                System.out.print("Select Option: ");
                int choice = sc.nextInt();
                sc.nextLine();

                try {
                    switch (choice) {
                        case 1:
                            manager.displayInventory();
                            break;
                        case 2:
                            manager.displayInventory();
                            System.out.print("Enter Item ID: ");
                            String id = sc.nextLine();
                            MenuItem item = manager.findItemById(id);
                            if (item == null) {
                                throw new InvalidOrderException("Invalid Item ID entered!");
                            }
                            System.out.print("Enter Quantity: ");
                            int qty = sc.nextInt();
                            sc.nextLine();
                            currentOrder.addItem(item, qty);
                            System.out.println("Item successfully added to cart!");
                            break;
                        case 3:
                            manager.processCheckout(student, currentOrder);
                            System.out.println(currentOrder.generateReceipt());
                            running = false;
                            break;
                        case 4:
                            System.out.printf("Available Wallet Balance: $%.2f%n", student.getWalletBalance());
                            break;
                        case 5:
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid Menu Option.");
                    }
                } catch (InvalidOrderException e) {
                    System.err.println("\n[ERROR]: " + e.getMessage());
                    CanteenLogger.logTransaction("SYSTEM EXCEPTION: " + e.getMessage() + " | User: " + student.getUsername());
                }
            }
        } else if (roleChoice == 2) {
            System.out.print("Enter Vendor Name: ");
            String name = sc.nextLine();
            Vendor vendor = new Vendor(name);

            boolean running = true;
            while (running) {
                vendor.displayMenuOptions();
                System.out.print("Select Option: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        manager.displayInventory();
                        break;
                    case 2:
                        manager.displayInventory();
                        System.out.print("Enter Item ID to Restock: ");
                        String id = sc.nextLine();
                        MenuItem item = manager.findItemById(id);
                        if (item != null) {
                            System.out.print("Enter Restock Quantity: ");
                            int addQty = sc.nextInt();
                            item.addStock(addQty);
                            System.out.println("Stock updated!");
                            CanteenLogger.logTransaction("RESTOCK: Added " + addQty + " units to " + item.getName() + " by Vendor " + name);
                        } else {
                            System.out.println("Item not found.");
                        }
                        break;
                    case 3:
                        System.out.println("System audit records are safely persisted in 'canteen_audit.log'.");
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid Menu Option.");
                }
            }
        }
        sc.close();
        System.out.println("System session terminated successfully.");
    }
}