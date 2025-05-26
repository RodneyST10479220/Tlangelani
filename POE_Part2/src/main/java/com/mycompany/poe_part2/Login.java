/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part2;
import java.util.*;
/**
 *
 * @author RC_Student_lab
 */
class Login {
    //a boolean that checks username
    public boolean checkuserName(String username){
        
        // Decission making using IF statements to check necessary requirements
        if(username.contains("_")&& username.length() <= 5){
            return true;
            
        }else{
            return false;
        }
    }
    //a boolean checks password
    public boolean checkpasswordComplexity(String password){
        
        // Decission making using IF statements to check necessary requirements
        if(password.matches(".*[!@#$%^&*()_+-={}|:;',./<>?].*")&& password.length()>=8 && password.matches(".*[A-Z].*")&&password.matches(".*[0-9].*")){
            return true;
        }else{
            return false;
        }
       
    }
    //a boolean checks number
    public boolean checknumber(String number){
        
        // Decission making using IF statements to check necessary requirements
       if(number.matches("^\\+27\\d{9}$") ) {
           return true;
       }else{
           return false;
           
       }
    }
    //a boolean checks the register if they return true
    public boolean checkRegister(String username,String password,String number){
        
        // Decission making using IF statements to check necessary requirements
        if (checkuserName(username)&& checkpasswordComplexity(password)&& checknumber(number)){
            return true;
        }else{
            return false;
        }
    }
    //using boolean to veryfy the username
    public boolean verifyUsername(String verifyUsername, String username){
        
        // Decission making using IF statements to check necessary requirements
        if(verifyUsername.equals(username)){
            return true;
        }else{
            return false;
        }
    }
   
    //using boolean to verify the password
    public boolean verifypassword(String verifypassword, String password){
        
        // Decission making using IF statements to check necessary requirements
        if(verifypassword.equals(password)){
            return true;
    }else{
            return false;
        }
    }
    //using boolean to verify both username and password to display a welcome message to the user if it returns true
    public boolean verifyLogin (String verifyUsername, String username, String verifypassword, String password){
        
        // Decission making using IF statements to check necessary requirements
        if(verifyUsername.equals(username) && verifypassword.equals(password)){
            return true;
        }else{
            return false;
        }
    }
    //using boolean to verify the cellphone number
    public boolean verifynumber(String verifynumber, String number){
        
        // Decission making using IF statements to check necessary requirements
        if(verifynumber.equals(number)){
            return true;
        }else{
            return false;
        }
    }
       
    
}
