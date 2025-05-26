/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_part2;

/**
 *
 * @author RC_Student_lab
 */
import javax.swing.*;
import java.util.*;

public class POE_Part2 {
    public static void main(String[] args) {
        Login objLogin = new Login();
        Check objCheck = new Check();

        // --- Registration ---
        String firstname = JOptionPane.showInputDialog(null, "Enter your First Name:");
        String lastname = JOptionPane.showInputDialog(null, "Enter your Last Name:");
        String username = JOptionPane.showInputDialog(null, "Enter your Username:");

        if (objLogin.checkuserName(username)) {
            JOptionPane.showMessageDialog(null, "Username successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Username incorrectly formatted. Must contain an underscore and be no more than 5 characters.");
        }

        String password = JOptionPane.showInputDialog(null, "Enter your Password:");
        if (objLogin.checkpasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "Password successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Password incorrectly formatted. Must be at least 8 characters, include a capital letter, number, and special character.");
        }

        String number = JOptionPane.showInputDialog(null, "Enter your Cellphone Number:");
        if (objLogin.checknumber(number)) {
            JOptionPane.showMessageDialog(null, "Cellphone number successfully added.");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid cellphone number. Must include international code.");
        }

        if (!objLogin.checkRegister(username, password, number)) {
            JOptionPane.showMessageDialog(null, "Unsuccessful Registration. Exiting...");
            return;
        }

        JOptionPane.showMessageDialog(null, "Successfully Registered!");

        // --- Login ---
        String verifyUsername = JOptionPane.showInputDialog(null, "Enter your Username to Login:");
        String verifyPassword = JOptionPane.showInputDialog(null, "Enter your Password:");

        if (!objLogin.verifyLogin(verifyUsername, username, verifyPassword, password)) {
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password. Exiting...");
            return;
        }

        JOptionPane.showMessageDialog(null, "Welcome " + firstname + " " + lastname + "! Login successful.");

        // Continue to messaging menu...
        runMessagingMenu(firstname, objCheck);
    }

    // Messaging logic continues in separate method to keep main() clean
    public static void runMessagingMenu(String firstname, Check objCheck) {
        Random rand = new Random();
        Map<Long, String> messageMap = new HashMap<>();
        Map<Long, Integer> messageNumberMap = new HashMap<>();
        int totalMessagesSent = 0;

        while (true) {
            String[] options = {"Send a message", "Show sent messages", "Quit"};
            int option = JOptionPane.showOptionDialog(null, "Choose an option", "QuickChat Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0: // Send message
                    String recipientNumber = JOptionPane.showInputDialog(null, "Enter recipient number (e.g. +27123456789):");
                    if (!objCheck.checkrecipientnumber(recipientNumber)) {
                        JOptionPane.showMessageDialog(null, "Invalid recipient number.");
                        break;
                    }

                    String numMsgStr = JOptionPane.showInputDialog(null, "How many messages would you like to send?");
                    int numMessages = Integer.parseInt(numMsgStr);

                    for (int i = 0; i < numMessages; i++) {
                        String message = JOptionPane.showInputDialog(null, "Enter message #" + (i + 1) + ":");
                        if (message == null || message.equalsIgnoreCase("exit")) {
                            JOptionPane.showMessageDialog(null, "Exiting...");
                            return;
                        }

                        String[] sendOptions = {"Send", "Disregard", "Store & Send Later"};
                        int sendOption = JOptionPane.showOptionDialog(null, "Choose an option for the message",
                                "Message Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, sendOptions, sendOptions[0]);

                        if (sendOption == 0) {
                            if (!objCheck.checkMessagelength(message)) {
                                JOptionPane.showMessageDialog(null, "Message too long. Max 250 characters.");
                                continue;
                            }

                            totalMessagesSent++;
                            long messageId;
                            do {
                                messageId = 1_000_000_000L + (long) (rand.nextDouble() * 9_999_999_999L);
                            } while (messageMap.containsKey(messageId));

                            String numberedMessage = "Message " + totalMessagesSent + ": " + message;
                            messageMap.put(messageId, numberedMessage);
                            messageNumberMap.put(messageId, totalMessagesSent);

                            JOptionPane.showMessageDialog(null, "Message sent and stored with ID: " + messageId);

                        } else if (sendOption == 1) {
                            JOptionPane.showMessageDialog(null, "Message disregarded.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Feature coming soon!");
                        }
                    }
                    break;

                case 1: // Show messages
                    if (messageMap.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No messages sent yet.");
                    } else {
                        StringBuilder allMessages = new StringBuilder();
                        for (Map.Entry<Long, String> entry : messageMap.entrySet()) {
                            Long id = entry.getKey();
                            String msg = entry.getValue();
                            int msgNum = messageNumberMap.getOrDefault(id, 0);
                            String[] parts = msg.split(":", 2);
                            String originalMsg = parts.length > 1 ? parts[1].trim() : msg;
                            String hash = createMessageHash(id, msgNum, originalMsg);
                            allMessages.append("ID: ").append(id).append(" | ").append(msg).append(" | HASH: ").append(hash).append("\n");
                        }

                        JTextArea textArea = new JTextArea(allMessages.toString());
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        textArea.setLineWrap(true);
                        textArea.setWrapStyleWord(true);
                        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));
                        JOptionPane.showMessageDialog(null, scrollPane, "Sent Messages", JOptionPane.INFORMATION_MESSAGE);

                        int delete = JOptionPane.showConfirmDialog(null, "Would you like to delete a message?", "Delete Message", JOptionPane.YES_NO_OPTION);
                        if (delete == JOptionPane.YES_OPTION) {
                            String idStr = JOptionPane.showInputDialog(null, "Enter Message ID to delete:");
                            try {
                                Long id = Long.parseLong(idStr);
                                if (messageMap.containsKey(id)) {
                                    messageMap.remove(id);
                                    messageNumberMap.remove(id);
                                    JOptionPane.showMessageDialog(null, "Message deleted.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Message ID not found.");
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid ID format.");
                            }
                        }
                    }
                    break;

                case 2: // Quit
                default:
                    JOptionPane.showMessageDialog(null, "Exiting QuickChat. Goodbye!");
                    return;
            }
        }
    }

    public static String createMessageHash(Long messageId, int messageNumber, String message) {
        String firstTwoDigits = messageId.toString().substring(0, 2);
        String[] words = message.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;

        return (firstTwoDigits + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }
}