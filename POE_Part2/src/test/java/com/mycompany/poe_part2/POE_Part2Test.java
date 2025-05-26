/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_part2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author RC_Student_lab
 */
public class POE_Part2Test {
    
    public POE_Part2Test() {
    }

   
   
   
    @Test
    public void testRunMessagingMenu() {
        System.out.println("runMessagingMenu");
        String firstname = "Tlangelani";
        Check objCheck = null;
        POE_Part2.runMessagingMenu(firstname, objCheck);
        
    }

    /**
     * Test of createMessageHash method, of class POE_Part2.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Long messageId = null;
        int messageNumber = 0;
        String message = "hello";
        String expResult = "";
        String result = POE_Part2.createMessageHash(messageId, messageNumber, message);
        
    }

    /**
     * Test of main method, of class POE_Part2.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        com.mycompany.poe_part2.POE_Part2.main(args);
        
    }
    
}
