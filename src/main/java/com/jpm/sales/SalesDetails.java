package com.jpm.sales;


public class SalesDetails {

    public LogSalesDetails logSalesDetails;

    private PriceAdjust priceAdjust;

    private Product product;


    public SalesDetails() {
        logSalesDetails = new LogSalesDetails();
    }

    public boolean processRequest(String saleNotice) {

        MessageParser messageParser= new MessageParser(saleNotice);

        String productType = messageParser.getProductType();

        if (productType.isEmpty()) {
            return false;
        }

        this.product = logSalesDetails.getProduct(productType);

        this.priceAdjust = new PriceAdjust(product);

        this.product.setQuantity(messageParser.getProductQuantity());
        this.product.setTotalQuantity(messageParser.getProductQuantity());
        this.product.setPrice(messageParser.getProductPrice());
        this.product.setAdjOperator(messageParser.getOperatorType());

        setProductTotalPrice();

        logSalesDetails.setNormalReports(saleNotice);

        logSalesDetails.updateProduct(product);

        return true;
    }

    private void setProductTotalPrice() {
        double adjustedPrice;
        double productValue;

        if (!product.getAdjOperator().isEmpty()) {
            adjustedPrice = priceAdjust.getAdjustedPrice();
            logSalesDetails.setAdjustmentReports(priceAdjust.adjustmentReport());
            product.setTotalPrice(adjustedPrice);
        } else {
            productValue = product.calculatePrice(product.getQuantity(), product.getPrice());
            product.appendTotalPrice(productValue);
        }
    }

}