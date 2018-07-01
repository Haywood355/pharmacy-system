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
public class Customer extends User {
    Customer(String username, int role, String name, String email) {
        super(username, role, name, email);
    }

    Customer() {

    }
    
    // Show medicines that are stock ready
    List<Medicine> getInventory(boolean inStock) {
        if (!inStock) return super.getInventory();
        
        List<Medicine> inventory = new ArrayList();
     
        for (Medicine data : inventoryDataStorage.data) {
            if (data.getQuantity() < 1) continue; 
            Medicine med = new Medicine(data.getID(), null, data.getName(), data.getUnit(), data.getCompany(), null, null, data.getPrice(), data.getQuantity());
            inventory.add(med);
        }
        return inventory;     
    }
    
    boolean updateMedicineQuantity(String id, int quantity) {
        for (Medicine data : inventoryDataStorage.data) {
            if (data.getID().equals(id)) {
                data.setQuantity( data.getQuantity() - quantity );
                inventoryDataStorage.save();
                
                return true;
            }
        }
        return false;
    }
    
    boolean makePurchase() {
        try {
            for (CartItem data : cartItems) {
                updateMedicineQuantity(data.getID(), data.getQuantity());
            }
            clearCart();
            return true;
            
        } catch (Exception e) {
            return false;
        } finally {
            System.out.println("makePurchase: Has been ran.");
        }
    }
    
    @Override
    Medicine getMedicine(String medicineID) {
        for (Medicine data : inventoryDataStorage.data) {
            if (data.getID().equals(medicineID)) {
                return data;
            }
        }
        return new Medicine();
    }
    
    @Override
    String logout() {
        super.clearSession();
        
        return "We will miss you. See you again!";
    }
}
