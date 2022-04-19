package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Product;
import com.redi.j2.proxies.GenericProduct;
import com.redi.j2.proxies.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Step10Tests {

    @Test
    void task_10_0_shouldCreateClass() {

        // given - the class we want the students to implement
        ProductRepository products = Fixtures.createProductRepositoryExample();

        // then - it should exist
        assertTrue(products.existsClass(), "Class ProductRepository must be created");
    }

    @Test
    void task_10_1_shouldHaveAListOfProducts() {

        // given - the class we want the students to implement
        ProductRepository products = Fixtures.createProductRepositoryExample();

        // and - the Product class
        Product product = Fixtures.createProduct();

        // then - it should have a products property
        assertTrue(products.hasProperty("products"), "Property 'products' is not defined");

        // and - it should be of type List<Product>
        assertTrue(products.isPropertyOfType("products", List.class, product.getTargetClass()), "Property 'products' is not of type List<AbstractClass>");
    }

    @Test
    void task_10_2_shouldHaveANoArgConstructor() {

        // given - the class we want the students to implement
        ProductRepository products = Fixtures.createProductRepositoryExample();

        // then - it should have a noArg constructor
        assertTrue(products.hasConstructor(), "ProductRepository doesn't have a no arguments constructor");

        // and - the constructor should initialize the products to an empty list
        List<?> list = products.getProducts();
        assertNotNull(list, "The products list is not initialized to an empty list");
        assertEquals(0, list.size(), "The products list is not initialized to an empty list");
    }

    @Test
    void task_10_3_shouldHaveAnAddProductMethod() {

        // given - the class we want the students to implement
        ProductRepository products = Fixtures.createProductRepositoryExample();

        // and - the Product class
        Product product = Fixtures.createProduct();

        // then - it should have the addProduct() method
        assertTrue(products.hasMethod("addProduct", product.getTargetClass()), "Doesn't implement the addProduct() method");

        // and - they should return the correct type
        assertTrue(products.isMethodReturnType(void.class, "addProduct", product.getTargetClass()),
                "The addProduct() method is not returning a void");

        // and - Product should implement the equals method
        assertTrue(product.hasMethod("equals", Object.class), "Product doesn't override the equals method");

        // and - it should be public
        assertTrue(product.isMethodPublic("equals", Object.class), "The equals() method is not public");

        // and it should return a boolean
        assertTrue(product.isMethodReturnType(boolean.class,"equals", Object.class), "The equals() method is not well implemented, doesn't return a boolean");

        // and - it should return true if two products has the same name and brand
        GenericProduct product1 = Fixtures.createGenericProductExample();
        GenericProduct product2 = Fixtures.createGenericProductExample(product1.getName(), product1.getBrand(), "CAT5", 50.0f);
        assertTrue(product1.equals(product2), "The equals() method is not well implemented: " +  product1 + " and " + product2 + " should be considered the same product;");

        // and - it should return false otherwise
        GenericProduct product3 = Fixtures.createGenericProductExample(product1.getName(), "otherbrand", product1.getCategory(), product1.getPrice());
        assertFalse(product1.equals(product3), "The equals() method is not well implemented: product with different brand are not the same.");

        GenericProduct product4 = Fixtures.createGenericProductExample("othername", product1.getBrand(), product1.getCategory(), product1.getPrice());
        assertFalse(product1.equals(product4), "The equals() method is not well implemented: product with different name are not the same.");

        Product product5 = Fixtures.createProduct();
        products.addProduct(product5);
        products.addProduct(product5);
        assertEquals(1, products.getProducts().size(), "The addProduct() method is allowing duplicates.");
    }

    @Test
    void task_10_4_shouldHaveARemoveProductMethod() {

        // and - the Product class
        Product product = Fixtures.createProduct();

        // given - the class we want the students to implement
        ProductRepository products = Fixtures.createProductRepositoryExample();

        // then - it should have the removeProduct() method
        assertTrue(products.hasMethod("removeProduct", product.getTargetClass()), "Doesn't implement the removeProduct() method");

        // and - they should return the correct type
        assertTrue(products.isMethodReturnType(void.class, "removeProduct", product.getTargetClass()),
                "The removeProduct() method is not returning a void");

        // and - it should remove the correct item
        Product product1 = Fixtures.createProduct();
        Product product2 = Fixtures.createProduct(product1.getName(), "otherbrand", product1.getCategory(), product1.getPrice());

        products.addProduct(product1);
        products.addProduct(product2);
        products.removeProduct(product1);
        assertEquals(1, products.getProducts().size(), "The removeProduct() method is not working properly.");
    }

    @Test
    void task_10_5_shouldHaveAGetProductMethod() {

        // and - the Product class
        Product product = Fixtures.createProduct();

        // given - the class we want the students to implement
        ProductRepository products = Fixtures.createProductRepositoryExample();

        // then - it should have the getProduct() method
        assertTrue(products.hasMethod("getProduct", String.class, String.class), "Doesn't implement the getProduct() method. Check the signature and arguments.");

        // and - they should return the correct type
        assertTrue(products.isMethodReturnType(product.getTargetClass(), "getProduct", String.class, String.class),
                "The getProduct() method is not returning an Product");

        // and - it should fetch the correct item
        Product product1 = Fixtures.createProduct();
        products.addProduct(product1);
        Product product2 = Fixtures.createProduct(product1.getName(), "otherbrand", product1.getCategory(), product1.getPrice());
        products.addProduct(product2);

        assertEquals(product2, products.getProduct(product1.getName(), "otherbrand"),
                "The getProduct() method is not returning the correct item");

    }

    @Test
    void task_10_6_shouldHaveAGetProductsByCategoryMethod() {

        // and - the Product class
        Product product = Fixtures.createProduct();

        // given - the class we want the students to implement
        ProductRepository products = Fixtures.createProductRepositoryExample();

        // then - it should have the getProduct() method
        assertTrue(products.hasMethod("getProductsByCategory", String.class), "Doesn't implement the getProductsByCategory() method. Check the signature and arguments.");

        // and - they should return the correct type
        assertTrue(products.isMethodReturnType(List.class, product.getTargetClass(), "getProductsByCategory", String.class),
                "The getProductsByCategory() method is not returning an Product");

        // and - it should fetch the correct items
        Product product1 = Fixtures.createProduct();
        Product product2 = Fixtures.createProduct();
        Product product3 = Fixtures.createProduct();
        product3.setCategory(product1.getCategory());
        products.addProduct(product1);
        products.addProduct(product2);
        products.addProduct(product3);

        assertNotNull(products.getProductsByCategory(product1.getCategory()), "Method getProductsByCategory should not return null");
        assertEquals(2, products.getProductsByCategory(product1.getCategory()).size(),
                "The getProductsByCategory() method is not returning the correct number of items");

    }
}