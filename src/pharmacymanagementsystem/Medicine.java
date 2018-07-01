/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.util.List;

/**
 *
 * @author chai
 */
public class Medicine {
    private String ID;
    private String batchID;
    private String name;
    private String unit;    
    private String company;
    private String DOE;    
    private String DOM;
    private double price;
    private int quantity;
    
    Medicine(String ID, String batchID, String name, String unit, String company, String DOM, String DOE, double price, int quantity) {
        this.ID = ID;
        this.batchID = batchID;
        this.name = name;
        this.unit = unit;
        this.company = company;
        this.DOM = DOM;
        this.DOE = DOE;
        this.price = price;
        this.quantity = quantity;
    } 
    
    Medicine() {
        
    }
    
    String getID() {
        return this.ID;
    }
        
    String getBatchID() {
        return this.batchID;
    }
    
    String getName() {
        return this.name;
    }
    
    String getUnit() {
        return this.unit;
    }

    String getCompany() {
        return this.company;
    }
    
    String getDOM() {
        return this.DOM;
    }
    
    String getDOE() {
        return this.DOE;
    }
    
    double getPrice() {
        return this.price;
    }
    
    int getQuantity() {
        return this.quantity;
    }
    
    void setBatchID(String batchID) {
        this.batchID = batchID;
    }
    
    void setName(String name) {
        this.name = name;
    }
    
    void setUnit(String unit) {
        this.unit = unit;
    }

    void setCompany(String company) {
        this.company = company;
    }
    
    void setDOM(String DOM) {
        this.DOM = DOM;
    }
    
    void setDOE(String DOE) {
        this.DOE = DOE;
    }
    
    void setPrice(double price) {
        this.price = price;
    }
    
    void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
