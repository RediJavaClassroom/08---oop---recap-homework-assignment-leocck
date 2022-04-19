package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Step2Tests {
    @Test
    void task_2_1_shouldHaveAConstructor() {

        // given - the class we want the students to implement and the test values
        String name = "CoolItem";
        String brand = "BrandOne";
        String category = "CAT";
        float price = 10.0f;
        Product product = Fixtures.createProduct(name, brand, category, price);

        // when - we check if it has the constructor

        // then - it should exist
        assertTrue(product.hasConstructor(String.class, String.class, String.class, float.class),
                "The constructor is not well defined; check order and types of the arguments");

        // and - it should assign the correct values
        assertEquals(name, product.getNamePropertyValue(),
                "The constructor is not well implemented; name is not set.");
        assertEquals(brand, product.getBrandPropertyValue(),
                "The constructor is not well implemented; brand is not set.");
        assertEquals(category, product.getCategoryPropertyValue(),
                "The constructor is not well implemented; category is not set.");
        assertEquals(price, product.getPricePropertyValue(),
                "The constructor is not well implemented; price is not set.");

        // and - list of tags should be empty at the beginning
        assertNotNull(product.getTagsPropertyValue(), "The list of tags is not initialized");

        assertEquals(0, product.getTagsPropertyValue().size(), "The list of tags is not initialized as empty");

    }
}
