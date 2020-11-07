/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactoredclienttest;

/**
 *
 * @author Ngozi Francis Uranta
 */
import java.net.InetAddress;
public class RefactoredClientTest {
    
   public static void main(String []args){
        
        standardiouserinterface.StandardioUserInterface myUI = new standardiouserinterface.StandardioUserInterface();
        refactoredclient.RefactoredClient myClient = new refactoredclient.RefactoredClient( (int)5555, (String)"127.0.0.1", myUI);
        usercommandhandler.UserCommandHandler myUserCommandHandler = new usercommandhandler.UserCommandHandler(myUI, myClient);
        myUI.setCommand(myUserCommandHandler);
        Thread theUIThread = new Thread(myUI);
        theUIThread.start();     
        myUI.update("q:\tQuit\nc:\tConnect To Server\nd:\tDisconnect From Server\nt:\tRequest the time\nL<1,2,3,4><on,off>:\tTurn Led on or off\ngpb<1,2,3>:\tGet Push button states\n");
    }
}
