/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_part2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    

    /**
     * Test of checkuserName method, of class Login.
     */
    @Test
    public void testCheckuserName() {
        System.out.println("checkuserName");
        String username = "Tlangelani";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkuserName(username);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of checkpasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckpasswordComplexity() {
        System.out.println("checkpasswordComplexity");
        String password = "baxhihu";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkpasswordComplexity(password);
        assertEquals(expResult, result);
        
    }

    /**
     * 
     */
    @Test
    public void testChecknumber() {
        System.out.println("checknumber");
        String number = "0685264107";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checknumber(number);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of checkRegister method, of class Login.
     */
    @Test
    public void testCheckRegister() {
        System.out.println("checkRegister");
        String username = "dgfh";
        String password = "dbfjhyhyk";
        String number = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkRegister(username, password, number);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of verifyUsername method, of class Login.
     */
    @Test
    public void testVerifyUsername() {
        System.out.println("verifyUsername");
        String verifyUsername = "sfht";
        String username = "egrtjul";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.verifyUsername(verifyUsername, username);
        assertEquals(expResult, result);
       
    }

    /**
     * 
     */
    @Test
    public void testVerifypassword() {
        System.out.println("verifypassword");
        String verifypassword = "htjyk";
        String password = "tykuli"
             ;
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.verifypassword(verifypassword, password);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of verifyLogin method, of class Login.
     */
    @Test
    public void testVerifyLogin() {
        System.out.println("verifyLogin");
        String verifyUsername = "fhyyujnhiu";
        String username = "htjykuli";
        String verifypassword = "tyii88o";
        String password = "errytu7i";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.verifyLogin(verifyUsername, username, verifypassword, password);
        assertEquals(expResult, result);
        
    }

    /**
     * 
     */
    @Test
    public void testVerifynumber() {
        System.out.println("verifynumber");
        String verifynumber = "sfgtjy";
        String number = "rytyi8uo";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.verifynumber(verifynumber, number);
        assertEquals(expResult, result);
        
    }
    
}
