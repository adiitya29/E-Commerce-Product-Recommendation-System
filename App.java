import java.util.List;

public class App {
    public static void main(String[] args) {
        // Initialize DataManager
        DataManager dataManager = new DataManager();

        // Add sample products
        dataManager.addProduct(new Product(1, "laptop", "Electronics", 4.1));
        dataManager.addProduct(new Product(2, "smartphone", "Electronics", 4.5));
        dataManager.addProduct(new Product(3, "geyser", "Electronics", 3.9));
        dataManager.addProduct(new Product(4, "earphones", "Electronics", 4.0));
        dataManager.addProduct(new Product(5, "t-shirt", "Clothing", 4.1));
        dataManager.addProduct(new Product(6, "jeans", "Clothing", 4.0));

        // Create user and add purchase history
        User user1 = new User(1001, "Aditya");
        dataManager.addUser(user1); // Ensure user is added to DataManager

        user1.addPurchasedProduct("laptop"); // Corrected method name

        // Generate and display recommendations
        List<Product> recommendedProducts = dataManager.recommendProducts(1001);
        System.out.println("Recommended products for: " + user1.getName() + ":");
        for (Product product : recommendedProducts) {
            System.out.println("-> " + product.getName() + " (Category: " + product.getCategory() + ", Rating: " + product.getRating() + ")");
        }
    }
}