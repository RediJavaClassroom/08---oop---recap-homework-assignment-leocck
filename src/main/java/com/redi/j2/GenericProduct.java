package com.redi.j2;

import java.util.List;

public class GenericProduct extends Product {

    public GenericProduct(String name, String brand, String category, float price) {
        super(name, brand, category, price);
    }

    @Override
    public List<String> retrievePaymentOptions() {
        return List.of("PayNow");
    }
}
