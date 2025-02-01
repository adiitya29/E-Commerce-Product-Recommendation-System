import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class DataManager {

    private Map<Integer, User> users;
    private Map<Integer, Product> products; 

    public DataManager() {
        users = new HashMap<>();
        products = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(int userID) {
        return users.get(userID);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Product getProduct(int productID) {
        return products.get(productID);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public List<Product> recommendProducts(int userID) {
        User user = getUser(userID);
        if (user == null) {
            System.out.println("err.... user not found.");
            return new ArrayList<>();
        }

        Set<String> purchasedProducts = new HashSet<>(user.getPurchasedProducts());
        Set<String> purchasedCategories = new HashSet<>();


        for (String productName : purchasedProducts) {
            for (Product product : products.values()) {
                if (product.getName().equals(productName)) {
                    purchasedCategories.add(product.getCategory());
                }
            }
        }

        List<Product> recommendations = new ArrayList<>();

  
        for (Product product : products.values()) {
            if (!purchasedProducts.contains(product.getName()) &&
                purchasedCategories.contains(product.getCategory()) &&
                product.getRating() >= 4.0) {
                recommendations.add(product);
            }
        }

        if (recommendations.isEmpty()) {
            for (Product product : products.values()) {
                if (!purchasedProducts.contains(product.getName()) && product.getRating() >= 4.0) {
                    recommendations.add(product);
                }
            }
        }

        return recommendations;
    }
}
