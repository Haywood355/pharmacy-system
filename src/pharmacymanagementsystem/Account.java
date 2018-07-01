/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import javax.swing.JOptionPane;

/**
 *
 * @author chai
 */
public class Account {
    private String username;
    private String password;
    private int role;   // 0 = Administrator
                        // 1 = Pharmacist
                        // 2 = Customer
    private String name;
    private String email;

    Account(String username, String password, int role, String name, String email) {
        this.username = username.toLowerCase();
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
    }

    Account() {
        
    }
    
    String getUsername() {
        return this.username;
    }
    
    String getPassword() {
        return this.password;
    }
    
    int getRole() {
        return this.role;
    }
    
    String getRoleName() {
        return Role.toString(role);
    }
    
    String getName() {
        return this.name;
    }
    
    String getEmail() {
        return this.email;
    }
    
    void setRole(int role) {
        this.role = role;
    }
    
    void setName(String name) {
        this.name = name;
    } 
     
    void setEmail(String email) {
        this.email = email;
    }
    
    void setPassword(String password) {
        this.password = password;
    }
}

