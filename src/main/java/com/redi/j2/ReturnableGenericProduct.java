package com.redi.j2;

public class ReturnableGenericProduct extends GenericProduct implements Returnable {

    private int returnDays;

    public ReturnableGenericProduct(String name, String brand, String category, float price, int returnDays) {
        super(name, brand, category, price);
        this.returnDays = returnDays;
    }

    @Override
    public int getReturnDays() {
        return returnDays;
    }

    @Override
    public String toString() {
        return "ReturnableGenericProduct{" +
                "The item is returnable within " + returnDays + " days" +
                "} " + super.toString();
    }
}
