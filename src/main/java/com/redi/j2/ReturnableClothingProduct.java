package com.redi.j2;

public class ReturnableClothingProduct extends ClothingProduct implements Returnable{

    private final int RETURN_DAYS = 30;

    public ReturnableClothingProduct(String name, String brand, String category, float price) {
        super(name, brand, category, price);
    }

    @Override
    public int getReturnDays() {
        return RETURN_DAYS;
    }

    @Override
    public String toString() {
        return "ReturnableClothingProduct{" +
                "The item is returnable within " + RETURN_DAYS + "days" +
                "} " + super.toString();
    }
}
