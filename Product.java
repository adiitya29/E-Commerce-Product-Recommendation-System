public class Product {
    private int id;
    private String name;
    private String category;
    private double rating;

    public Product(int id, String name, String category, double rating) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
    }

    public int getId() {  // Ensure this method is exactly named `getId()`
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }
}