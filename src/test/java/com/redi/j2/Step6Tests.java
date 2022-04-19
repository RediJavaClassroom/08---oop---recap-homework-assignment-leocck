package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.ClothingProduct;
import com.redi.j2.proxies.GenericProduct;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Step6Tests {

    String option1 = "PayNow";
    String option2 = "TryNowPayLater";

    @Test
    void task_6_1_ClothingProductShouldntBeAbstractAndReturnTwoPaymentOptions() {

        // given - the class we want the students to implement and the test values
        ClothingProduct product = Fixtures.createClothingProductExample();

        // when - we check if the class is not abstract
        assertFalse(product.isAbstract(), "The ClothingProduct shouldn't be abstract");
        List<String> paymentOptions = product.retrievePaymentOptions();

        // then - it should implement the method retrievePaymentOptions() returning both the options
        assertNotNull(paymentOptions, "Method 'retrievePaymentOptions' is not implemented");
        assertTrue(paymentOptions.contains(option1), "The ClothingProduct should contain the " + option1 + " payment option.");
        assertTrue(paymentOptions.contains(option2), "The ClothingProduct should contain the " + option2 + " payment option.");
        assertEquals(2, paymentOptions.size(), "The ClothingProduct should contain only 2 payment options.");
    }

    @Test
    void task_6_2_GenericProductShouldntBeAbstractAndReturnTwoPaymentOptions() {

        // given - the class we want the students to implement and the test values

        GenericProduct product = Fixtures.createGenericProductExample();

        // when - we check if the class is not abstract
        assertFalse(product.isAbstract(), "The GenericProduct shouldn't be abstract");
        List<String> paymentOptions = product.retrievePaymentOptions();

        // then - it should implement the method retrievePaymentOptions() returning both the options
        assertNotNull(paymentOptions, "Method 'retrievePaymentOptions' is not implemented");
        assertTrue(paymentOptions.contains(option1), "The GenericProduct should contain the " + option1 + " payment option.");
        assertEquals(1, paymentOptions.size(), "The GenericProduct should contain only 1 payment option.");

    }

}
