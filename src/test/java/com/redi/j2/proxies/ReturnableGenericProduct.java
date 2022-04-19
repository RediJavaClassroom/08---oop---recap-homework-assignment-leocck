package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

import java.util.List;

public class ReturnableGenericProduct extends ReflectionProxy {
    Class[] emptyParam = { };
    Class[] StringParam = { String.class };
    Class[] floatParam = { float.class };

    public ReturnableGenericProduct(String name, String brand, String category, float price, int returnDays) {
        super(name, brand, category, price, returnDays);
    }

    public int getReturnDaysValue() {
        Integer result = super.getPropertyValue("returnDays");
        return (result != null)? result : 0;
    }

    public int getReturnDays() {
        Integer result = super.invokeMethod("getReturnDays", emptyParam);
        return (result != null)? result : 0;
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.ReturnableGenericProduct";
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
}
