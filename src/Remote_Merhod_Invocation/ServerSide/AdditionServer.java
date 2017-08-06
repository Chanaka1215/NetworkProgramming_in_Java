package Remote_Merhod_Invocation.ServerSide;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by         : Chanaka Fernando.
 * Date               : Sun, 8/6/2017 .
 * Email              : nuwan.c.fernando@gmail.com.
 * LinkedIn           : https://www.linkedin.com/in/n-chanaka-fernando
 * Belongs to Project : NetworkProgramming_Java.
 * Package            : Remote_Merhod_Invocation.ServerSide.
 */
public class AdditionServer {
    public static void main (String[]args){
        System.setProperty("java.security.policy", "file:D:\\14451b\\RMIClientSide\\security.policy");
        System.setSecurityManager(new RMISecurityManager());
        try{
            LocateRegistry.createRegistry(1099);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        try{
            Addition addition = new Addition ();
            Naming.rebind("rmi://localhost/addServ", addition);
            System.out.println("Server is Ready");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
