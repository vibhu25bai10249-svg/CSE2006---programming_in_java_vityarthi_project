import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CanteenManager {
    private List<MenuItem> inventory = new ArrayList<>();

    public CanteenManager() {
        inventory.add(new MenuItem("101", "veg burger", 4.50, 15));
        inventory.add(new MenuItem("102", "chicken wrap", 6.00, 10));
        inventory.add(new MenuItem("103", "cold coffee", 2.50, 20));
        inventory.add(new MenuItem("104", "french fries", 3.00, 25));
    }

    public void displayInventory() {
        System.out.println("\n--- current canteen menu ---");
        for (MenuItem item : inventory) {
            System.out.println(item);
        }
    }

    public MenuItem findItemById(String id) {
        for (MenuItem item : inventory) {
            if (item.getId().equalsIgnoreCase(id)) return item;
        }
        return null;
    }

    public void processCheckout(Student student, Order order) throws InvalidOrderException {
        double total = order.calculateTotal();
        if (total == 0) {
            throw new InvalidOrderException("cart is empty! select items before checkout.");
        }

        student.deductBalance(total);

        for (Map.Entry<MenuItem, Integer> entry : order.getItems().entrySet()) {
            entry.getKey().reduceStock(entry.getValue());
        }

        CanteenLogger.logTransaction("ORDER PLACED: ID=" + order.getOrderId() + 
            " | User=" + student.getUsername() + " | Paid=$" + total);
    }
}