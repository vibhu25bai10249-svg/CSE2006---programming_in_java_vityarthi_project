import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class CanteenLogger {
    private static final String LOG_FILE = "canteen_audit.log";

    public static void logTransaction(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println("[" + LocalDateTime.now() + "] " + message);
        } catch (IOException e) {
            System.err.println("logging failure: " + e.getMessage());
        }
    }
}