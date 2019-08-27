package com.tws.refactoring.extract_variable;

public class PriceCalculator {
    public static final int BASE = 500;
    public static final double DISCOUNT_5 = 0.05;
    public static final double DISCOUNT_1 = 0.1;
    public static final double MIN = 100.0;


   public double getPrice(int quantity, int itemPrice) {
        // Price consists of: base price - discount + shipping cost
        double baseprice = quantity * itemPrice;
        double discount =  Math.max(0, quantity - BASE) * itemPrice * DISCOUNT_5;
        double shippingcost = Math.min(quantity * itemPrice * DISCOUNT_1, MIN);
        return baseprice - discount + shippingcost;

    }
}
