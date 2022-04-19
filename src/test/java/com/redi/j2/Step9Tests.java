package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Returnable;
import com.redi.j2.proxies.ReturnableGenericProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Step9Tests {

    // given - the class we want the students to implement and the test values
    int returnDays = 90;
    ReturnableGenericProduct product = Fixtures.createReturnableGenericProductExample(90);

    @Test
    void task_9_1_extendsGenericProduct() {

        // it should extend GenericProduct and implement Returnable
        Returnable r = Fixtures.createReturnableExample();
        assertNotNull(r.getTargetClass(), "Returnable interface is not implemented");
        assertTrue(product.implementsInterface(r.getTargetClass()), "The ReturnableGenericProduct should implements Returnable");
        assertTrue(product.extendsClass("com.redi.j2.GenericProduct"), "The ReturnableGenericProduct should extends GenericProduct");
    }

    @Test
    void task_9_2_haveReturnDaysVariable() {
        // then it should have the returnDays property
        assertTrue(product.hasProperty("returnDays"), "Property 'returnDays' is not defined");
        // and - it should be of type int
        assertTrue(product.isPropertyOfType("returnDays", int.class), "Property 'returnDays' is not of type int");
    }

    @Test
    void task_9_3_shouldImplementTheConstructor() {
        // Constructor  should exist
        assertTrue(product.hasConstructor(String.class, String.class, String.class, float.class, int.class),
                "The constructor is not well defined; check order and types of the arguments");

        assertEquals(returnDays, product.getReturnDaysValue(), "The constructor is not well implemented; returnDays is not set");
    }

    @Test
    void task_9_4_shouldImplementReturnDaysGetter() {
        // returnDays getter should be implemented
        assertEquals(product.getReturnDaysValue(), product.getReturnDays(), "getReturnDays() is not implemented as returnDays getter");
    }

    @Test
    void task_9_5_shouldOverrideToString() {

        // then - it should have the toString() method
        assertTrue(product.hasMethod("toString"), "Doesn't implement the toString() method");

        // and - it should be public
        assertTrue(product.isMethodPublic("toString"), "The toString() method is not public");

        // and - it should display all the properties for the product
        product.addTag("myCoolTag");
        String result = product.toString();

        assertNotNull(result, "The toString() method is not implemented");

        assertNotEquals(-1, result.indexOf(product.getName()), "The toString() is not well implemented, name is not shown.");
        assertNotEquals(-1, result.indexOf(product.getBrand()), "The toString() is not well implemented, brand is not shown.");
        assertNotEquals(-1, result.indexOf(product.getCategory()), "The toString() is not well implemented, category is not shown.");
        assertNotEquals(-1, result.indexOf(Float.toString(product.getPrice())), "The toString() is not well implemented, price is not shown.");
        assertNotEquals(-1, result.indexOf("myCoolTag"), "The toString() is not well implemented, tags are not shown.");

        // and - it should display the returnable string
        String returnableString = "The item is returnable within " + product.getReturnDaysValue() + " days";

        assertNotEquals(-1, result.indexOf(returnableString), "The toString() is not well implemented, '"+returnableString+"' is not shown.");
    }
}
