public class Vendor extends User {
    public Vendor(String username) {
        super(username, "VENDOR");
    }

    @Override
    public void displayMenuOptions() {
        System.out.println("\n--- Vendor Administrative Dashboard ---");
        System.out.println("1. View Current Stock");
        System.out.println("2. Restock Item");
        System.out.println("3. View System Log Status");
        System.out.println("4. Exit");
    }
}