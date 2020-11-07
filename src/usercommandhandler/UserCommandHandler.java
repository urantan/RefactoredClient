/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercommandhandler;

/**
 *
 * @author Ngozi Francis Uranta
 */
public class UserCommandHandler {
    userinterface.UserInterface myUI;
    refactoredclient.RefactoredClient myClient;

    public UserCommandHandler(userinterface.UserInterface myUI, refactoredclient.RefactoredClient myClient) {
        this.myUI = myUI;
        this.myClient = myClient;
    }

    public void handleUserCommand(String myCommand) {
        switch (myCommand) {
            case "q": //QUIT
                if (myClient.isConnected()) {
                    myClient.sendMessageToServer((byte) 'q');
                    myClient.sendMessageToServer((byte) 0xFF);
                } else {
                    System.exit(-1);
                }
                break;
            case "c": //Connect to Server
                if (myClient.connectToServer() == true) {
                    myUI.update("Connection to Server was successful.");
                } else {
                    myUI.update("Already connected to a server.");
                }
                break;
            case "d": //Disconnect From Server
                if (myClient.isConnected()) {
                    myClient.sendMessageToServer((byte)'d');
                    myClient.sendMessageToServer((byte) 0xFF);
                } else {
                    myUI.update("Not connected to a Server.");
                }                    
                break;
            case "t": //Request the time
                if (myClient.isConnected()) {
                    myClient.sendMessageToServer((byte) 't');
                    myClient.sendMessageToServer((byte) 0xFF);
                } else {
                    myUI.update("Not connected to a Server.");
                }                    
                break;
            case "L1on": //Switch LED 1 on
                myClient.sendMessageToServer("L1on");
                myClient.sendMessageToServer((byte) 0xFF);
                break;
            case "L2on": //Switch LED 2 on
                myClient.sendMessageToServer("L2on");
                myClient.sendMessageToServer((byte) 0xFF);
                break;
            case "L3on": //Switch LED 3 on
                myClient.sendMessageToServer("L3on");
                myClient.sendMessageToServer((byte) 0xFF);
                break;
            case "L4on": //Switch LED 4 on
                myClient.sendMessageToServer("L4on");
                myClient.sendMessageToServer((byte) 0xFF);
                break;
            case "L1off": //Switch LED 1 off
                myClient.sendMessageToServer("L1off");
                myClient.sendMessageToServer((byte) 0xFF);
                break;
            case "L2off": //Switch LED 2 off
                myClient.sendMessageToServer("L2off");
                myClient.sendMessageToServer((byte) 0xFF);
                break;
            case "L3off": //Switch LED 3 off
                myClient.sendMessageToServer("L3off");
                myClient.sendMessageToServer((byte) 0xFF);
                break;
            case "L4off": //Switch LED 4 on
                myClient.sendMessageToServer("L4off");
                myClient.sendMessageToServer((byte) 0xFF);
                break;
            case "gpb1": //Get the state of Push Button 1
                myClient.sendMessageToServer("gpb1");
                myClient.sendMessageToServer((byte) 0xFF);
                break;
             case "gpb2": //Get the state of Push Button 2
                myClient.sendMessageToServer("gpb2");
                myClient.sendMessageToServer((byte) 0xFF);
                break;
            case "gpb3": //Get the state of Push Button 3
                myClient.sendMessageToServer("gpb3");
                myClient.sendMessageToServer((byte) 0xFF);
                break;
            default:
                myUI.update("What? could not recognize this command.");
                break;
        }
        
    }
}