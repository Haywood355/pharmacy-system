/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chai
 */
public class Cart implements CartAction {
    static List<CartItem> cartItems = new ArrayList();
    
    @Override
    public List<CartItem> getCart() {
        return cartItems;
    } 
    
    @Override
    public void addCart(String ID, String name, double price, int quantity) {
        boolean exist = false;
        
        // Update the quantity instead of appending the item that is in cart already
        for (CartItem data : cartItems) {
            if (data.getID().equals(ID)) {
                data.setQuantity(quantity);
                
                exist = true;
                break;
            }
        }
        
        if (!exist) cartItems.add(new CartItem(ID, name, price, quantity));
    }
    
    @Override
    public void removeCart(String ID) {
        int i = 0;
        for (CartItem data : cartItems) {
            if (data.getID().equals(ID)) {
                cartItems.remove(i);
                
                break;
            }
            i++;
        }        
    }
    
    @Override
    public double getCartTotalAmount() {    
        double totalAmount = 0;
        for (CartItem data : cartItems) {
            totalAmount = totalAmount + data.getAmount();
        }
      
        totalAmount = Math.round(totalAmount * 100.0) / 100.0;
        return totalAmount;
    }
    
    @Override
    public void clearCart() {
        cartItems.clear();
    }
    
    @Override
    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }
}
