package com.jpm.sales;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;


public class LogSalesDetails {

    private HashMap<String, Product> lineItems = new HashMap<>();

    private double totalSalesValue;
    DecimalFormat dec = new DecimalFormat("#0.00");

    private ArrayList<String> normalReports;

    private ArrayList<String> adjustmentReports;

    public LogSalesDetails() {
        this.normalReports = new ArrayList<>();
        this.adjustmentReports = new ArrayList<>();
        this.totalSalesValue = 0.0;
    }

    public Product getProduct(String type) {
        return lineItems.getOrDefault(type,new Product(type));
    }

    public void updateProduct(Product product){lineItems.put(product.getType(), product);}

    public ArrayList<String> getNormalReports() {
        return normalReports;
    }

    public void setNormalReports(String normalReport) {
        this.normalReports.add(normalReport);
    }

    public ArrayList<String> getAdjustmentReports() {return adjustmentReports;}

    public void setAdjustmentReports(String adjustmentReport) {this.adjustmentReports.add(adjustmentReport);}

    // return the total sales value
    public double getTotalSalesValue() {
        return totalSalesValue;
    }

    public void appendTotalSalesValue(double productTotalPrice) { totalSalesValue += productTotalPrice;}

    public void setTotalSalesValue(double productTotalPrice) { totalSalesValue = productTotalPrice;}

    public void report() {

        if((normalReports.size() % 10) == 0 && normalReports.size() !=0) {
            setTotalSalesValue(0.0);
            System.out.println("		10 Messages received ");
            System.out.println("		--------------------- \n");
            System.out.println("Product     Quantity   Value      ");
            System.out.println("-------------------------------------------");
            lineItems.forEach((k,v) -> formatReports(k,v));
            System.out.println("-------------------------------------------");
            System.out.println("Total Sales                  "+dec.format(getTotalSalesValue()));
            System.out.println("-------------------------------------------\n\n");
          
        }

        if((normalReports.size() % 50) == 0 && normalReports.size() !=0) {
        	System.out.println("\n------------------------------------------");
            System.out.println("After 50 messages we cannot process further. ");
            System.out.println("-------------------------------------------\n");
            
            System.out.println("Adjestment Report: ");
            System.out.println("-----------------\n");
            System.out.println("Pperator Type     Price      Qty    Product           Old Price     New Price ");
            System.out.println("--------------------------------------------------------------------------");
            getAdjustmentReports().forEach(System.out::println);
            System.out.println("--------------------------------------------------------------------------");
            System.exit(1);
        }
    }

    public void formatReports(String type, Product product) {
        appendTotalSalesValue(product.getTotalPrice());
        String logDetails = String.format("%-15s%-10d%-11.2f", product.getType(), product.getTotalQuantity(), product.getTotalPrice());
        System.out.println(logDetails);
    }


}
