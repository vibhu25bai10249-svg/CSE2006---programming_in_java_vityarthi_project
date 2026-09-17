public class Student extends User {
    private double walletBalance;

    public Student(String username, double walletBalance) {
        super(username, "STUDENT");
        this.walletBalance = walletBalance;
    }

    public double getWalletBalance() { return walletBalance; }

    public void deductBalance(double amount) throws InvalidOrderException {
        if (amount > walletBalance) {
            throw new InvalidOrderException("Insufficient wallet balance. Total required: $" + amount);
        }
        this.walletBalance -= amount;
    }

    @Override
    public void displayMenuOptions() {
        System.out.println("\n--- Student Menu ---");
        System.out.println("1. View Food Catalog");
        System.out.println("2. Add Item to Order Cart");
        System.out.println("3. View Cart & Checkout");
        System.out.println("4. Check Wallet Balance");
        System.out.println("5. Exit");
    }
}