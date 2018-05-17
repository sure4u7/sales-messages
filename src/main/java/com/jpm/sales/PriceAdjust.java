package com.jpm.sales;

import java.lang.reflect.Method;

public class PriceAdjust {

    private double adjustedPrice;

    private Product product;

    public PriceAdjust(Product product) {
        this.product = product;
        this.adjustedPrice = 0.0;
    }

 
    public double getAdjustedPrice() {
        String adjustmentMethod = String.format("%sPrice", product.getAdjOperator().toLowerCase());
        try {
            Method method = this.getClass().getMethod(adjustmentMethod,null);
            method.invoke(this,null);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return adjustedPrice;
    }

    public void addPrice() {
        this.adjustedPrice = this.product.getTotalPrice() + ( this.product.getTotalQuantity() * this.product.getPrice() );
    }

    public void subtractPrice() {
        this.adjustedPrice = this.product.getTotalPrice() - (this.product.getTotalQuantity() * this.product.getPrice());
    }

    public void multiplyPrice() {
        this.adjustedPrice = this.product.getTotalPrice() +
                (this.product.getTotalPrice() * this.product.getPrice()) +
                (this.product.getTotalQuantity() * this.product.getPrice());
    }

    public String adjustmentReport(){
        String adjustmentReport = String.format(
                "  %-10s  %.2fp      %-4d  %-15s    %.2fp          %.2fp  ",
                this.product.getAdjOperator(),
                this.product.getPrice(),
                this.product.getTotalQuantity(),
                this.product.getType(),
                this.product.getTotalPrice(),
                this.adjustedPrice
        );
        return adjustmentReport;
    }

}
