package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Step3Tests {

    @Test
    void task_3_1_shouldHaveGettersAndSetters() {

        // given - the class we want the students to implement and the test values
        Product product = Fixtures.createProduct();

        // when - we check if it has the getters and setters

        // then - it should have the name getter and setter
        assertTrue(product.hasMethod("getName"), "Doesn't implement the name getter correctly");
        assertTrue(product.hasMethod("setName", String.class), "Doesn't implement the name setter correctly");

        // and - they should be public
        assertTrue(product.isMethodPublic("getName"), "The name getter is not public");
        assertTrue(product.isMethodPublic("setName", String.class), "The name setter is not public");

        // and - they should return the correct type
        assertTrue(product.isMethodReturnType(String.class, "getName"),
                "The name getter is not returning a String");
        assertTrue(product.isMethodReturnType(void.class, "setName", String.class),
                "The name setter is not returning a void");

        // and they should get and set the name
        assertEquals(product.getNamePropertyValue(), product.getName(), "The name getter is not well implemented.");
        product.setName("notSoCool");
        assertEquals("notSoCool",product.getNamePropertyValue(), "The name setter is not well implemented.");

        // then - it should have the brand getter and setter
        assertTrue(product.hasMethod("getBrand"), "Doesn't implement the brand getter correctly");
        assertTrue(product.hasMethod("setBrand", String.class), "Doesn't implement the brand setter correctly");

        // and - they should be public
        assertTrue(product.isMethodPublic("getBrand"), "The brand getter is not public");
        assertTrue(product.isMethodPublic("setBrand", String.class), "The brand setter is not public");

        // and - they should return the correct type
        assertTrue(product.isMethodReturnType(String.class, "getBrand"),
                "The brand getter is not returning a String");
        assertTrue(product.isMethodReturnType(void.class, "setBrand", String.class),
                "The brand setter is not returning a void");

        // and they should get and set the brand
        assertEquals(product.getBrandPropertyValue(), product.getBrand(), "The brand getter is not well implemented.");
        product.setBrand("BrandTwo");
        assertEquals("BrandTwo",product.getBrandPropertyValue(), "The brand setter is not well implemented.");

        // then - it should have the category getter and setter
        assertTrue(product.hasMethod("getCategory"), "Doesn't implement the category getter correctly");
        assertTrue(product.hasMethod("setCategory", String.class), "Doesn't implement the category setter correctly");

        // and - they should be public
        assertTrue(product.isMethodPublic("getCategory"), "The category getter is not public");
        assertTrue(product.isMethodPublic("setCategory", String.class), "The category setter is not public");

        // and - they should return the correct type
        assertTrue(product.isMethodReturnType(String.class, "getCategory"),
                "The category getter is not returning a String");
        assertTrue(product.isMethodReturnType(void.class, "setCategory", String.class),
                "The category setter is not returning a void");

        // and they should get and set the category
        assertEquals(product.getCategoryPropertyValue(), product.getCategory(), "The category getter is not well implemented.");
        product.setCategory("CAT2");
        assertEquals("CAT2",product.getCategoryPropertyValue(), "The category setter is not well implemented.");

        // then - it should have the price getter and setter
        assertTrue(product.hasMethod("getPrice"), "Doesn't implement the price getter correctly");
        assertTrue(product.hasMethod("setPrice", float.class), "Doesn't implement the price setter correctly");

        // and - they should be public
        assertTrue(product.isMethodPublic("getPrice"), "The price getter is not public");
        assertTrue(product.isMethodPublic("setPrice", float.class), "The price setter is not public");

        // and - they should return the correct type
        assertTrue(product.isMethodReturnType(float.class, "getPrice"),
                "The price getter is not returning a float");
        assertTrue(product.isMethodReturnType(void.class, "setPrice", float.class),
                "The price setter is not returning a void");

        // and they should get and set the price
        assertEquals(product.getPricePropertyValue(), product.getPrice(), "The price getter is not well implemented.");
        product.setPrice(5.0f);
        assertEquals(5.0f,product.getPricePropertyValue(), "The price setter is not well implemented.");

        // and - it should not have getter and setter for the tags property
        assertFalse(product.hasMethod("getTags"), "The Product class should not define a getter for the 'tags' property");
        assertFalse(product.hasMethod("setTags", List.class), "The Product class should not define a setter for the 'tags' property");
    }
}
