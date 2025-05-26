/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part2;

/**
 *
 * @author RC_Student_lab
 */
import java.util.*;
class Check {
    public boolean checkMessagelength(String message){
        if(message. length()< 250){
        return true;
    }else{
            return false;
        }
    }
    public boolean isMessageIdAvailable(Long messageId, Map<Long, String> messageMap) {
    return !messageMap.containsKey(messageId) &&
           messageId >= 1_000_000_000L && messageId <= 9_999_999_999L;

    }
    public boolean checkrecipientnumber(String recipientNumber){
        
        // Decission making using IF statements to check necessary requirements
       if(recipientNumber.matches("^\\+27\\d{9}$") ) {
           return true;
       }else{
           return false;
           
       }
    }
}

