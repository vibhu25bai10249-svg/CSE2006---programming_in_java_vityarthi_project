import java.util.HashMap;
import java.util.Map;

public class Order {
    private String orderId;
    private String studentUsername;
    private Map<MenuItem, Integer> items = new HashMap<>();

    public Order(String orderId, String studentUsername) {
        this.orderId = orderId;
        this.studentUsername = studentUsername;
    }

    public void addItem(MenuItem item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public Map<MenuItem, Integer> getItems() { return items; }
    public String getOrderId() { return orderId; }

    public String generateReceipt() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=========================");
        sb.append("\n      CANTEEN RECEIPT    ");
        sb.append("\nOrder ID: ").append(orderId);
        sb.append("\nStudent: ").append(studentUsername);
        sb.append("\n------------------------------------");
        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            sb.append(String.format("\n%-15s x%-2d  $%.2f", 
                entry.getKey().getName(), entry.getValue(), entry.getKey().getPrice() * entry.getValue()));
        }
        sb.append("\n------------------------------------");
        sb.append(String.format("\nTOTAL PAID:              $%.2f", calculateTotal()));
        sb.append("\n=======================\n");
        return sb.toString();
    }
}