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
public abstract class User extends Cart {
    private static String username;
    private static String name;
    private static int role;
    private static String email;
    
    User(String username, int role, String name, String email) {
        User.username = username;
        User.role = role;
        User.name = name;
        User.email = email;
    }
    
    User() {
        
    }
     
    String getUsername() {
        return User.username;
    }
    
    String getName() {
        return User.name;
    }
    
    String getEmail() {
        return User.email;
    }
    
    int getRole() {
        return User.role;
    }
    
    String getRoleName() {
        return Role.toString(User.role);
    }
    
    boolean updateName(String name) {
        User.name = name;
        
        for (Account data : accountDataStorage.data) {
            if (data.getUsername().equals(User.username)) {
                data.setName(name);
                accountDataStorage.save();   
                
                return true;
            }
        }
        
        return false;
    }
    
    boolean updateEmail(String email) {
        User.email = email;
        
        for (Account data : accountDataStorage.data) {
            if (data.getUsername().equals(User.username)) {
                data.setEmail(email);
                accountDataStorage.save();
                
                return true;
            }
        }
        return false;
    }

    boolean updatePassword(String password) {
        for (Account data : accountDataStorage.data) {
            if (data.getUsername().equals(User.username)) {
                data.setPassword(password);
                accountDataStorage.save();
                
                return true;
            }
        }
        return false;
    }
    
    List<Medicine> getInventory() {
        // Users by default can only view minimal details in the inventory table for simplicity sake and good U/X
        List<Medicine> inventory = new ArrayList();
     
        for (Medicine data : inventoryDataStorage.data) {
            Medicine med = new Medicine(data.getID(), null, data.getName(), data.getUnit(), data.getCompany(), null, null, data.getPrice(), data.getQuantity());
            inventory.add(med);
        }
        return inventory;
    }  
    
    void clearSession() {
        User.username = null;
        User.role = -1;
        User.name = null;
    }
    
    abstract Medicine getMedicine(String medicineID);
    abstract String logout();  
}
