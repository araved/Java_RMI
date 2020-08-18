package GUIS;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Backend.Server_Implementation;
import DISCO.Clientfunc;
import DISCO.Main;
import com.mysql.cj.xdevapi.Client;

public class Login extends javax.swing.JFrame {

    private JPanel panel1;
    private JTextField UsernameField;
    private JPasswordField PasswordField;
    private JButton logInButton;
    private JButton registerButton;




    /* private void initComponents()
    {
        JPanel = new panel1;
        private JTextField UsernameField;
        private JPasswordField PasswordField;
        private JButton logInButton;
        private JButton registerButton;
    }*/
    public Login() throws Exception {


        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);






        this.logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                String Password = PasswordField.getText();
                String Username = UsernameField.getText();
                Clientfunc functions = new Clientfunc();
                try {
                    if(functions.loginfunction(Username,Password).equals(Username))
                    {
                        JOptionPane.showMessageDialog(null,"Login Success");
                        FoodMenuGUI foodMenuGUI = new FoodMenuGUI();
                        dispose();
                        setVisible(false);

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Login Fail");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Registration registration = new Registration();
                dispose();
                setVisible(false);





            }


        });
    }

    public String usernamepass ()
    {
        String Usernamepass = UsernameField.getText();
        return Usernamepass;

    }
}


