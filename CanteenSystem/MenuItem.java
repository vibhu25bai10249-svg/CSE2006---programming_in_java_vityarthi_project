public class MenuItem {
    private String id;
    private String name;
    private double price;
    private int stock;

    public MenuItem(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void reduceStock(int qty) throws InvalidOrderException {
        if (qty > stock) {
            throw new InvalidOrderException("Insufficient stock for item: " + name);
        }
        this.stock -= qty;
    }

    public void addStock(int qty) {
        this.stock += qty;
    }

    @Override
    public String toString() {
        return String.format("[%s] %-15s | Price: $%.2f | Stock: %d", id, name, price, stock);
    }
}