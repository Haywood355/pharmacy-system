/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author chai
 */
public class inventoryDataStorage {
    static List<Medicine> data = new ArrayList();
    static String filePath = "inventory.txt";
    
    static void load() {
        Gson gson = new Gson();
        
        try {
            FileReader file = new FileReader(filePath);        
            JsonReader reader = new JsonReader(file);

            Type collectionType = new TypeToken<Collection<Medicine>>(){}.getType();
            Collection<Medicine> enums = gson.fromJson(reader, collectionType); 
            data = (List<Medicine>) enums;
            
            System.out.println("Inventory loaded.");          
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    static void save() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            
            FileWriter file = new FileWriter(filePath);
            file.write(gson.toJson(data));
            file.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
}
