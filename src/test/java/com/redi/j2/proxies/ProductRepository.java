package com.redi.j2.proxies;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.utils.ReflectionProxy;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends ReflectionProxy {

    Class[] stringParam =  { String.class };
    Class[] twoStringsParam =  { String.class, String.class };

    public Class[] getProductParam() {
        String name = "CoolItem";
        String brand = "BrandOne";
        String category = "CAT1";
        float price = 10.0f;
        Product product = Fixtures.createProduct(name, brand, category, price);
        Class[] abstractProductParam =  { product.getTargetClass() };
        return abstractProductParam;
    }
    @Override
    public String getTargetClassName() {
        return "com.redi.j2.ProductRepository";
    }

    public List<?> getProducts() {
        return super.getPropertyValue("products");
    }

    public void addProduct(Product product) {
        super.invokeMethod("addProduct", getProductParam(), product.getTarget());
    }

    public void removeProduct(Product product) {
        super.invokeMethod("removeProduct", getProductParam(), product.getTarget());
    }

    public Product getProduct(String name, String brand) {
        Object result = super.invokeMethod("getProduct", twoStringsParam, name, brand);
        return (result != null)? new Product(result) : null;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> response = new ArrayList<>();
        List<?> result = super.invokeMethod("getProductsByCategory", stringParam, category);
        if (result == null) return null;
        for(Object p : result) {
            response.add(new Product(p));
        }
        return response;
    }

}
