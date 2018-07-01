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
public interface CartAction {
    
    public List<CartItem> getCart();
    
    public void addCart(String ID, String name, double price, int quantity);
    
    public void removeCart(String ID);
 
    public void clearCart();
                
    public double getCartTotalAmount();
    
    public boolean isCartEmpty();

}
