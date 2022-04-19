package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

import java.util.List;

public class Product extends ReflectionProxy {

    Class[] StringParam = { String.class };
    Class[] floatParam = { float.class };
    Class[] emptyParam = { };

    public Product(Object target) {
        super(target);
    }

    public Product(String name, String brand, String category, float price) {
        super(name, brand, category, price);
    }

    public String getNamePropertyValue() {
        return super.getPropertyValue("name");
    }

    public String getBrandPropertyValue() {
        return super.getPropertyValue("brand");
    }

    public String getCategoryPropertyValue() {
        return super.getPropertyValue("category");
    }

    public float getPricePropertyValue() {
        Float result = super.getPropertyValue("price");
        return (result != null)? result : 0;
    }

    public List<String> getTagsPropertyValue() {
        return super.getPropertyValue("tags");
    }

    public String getName() {
        return super.invokeMethod("getName", emptyParam);
    }

    public void setName(String name) {
        super.invokeMethod("setName", StringParam, name);
    }

    public String getBrand() {
        return super.invokeMethod("getBrand", emptyParam);
    }

    public void setBrand(String brand) {
        super.invokeMethod("setBrand", StringParam, brand);
    }

    public String getCategory() {
        return super.invokeMethod("getCategory", emptyParam);
    }

    public void setCategory(String category) {
        super.invokeMethod("setCategory", StringParam, category);
    }

    public float getPrice() {
        return super.invokeMethod("getPrice", emptyParam);
    }

    public void setPrice(float price) {
        super.invokeMethod("setPrice", floatParam, price);
    }

    public void addTag(String tag) {
        super.invokeMethod("addTag", StringParam, tag);
    }

    public boolean hasTag(String tag) {
        return super.invokeMethod("hasTag", StringParam, tag);
    }

    public void removeTag(String tag) {
        super.invokeMethod("removeTag", StringParam, tag);
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Product";
    }

}
