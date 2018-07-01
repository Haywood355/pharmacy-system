/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author chai
 */
public class Pharmacist extends User {

    Pharmacist(String username, int role, String name, String email) {
        super(username, role, name, email);
    }
    
    Pharmacist() {
        
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
       
        return "Have a break, have a KitKat!";
    }
    
    boolean addMedicine(Medicine data) {
        try {
            inventoryDataStorage.data.add(data);
            inventoryDataStorage.save();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    boolean isMedicineExist(String medicineID) {
        for (Medicine data : inventoryDataStorage.data) {
            if (data.getID().equals(medicineID)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    List<Medicine> getInventory() {
        return inventoryDataStorage.data;
    }
    
    List<Medicine> getInventory(String year) {
        List<Medicine> storage = new ArrayList();
        
        for (Medicine data : inventoryDataStorage.data) {
            String[] date = data.getDOE().split("/");       
            if (date[2].equals(year)) {         
                storage.add(data);
            }
        }
        return storage;        
    }
    
    List<Medicine> getInventory(String year, int month) {
        // If the month is not in range (January-December), display all inventory
        if (!(month >= 1 && month <= 12)) return getInventory(year);
        
        List<Medicine> storage = new ArrayList();
        String monthString = String.format("%02d", month);

        for (Medicine data : inventoryDataStorage.data) {
            String[] date = data.getDOE().split("/");       
            if (date[2].equals(year) && date[1].equals(monthString)) {         
                storage.add(data);
            }
        }
        return storage;        
    }
    
    List<String> getInventoryYears() {
        List<String> yearList = new ArrayList<String>();

        for (Medicine data : inventoryDataStorage.data) {
            String year = data.getDOE().split("/")[2];
            
            if (!yearList.contains(year)) {
                yearList.add(year);
            }
        }
        
        // Sort year in ascending order
        Collections.sort(yearList);
        
        return yearList;
    }
    
    List<Medicine> getInventoryExpiring() {
        List<Medicine> storage = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");     
        Date now = new Date();

        try {
            
            for (Medicine data : inventoryDataStorage.data) {
                long diffInMillies = sdf.parse(data.getDOE()).getTime() - now.getTime();
                long days = TimeUnit.MILLISECONDS.toDays(diffInMillies); 
                
                if (days > 0 && days <= 30) {
                    storage.add(data);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error in parsing or comparing inventory expiring dates.");
        } finally {
            System.out.println("getInventoryExpiring: Has been ran.");
        }
        
        return storage;    
    }
    
    boolean updateMedicine(Medicine medicine) {
        for (Medicine data : inventoryDataStorage.data) {
            if (data.getID().equals(medicine.getID())) {
                data.setName(medicine.getName());
                inventoryDataStorage.save();
                
                return true;
           }
        }
        return false;
    }
    
    boolean deleteMedicine(String medicineID) {
        int i = 0;
        for (Medicine data : inventoryDataStorage.data) {
            if (data.getID().equals(medicineID)) {
                inventoryDataStorage.data.remove(i);
                inventoryDataStorage.save();
                return true;
           }
           i++;
        }
        return false;
    }
}
