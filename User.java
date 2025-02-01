// package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<String> purchasedProducts;

    // Constructor
    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.purchasedProducts = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getPurchasedProducts() {
        return purchasedProducts;
    }

    // Methods to Add Products
    public void addPurchasedProduct(String product) {
        purchasedProducts.add(product);
    }
}