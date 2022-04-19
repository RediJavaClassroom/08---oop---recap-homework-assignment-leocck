package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Step5Tests {

    @Test
    void task_5_1_shouldHaveSignatureForRetrievePaymentOptions() {

        // given - the class we want the students to implement
        Product product = Fixtures.createProduct();

        // when - we check if it has the abstract method retrievePaymentOptions()

        // then - it should have the addTag() method
        assertTrue(product.hasMethod("retrievePaymentOptions"), "Doesn't declare the retrievePaymentOptions() method");

        // and - it should be public
        assertTrue(product.isMethodPublic("retrievePaymentOptions"), "The retrievePaymentOptions() method is not public");

        // and - it should be public
        assertTrue(product.isMethodAbstract("retrievePaymentOptions"), "The retrievePaymentOptions() method is not abstract");

        // and - it should return a List of Strings
        assertTrue(product.isMethodReturnType(List.class, String.class,"retrievePaymentOptions"), "The retrievePaymentOptions() method is not returning a List of Strings");

    }

}
