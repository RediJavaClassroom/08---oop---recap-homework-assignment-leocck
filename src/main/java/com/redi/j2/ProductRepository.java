package com.redi.j2;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public ProductRepository() {

    }

    public void addProduct(Product p) {
        if (products.contains(p)) return;
        products.add(p);
    }

    public void removeProduct(Product p) {
        products.remove(p);
    }

    public Product getProduct(String name, String brand) {
        for (Product p : products) {
            if (p.getName().equals(name) && p.getBrand().equals(brand)) return p;
        }
        return null;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> response = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equals(category)) response.add(p);
        }
        return response;
    }
}
