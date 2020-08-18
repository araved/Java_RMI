package Backend;

import java.rmi.Remote;
import java.sql.SQLException;

public interface Server_Implementation extends Remote  {

    String Login(String Username, String Password) throws Exception;
    void Registration(String FName, String LName, int ICNum, String UserName, String PassWord) throws Exception;
    boolean UsernameChecker(String UserName) throws Exception;
    void OrderInput(String username, String NasiLemakQty, String ChickenRiceQty, String FriedRiceQty, String MiloQty, String CoffeeQty, String TeaQty, String TotalAmt, String Ordertype) throws Exception;




}
