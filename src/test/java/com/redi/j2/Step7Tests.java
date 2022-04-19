package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Returnable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Step7Tests {

    @Test
    void task_7_1_hasReturnableInterface() {

        // given - the class we want the students to implement and the test values
        Returnable iReturnable = Fixtures.createReturnableExample();

        // when - we check if the class is an interface
        assertTrue(iReturnable.isInterface());

        // then - it should have the signature for getReturnDays()
        assertTrue(iReturnable.hasMethod("getReturnDays"), "The Returnable interface should declare the getReturnDays() method");
        assertTrue(iReturnable.isMethodPublic("getReturnDays"), "The getReturnDays() should be declared as public");
        assertTrue(iReturnable.isMethodReturnType(int.class,"getReturnDays"), "The getReturnDays() return type should be declared as string");

    }

}
