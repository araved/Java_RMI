package Backend;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Server {

    public Server() throws RemoteException {
    }

    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(900);
        registry.rebind("Server",new Server_Functions());
        System.out.println("Server On!");
    }
}
