package Backend;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.Statement;

public class Server_Functions extends UnicastRemoteObject implements Server_Implementation {
    protected Server_Functions() throws RemoteException {
        super();
    }



    public String Login(String Username, String Password) throws Exception {
        DBConfig dbConfig = new DBConfig();

        ResultSet resultSet = dbConfig.userlogin.executeQuery("SELECT * FROM Customer");
        String uname = Username;
        String user;
        int x =0;
        while (resultSet.next())
        {
            if (resultSet.getString("Username").equals(Username) && resultSet.getString("Password").equals(Password))
            {
                x = 1;
                break;
            }
        }

        if (x == 1)
        {
            user=uname;
        }
        else {
            user="Error";
        }

        return user;

    };
    public void Registration(String FName, String LName, int ICNum, String UserName, String PassWord) throws Exception {
        DBConfig db = new DBConfig();
        db.userregister.executeUpdate("INSERT INTO Customer (First_Name, Last_Name, IC_Number, Username, Password) " +
                "VALUES ('"+FName+"','"+LName+"',"+ICNum+",'"+UserName+"','"+PassWord+"')", Statement.RETURN_GENERATED_KEYS
        );
    }
    public boolean UsernameChecker(String UserName) throws Exception {
      DBConfig db = new DBConfig();
      ResultSet rs = db.userverify.executeQuery( "SELECT * FROM Customer");
      int y=0;
        boolean testing = false;

        while(rs.next()){

          if (rs.getString("Username").equals(UserName))
          {
              y=1;
              break;
          }
      }
      if (y==1)
      {
          testing = true;
      }
      return testing;
    }
    public void OrderInput(String username, String NasiLemakQty, String ChickenRiceQty, String FriedRiceQty, String MiloQty, String CoffeeQty, String TeaQty, String TotalAmt, String Ordertype) throws Exception {
        DBConfig db = new DBConfig();
        db.orderinput.executeUpdate("INSERT INTO Orders(Username,`Nasi Lemak`, `Chicken Rice`, `Fried Rice`, Milo, Coffee, Tea,`Total Amount`, `Order Type`) "+
                "VALUES ('"+username+"','"+NasiLemakQty+"','"+ChickenRiceQty+"','"+FriedRiceQty+"','"+MiloQty+"','"+CoffeeQty+"','"+TeaQty+"','"+TotalAmt+"','"+Ordertype+"')",Statement.RETURN_GENERATED_KEYS);
    }

}


