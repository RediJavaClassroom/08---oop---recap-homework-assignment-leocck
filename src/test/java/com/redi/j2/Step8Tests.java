package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.ClothingProduct;
import com.redi.j2.proxies.Returnable;
import com.redi.j2.proxies.ReturnableClothingProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Step8Tests {

    // given - the class we want the students to implement
    ReturnableClothingProduct product = Fixtures.createReturnableClothingProductExample();

    @Test
    void task_8_1_extendsClothingProduct() {

        // it should extend ClothingProduct and implement Returnable
        Returnable r = Fixtures.createReturnableExample();
        assertNotNull(r.getTargetClass(), "Returnable interface is not implemented");
        assertTrue(product.implementsInterface(r.getTargetClass()), "The ReturnableClothingProduct should implements Returnable");
        assertTrue(product.extendsClass("com.redi.j2.ClothingProduct"), "The ReturnableClothingProduct should extends ClothingProduct");

    }

    @Test
    void task_8_2_have_RETURN_DAYS_Variable() {

        // then it should have the RETURN_DAYS property
        assertTrue(product.hasProperty("RETURN_DAYS"), "Property 'RETURN_DAYS' is not defined");
        // and - it should be of type int
        assertTrue(product.isPropertyOfType("RETURN_DAYS", int.class), "Property 'RETURN_DAYS' is not of type int");
        // and - it should be final
        assertTrue(product.isPropertyFinal("RETURN_DAYS"), "Property 'RETURN_DAYS' must be final");
        // and - it should be set to 30
        assertEquals(30, product.getReturnDaysValue(), "Property 'RETURN_DAYS' should be set to 30");
    }

    @Test
    void task_8_3_getReturnDaysShouldReturnTheConstant() {

        // then - the getReturnDays() method should return the RETURN_DAYS value
        assertEquals(product.getReturnDaysValue(), product.getReturnDays(), "the getReturnDays() should return the value in RETURN_DAYS");
    }

    @Test
    void task_8_4_shouldOverrideToString() {

        // then - it should have the toString() method
        assertTrue(product.hasMethod("toString"), "Doesn't implement the toString() method");

        // and - it should be public
        assertTrue(product.isMethodPublic("toString"), "The toString() method is not public");

        // and - it should display all the properties for the product
        product.addTag("myCoolTag");
        String result = product.toString();

        assertNotEquals(-1, result.indexOf(product.getName()), "The toString() is not well implemented, name is not shown.");
        assertNotEquals(-1, result.indexOf(product.getBrand()), "The toString() is not well implemented, brand is not shown.");
        assertNotEquals(-1, result.indexOf(product.getCategory()), "The toString() is not well implemented, category is not shown.");
        assertNotEquals(-1, result.indexOf(Float.toString(product.getPrice())), "The toString() is not well implemented, price is not shown.");
        assertNotEquals(-1, result.indexOf("myCoolTag"), "The toString() is not well implemented, tags are not shown.");

        // and - it should display the returnable string
        String returnableString = "The item is returnable within " + product.getReturnDaysValue() + "days";

        assertNotEquals(-1, result.indexOf(returnableString), "The toString() is not well implemented, the return days value is not shown.");
    }
}
