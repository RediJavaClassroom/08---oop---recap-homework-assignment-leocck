package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Product;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

public class Step4Tests {

    String name = "CoolItem";
    String brand = "BrandOne";
    String category = "CAT1";
    float price = 10.0f;
    Product product = Fixtures.createProduct(name, brand, category, price);

    @Test
    void task_4_1_priceSetterShouldRejectNegativeValues() {

        // given - the class we want the students to implement and the test values

        // when - we check if the price setter has meaningful values

        // then - it should have the price setter rejecting negative values
        product.setPrice(-5.0f);
        assertTrue(product.getPricePropertyValue() >= 0, "The price setter is not well implemented, negative prices should be rejected");
    }

    @Test
    void task_4_2_shouldImplementAddTag() {

        // given - the class we want the students to implement and the test values

        // when - we check if it has the add tag method

        // then - it should have the addTag() method
        assertTrue(product.hasMethod("addTag", String.class), "Doesn't implement the addTag() method");

        // and - it should be public
        assertTrue(product.isMethodPublic("addTag", String.class), "The addTag() method is not public");

        // and - they should return the correct type
        assertTrue(product.isMethodReturnType(void.class, "addTag", String.class),
                "The addTag() method is not returning a void");

        // and - it should add the tag to the list
        product.addTag("myCoolTag");
        List<String> tags = product.getTagsPropertyValue();
        assertTrue(tags.contains("myCoolTag"), "The addTag() is not well implemented, tags are not added to the list.");

        product.addTag("myCoolTag");
        Set<String> set = new HashSet<String>(product.getTagsPropertyValue());

        assertTrue(set.size() == tags.size(), "The addTag() is not preventing duplicates.");

    }

    @Test
    void task_4_3_shouldImplementHasTag() {

        // given - the class we want the students to implement and the test values

        // when - we check if it has the hasTag method

        // then - it should have the hasTag() method
        assertTrue(product.hasMethod("hasTag", String.class), "Doesn't implement the hasTag() method");

        // and - it should be public
        assertTrue(product.isMethodPublic("hasTag", String.class), "The hasTag() method is not public");

        // and - they should return the correct type
        assertTrue(product.isMethodReturnType(boolean.class, "hasTag", String.class),
                "The hasTag() method is not returning a boolean");

        // and - it should return true if tag is there
        product.addTag("myCoolTag");
        assertTrue(product.hasTag("myCoolTag"), "The hasTag() is not well implemented, tags in the list are not recognized.");
        assertFalse(product.hasTag("myOtherCoolTag"), "The hasTag() is not well implemented, tags not in the list are not recognized.");

    }


    @Test
    void task_4_4_shouldImplementRemoveTag() {

        // given - the class we want the students to implement and the test values

        // when - we check if it has the remove tag method

        // then - it should have the removeTag() method
        assertTrue(product.hasMethod("removeTag", String.class), "Doesn't implement the removeTag() method");

        // and - it should be public
        assertTrue(product.isMethodPublic("removeTag", String.class), "The removeTag() method is not public");

        // and - they should return the correct type
        assertTrue(product.isMethodReturnType(void.class, "removeTag", String.class),
                "The removeTag() method is not returning a void");

        // and - it should remove the tag to the list
        product.addTag("myCoolTag");
        product.removeTag("myCoolTag");
        List<String> tags = product.getTagsPropertyValue();
        assertFalse(tags.contains("myCoolTag"), "The removeTag() is not well implemented, tags are not removed from the list.");

    }


    @Test
    void task_4_4_shouldImplementToString() {

        // given - the class we want the students to implement and the test values

        // when - we check if it has the toString method

        // then - it should have the toString() method
        assertTrue(product.hasMethod("toString"), "Doesn't implement the toString() method");

        // and - it should be public
        assertTrue(product.isMethodPublic("toString"), "The toString() method is not public");

        // and - they should return the correct type
        assertTrue(product.isMethodReturnType(String.class, "toString"),
                "The toString() method is not returning a String");

        // and - it should display all the properties for the product
        product.addTag("myCoolTag");
        String result = product.toString();

        assertNotEquals(-1, result.indexOf(name), "The toString() is not well implemented, name is not shown.");
        assertNotEquals(-1, result.indexOf(brand), "The toString() is not well implemented, brand is not shown.");
        assertNotEquals(-1, result.indexOf(category), "The toString() is not well implemented, category is not shown.");
        assertNotEquals(-1, result.indexOf(Float.toString(price)), "The toString() is not well implemented, price is not shown.");
        assertNotEquals(-1, result.indexOf("myCoolTag"), "The toString() is not well implemented, tags are not shown.");

    }
}
