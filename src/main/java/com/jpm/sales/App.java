package com.jpm.sales;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class App{

    public static void main(String[] args) {
        SalesDetails salesDetails = new SalesDetails();

        // Read inputs from resources folder
        try {
            String line;
            InputStream is = App.class.getResourceAsStream("/input.txt");
            BufferedReader inputFile = new BufferedReader(new InputStreamReader(is));
            
            while((line = inputFile.readLine()) != null) {
                salesDetails.processRequest(line);

                salesDetails.logSalesDetails.report();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}