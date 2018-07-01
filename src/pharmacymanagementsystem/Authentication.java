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
public class Authentication {
    private String username;
    private String password;
    private int role;
    private String name;
    private String email;

    
    Authentication(String username, String password) {
        this.username = username.toLowerCase();
        this.password = password;
    }
    
    boolean login() {
        for (Account data : accountDataStorage.data) {
            if (data.getUsername().equals(this.username) && data.getPassword().equals(this.password)) {
                this.role = data.getRole();
                this.name = data.getName();
                this.email = data.getEmail();
                
                return true;
            }
        }
        return false;
    }
    
    String getUsername() {
        return this.username;
    }
    
    int getRole() {
        return this.role;
    }
    
    String getName() {
        return this.name;
    }
    
    String getEmail() {
        return this.email;
    }
    
}
