/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermessagehandler;

/**
 *
 * @author Ngozi Francis Uranta
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ServerMessageHandler {
    
    
   refactoredclient.RefactoredClient  myClient;
    String serverMessage = "";
    
    public ServerMessageHandler(refactoredclient.RefactoredClient myClient) {
        this.myClient = myClient;
    }

    public void handleCompleteServerMessage(String theCommand) {
        
        if (theCommand.contains("Hello: ")) {
            myClient.sendMessageToUI("Server has acknowledged the connection request");
            myClient.sendMessageToUI("\t " + theCommand);
        } 
        else if (theCommand.contains("Disconnect Ack: ")) {
            myClient.sendMessageToUI("Server has acknowledged the disconnect request");
            myClient.sendMessageToUI("\t " + theCommand);
            myClient.stopThread();
            myClient.disconnectFromServer();
        } 
        else if (theCommand.contains("Quit Ack: ")) {
            myClient.sendMessageToUI("Server has acknowledged the quit request");
            myClient.sendMessageToUI("\t " + theCommand);
            myClient.stopThread();
            myClient.disconnectFromServer();
            System.exit(-1);
        } 
        else if (theCommand.contains("The time is: ")) {
            myClient.sendMessageToUI("Server has acknowledged the get time request");
            myClient.sendMessageToUI("\t " + theCommand);
        }    
        else if (theCommand.contains("L1on")) {
            myClient.sendMessageToUI("Server has acknowledged the switch L1on request");
            myClient.sendMessageToUI("\t " + theCommand);
        } 
        else if (theCommand.contains("L2on")) {
            myClient.sendMessageToUI("Server has acknowledged the switch L2on request");
            myClient.sendMessageToUI("\t " + theCommand);
        } 
        else if (theCommand.contains("L3on")) {
            myClient.sendMessageToUI("Server has acknowledged the switch L3on request");
            myClient.sendMessageToUI("\t " + theCommand);
        } 
        else if (theCommand.contains("L4on")) {
            myClient.sendMessageToUI("Server has acknowledged the switch L4on request");
            myClient.sendMessageToUI("\t " + theCommand);
        } 
        else if (theCommand.contains("L1off")) {
            myClient.sendMessageToUI("Server has acknowledged the switch L1off request");
            myClient.sendMessageToUI("\t " + theCommand);
        } 
        else if (theCommand.contains("L2off")) {
            myClient.sendMessageToUI("Server has acknowledged the switch L2off request");
            myClient.sendMessageToUI("\t " + theCommand);
        } 
        else if (theCommand.contains("L3off")) {
            myClient.sendMessageToUI("Server has acknowledged the switch L3off request");
            myClient.sendMessageToUI("\t " + theCommand);
        } 
        else if (theCommand.contains("L4off")) {
            myClient.sendMessageToUI("Server has acknowledged the switch L4off request");
            myClient.sendMessageToUI("\t " + theCommand);
        } 
        else if (theCommand.contains("PB1D")) {
            myClient.sendMessageToUI("Push Button 1 is down");
        } 
        else if (theCommand.contains("PB1U")) {
            myClient.sendMessageToUI("Push Button 1 is up");
        } 
        else if (theCommand.contains("PB2D")) {
            myClient.sendMessageToUI("Push Button 2 is down");
        } 
        else if (theCommand.contains("PB2U")) {
            myClient.sendMessageToUI("Push Button 2 is up");
        } 
        else if (theCommand.contains("PB3D")) {
            myClient.sendMessageToUI("Push Button 3 is down");
        } 
        else if (theCommand.contains("PB3U")) {
            myClient.sendMessageToUI("Push Button 3 is up");
        } 
    
    }

    public void handleServerMessage(String msg) {
        if (msg.charAt(0)!=0xFFFD) { //0xFFFD = UTF-8 encoding of 0xFF
            serverMessage += msg;
        } else {
            handleCompleteServerMessage(serverMessage);
            serverMessage = "";
        }
    }

    public void handleServerMessage(IOException ex) {
        myClient.sendMessageToUI("Unexpected disconnection from server. Disconnecting from server. Please try connecting to server again." + ex);
    }
}
