package DISCO;

import Backend.Server_Implementation;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Clientfunc {
    Server_Implementation serverImplementation;

    {
        try {
            serverImplementation = (Server_Implementation) Naming.lookup("rmi://localhost:900/Server");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public String loginfunction(String Username, String Password) throws Exception {
        String uname = Username;
        String pwd = Password;

        String username = serverImplementation.Login(uname,pwd);
        return username;

    }

    public void registrationfunc(String FName, String LName, int ICNum, String UserName, String PassWord) throws Exception
    {
        String firstname=FName;
        String lastname=LName;
        int icnum=ICNum;
        String username=UserName;
        String password=PassWord;

        serverImplementation.Registration(firstname,lastname,icnum,username,password);


    }
    public boolean checkusername(String Username) throws Exception
    {
        String Uname=Username;

        boolean test = serverImplementation.UsernameChecker(Uname);
        return test;
    }
    public void orderinput(String Username,String NasiLemakQty, String ChickenRiceQty, String FriedRiceQty, String MiloQty, String CoffeeQty, String TeaQty, String TotalAmt, String Ordertype) throws Exception
    {
        String nasilemak = NasiLemakQty;
        String chickenrice = ChickenRiceQty;
        String friedrice = FriedRiceQty;
        String milo = MiloQty;
        String coffee = CoffeeQty;
        String tea = TeaQty;
        String totalamt = TotalAmt;
        String ordertype = Ordertype;
        String username=Username;

        serverImplementation.OrderInput(username,nasilemak,chickenrice,friedrice,milo,coffee,tea,totalamt,ordertype);

    }

}
