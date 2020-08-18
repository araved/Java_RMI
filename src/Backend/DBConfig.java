package Backend;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DBConfig {

    Connection connection;

    public Statement userlogin;
    public Statement userregister;
    public Statement userverify;
    public Statement orderinput;
    public Statement userorder;

    public DBConfig() throws SQLException
    {
        // Initialize DB Connection
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:8889/DCOMS","admin","admin"
        );

        userlogin = connection.createStatement();


        userregister = connection.createStatement();

        userverify = connection.createStatement();

        orderinput = connection.createStatement();

        userorder=connection.createStatement();

    }

}
