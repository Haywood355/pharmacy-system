/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

/**
 *
 * @author chai
 */
public class CartItem {
    private String ID;
    private String name;
    private double price;
    private int quantity;
    
    CartItem(String ID, String name, double price, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    String getID() {
        return this.ID;
    }
 
    String getName() {
        return this.name;
    }
    
    double getPrice() {
        return this.price;
    }
    
    int getQuantity() {
        return this.quantity;
    }
    
    double getAmount() {
        return this.price * this.quantity;
    }
    
    void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
