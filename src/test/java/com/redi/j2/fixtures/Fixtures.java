package com.redi.j2.fixtures;

import com.redi.j2.proxies.*;
import org.mockito.Mockito;

import java.util.Random;

import static org.mockito.Mockito.CALLS_REAL_METHODS;

public class Fixtures {

    private static int count = 0;
    private static Random random = new Random();

    public static Product createProduct() {
        count++;
        return createProduct("CoolItem"+count, "Brand"+count, "CAT"+count, random.nextFloat() * 99.5f + 0.5f);
    }

    public static Product createProduct(String name, String brand, String category, float price) {
        Class<?> clazz = new Product(name, brand, category, price).getTargetClass();
        if(clazz == null) return new Product(name, brand, category, price);
        Object mockTarget = Mockito.mock(
                clazz,
                Mockito.withSettings().useConstructor(name, brand, category, price)
                        .defaultAnswer(CALLS_REAL_METHODS)
        );
        return new Product(mockTarget);
    }

    public static ClothingProduct createClothingProductExample() {
        count++;
        return createClothingProductExample("CoolItem"+count, "Brand"+count, "CAT"+count, random.nextFloat() * 99.5f + 0.5f);
    }

    public static ClothingProduct createClothingProductExample(String name, String brand, String category, float price) {
        return new ClothingProduct(name, brand, category, price);
    }

    public static GenericProduct createGenericProductExample() {
        count++;
        return createGenericProductExample("CoolItem"+count, "Brand"+count, "CAT"+count, random.nextFloat() * 99.5f + 0.5f);
    }

    public static GenericProduct createGenericProductExample(String name, String brand, String category, float price) {
        return new GenericProduct(name, brand, category, price);
    }

    public static Returnable createReturnableExample() {
        return new Returnable();
    }

    public static ReturnableClothingProduct createReturnableClothingProductExample() {
        count++;
        return createReturnableClothingProductExample("CoolItem" + count, "Brand" + count, "CAT" + count, random.nextFloat() * 99.5f + 0.5f);
    }

    public static ReturnableClothingProduct createReturnableClothingProductExample(String name, String brand, String category, float price) {
        return new ReturnableClothingProduct(name, brand, category, price);
    }

    public static ReturnableGenericProduct createReturnableGenericProductExample() {
        count++;
        return createReturnableGenericProductExample(90);
    }

    public static ReturnableGenericProduct createReturnableGenericProductExample(int returnDays) {
        count++;
        return createReturnableGenericProductExample("CoolItem" + count, "Brand" + count, "CAT" + count, random.nextFloat() * 99.5f + 0.5f, returnDays);
    }

    public static ReturnableGenericProduct createReturnableGenericProductExample(String name, String brand, String category, float price, int returnDays) {
        return new ReturnableGenericProduct(name, brand, category, price, returnDays);
    }

    public static ProductRepository createProductRepositoryExample() {
        return new ProductRepository();
    }
}
