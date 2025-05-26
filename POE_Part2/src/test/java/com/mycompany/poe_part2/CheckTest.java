/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_part2;

import java.util.Map;
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
public class CheckTest {
    
    public CheckTest() {
    }
    
    
    /**
     * Test of checkMessagelength method, of class Check.
     */
    @Test
    public void testCheckMessagelength() {
        System.out.println("checkMessagelength");
        String message = "Hi daniel how are you";
        Check instance = new Check();
        boolean expResult = true;
        boolean result = instance.checkMessagelength(message);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isMessageIdAvailable method, of class Check.
     */
    @Test
    public void testIsMessageIdAvailable() {
        System.out.println("isMessageIdAvailable");
        Long messageId = null;
        Map<Long, String> messageMap = null;
        Check instance = new Check();
        boolean expResult = true;
        boolean result = instance.isMessageIdAvailable(messageId, messageMap);
        assertEquals(expResult, result);
      
    }

    /**
     * 
     */
    @Test
    public void testCheckrecipientnumber() {
        System.out.println("checkrecipientnumber");
        String recipientNumber = "0638065054";
        Check instance = new Check();
        boolean expResult = false;
        boolean result = instance.checkrecipientnumber(recipientNumber);
        assertEquals(expResult, result);
        
    }
    
}
