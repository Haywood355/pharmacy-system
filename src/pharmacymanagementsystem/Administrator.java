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
public class Administrator extends User {
 
    Administrator(String username, int role, String name, String email) {
        super(username, role, name, email);
    }

    Administrator() {

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
        
        return "You have been signed out successfully.";
    }
    
    boolean createAccount(Account user) {
        if (isUsernameExist(user.getName())) return false;

        accountDataStorage.data.add(user);
        accountDataStorage.save();
        
        return true;
    }
    
    boolean isUsernameExist(String username) {
        for (Account data : accountDataStorage.data) {
            if (data.getUsername().equals(username.toLowerCase())) {
                return true;
            }
        }
        return false;        
    }
    
    Account getAccount(String username) {
        for (Account data : accountDataStorage.data) {
            if (data.getUsername().equals(username.toLowerCase())) {
                return new Account(data.getUsername(), null, data.getRole(), data.getName(), data.getEmail());
            }
        }
        return new Account();
    }
    
    void updateRole(String username, int role) {
         for (Account data : accountDataStorage.data) {
            if (data.getUsername().equals(username.toLowerCase())) {
                data.setRole(role);
                accountDataStorage.save();
                break;
            }
        } 
    }
    
    void updateName(String username, String name) {
         for (Account data : accountDataStorage.data) {
            if (data.getUsername().equals(username.toLowerCase())) {
                data.setName(name);
                accountDataStorage.save();
                break;
            }
        } 
    }
    
    void updateEmail(String username, String email) {
        for (Account data : accountDataStorage.data) {
            if (data.getUsername().equals(username.toLowerCase())) {
                data.setEmail(email);
                accountDataStorage.save();
                break;
            }
        } 
    }
    
    boolean deleteAccount(String username) {
        int i = 0;
        
        for (Account data : accountDataStorage.data) {
            if (data.getUsername().equals(username.toLowerCase())) {
                accountDataStorage.data.remove(i);
                accountDataStorage.save();
                return true;
            }
            i++;
        } 
        
        return false;
    }
}
