/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chai
 */
public final class Validation {

    public static boolean isTrimEmpty(String text) {        
        return (text.trim().length() <= 0);
    }
    
    public static boolean isDateFormatted(String date) {
        String pattern = "^([1-9]|[0-2][0-9]|[3][0-1])\\/([1-9]|0[1-9]|1[0-2])\\/\\d{4}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(date);
        
        if (m.matches()) {
            return true;
        }
        
        return false;
    }
    
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;          
        } catch (NumberFormatException e) {
            return false;
        } finally {
            System.out.println("isDouble: String checked.");
        }
    }
    
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isUsername(String username) {
        String pattern = "^[a-zA-Z0-9]*$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(username);
        
        if (m.matches()) {
            return true;
        }
        
        return false;
    }
    
    public static boolean isEmail(String email) {
        String pattern = "[a-z0-9!#$%&'*+\\/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+\\/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(email);
        
        if (m.matches()) {
            return true;
        }
        
        return false;    
    }
    
}
