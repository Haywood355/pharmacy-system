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
public class Role {
    
    private static String[] roles = {
        "Administrator", // 0
        "Pharmacist",    // 1
        "Customer"       // 2
    };
    
    static String toString(int code) {
        if (roles.length > code && roles[code] != null) {
            return roles[code];
        }
        return "Invalid role";
    }
    
    static int toInt(String name) {
        for (int i = 0; i < roles.length; i++){
            if (roles[i].equals(name)){
                return i;
            }
        }
        return -1;
    }
    
}
