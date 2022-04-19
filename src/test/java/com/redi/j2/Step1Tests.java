package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class Step1Tests {

    Product product = Fixtures.createProduct();

    @Test
    void task_1_0_shouldCreateTheClassProduct() {

        // given - the class we want the students to implement

        // when - we check if it exists

        // then - it should exist
        assertTrue(product.existsClass(), "Product class is not defined");

        // and - it should be abstract
        assertTrue(product.isAbstract(), "Product class must be abstract");
    }

    @Test
    void task_1_1_shouldHaveNameProperty() {

        // given - the class we want the students to implement

        // when - we check if the name property exists

        // then - it should exist
        assertTrue(product.hasProperty("name"), "Property 'name' is not defined");

        // and - it should be of type String
        assertTrue(product.isPropertyOfType("name", String.class), "Property 'name' is not of type String");

        // and - it must be private
        assertTrue(product.isPropertyPrivate("name"), "Property 'name' must be private");
    }

    @Test
    void task_1_2_shouldHaveBrandProperty() {

        // given - the class we want the students to implement

        // when - we check if the brand property exists

        // then - it should exist
        assertTrue(product.hasProperty("brand"), "Property 'brand' is not defined");

        // and - it should be of type String
        assertTrue(product.isPropertyOfType("brand", String.class), "Property 'brand' is not of type String");

        // and - it must be private
        assertTrue(product.isPropertyPrivate("brand"), "Property 'brand' must be private");
    }

    @Test
    void task_1_3_shouldHaveCategoryProperty() {

        // given - the class we want the students to implement

        // when - we check if the category property exists

        // then - it should exist
        assertTrue(product.hasProperty("category"), "Property 'category' is not defined");

        // and - it should be of type String
        assertTrue(product.isPropertyOfType("category", String.class), "Property 'category' is not of type String");

        // and - it must be private
        assertTrue(product.isPropertyPrivate("category"), "Property 'category' must be private");
    }

    @Test
    void task_1_4_shouldHavePriceProperty() {

        // given - the class we want the students to implement

        // when - we check if the price property exists

        // then - it should exist
        assertTrue(product.hasProperty("price"), "Property 'price' is not defined");

        // and - it should be of type float
        assertTrue(product.isPropertyOfType("price", float.class), "Property 'price' is not of type float");

        // and - it must be private
        assertTrue(product.isPropertyPrivate("price"), "Property 'price' must be private");
    }

    @Test
    void task_1_6_shouldHaveTagsProperty() {

        // given - the class we want the students to implement

        // when - we check if the tags property exists

        // then - it should exist
        assertTrue(product.hasProperty("tags"), "Property 'tags' is not defined");

        // and - it should be of type List<String>
        assertTrue(product.isPropertyOfType("tags", List.class, String.class), "Property 'tags' is not of type List<String>");

        // and - it must be private
        assertTrue(product.isPropertyPrivate("tags"), "Property 'tags' must be private");
    }
}
