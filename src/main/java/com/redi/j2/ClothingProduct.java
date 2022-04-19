package com.redi.j2;

import java.util.List;

public class ClothingProduct extends Product {

    public ClothingProduct(String name, String brand, String category, float price) {
        super(name, brand, category, price);
    }

    @Override
    public List<String> retrievePaymentOptions() {
        return List.of("TryNowPayLater", "PayNow");
    }
}
