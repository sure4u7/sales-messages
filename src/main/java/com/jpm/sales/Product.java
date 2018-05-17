package com.jpm.sales;

public class Product {

    private double price;

    private int quantity;

    private String adjOperator;

    private String type;

    private int totalQuantity;

    private double totalPrice;

    public Product(String type) {
        this.totalPrice = 0.0;
        this.totalQuantity = 0;
        this.type = type;
        this.adjOperator = null;
    }

    public double calculatePrice(int productQuantity, double productPrice){
        return productQuantity * productPrice;
    }

    public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAdjOperator() {
		return adjOperator;
	}

	public void setAdjOperator(String adjOperator) {
		this.adjOperator = adjOperator;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void appendTotalPrice(double productPrice) {
        this.totalPrice += productPrice;
    }

   

    /*public double getProductPrice() { return price; }

    public void setProductPrice(double productPrice) { this.price = productPrice; }

    public int getProductQuantity() { return quantity; }

    public void setProductQuantity(int productQuantity) { this.quantity = productQuantity; }

    public String getAdjustmentOperator() { return adjOperator; }

    public void setAdjustmentOperator(String adjustmentOperator) { this.adjOperator = adjustmentOperator; }*/

}
