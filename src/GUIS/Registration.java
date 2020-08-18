package GUIS;

import DISCO.Clientfunc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Registration extends JFrame {
    private JPanel panel1;
    private JTextField FirstNameField;
    private JTextField LastNameField;
    private JTextField ICNumberField;
    private JTextField UsernameField;
    private JPasswordField PasswordField;
    private JButton checkAvailabilityButton;
    private JButton registerButton;
    private JButton Back;


    public JPanel getPanel1() {
        return panel1;
    }
    public Registration() {

        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        registerButton.setVisible(false);


        checkAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Clientfunc functions = new Clientfunc();
                String username = UsernameField.getText();
                try {
                    if (functions.checkusername(username))
                    {
                        JOptionPane.showMessageDialog(null,"Username exist!");

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Username Available!");
                        registerButton.setVisible(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String FirstName=FirstNameField.getText();
                String LastName=LastNameField.getText();
                int ICNumber= Integer.parseInt(ICNumberField.getText());
                String Username=UsernameField.getText();
                String Password=PasswordField.getText();

                Clientfunc functions = new Clientfunc();
                boolean test = false;
                try {
                    functions.registrationfunc(FirstName,LastName,ICNumber,Username,Password);
                    test =true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (test)
                {
                    JOptionPane.showMessageDialog(null,"Registration Successful!");
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Registration Failed!");
                }

            }
        });
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Login login = new Login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dispose();

            }
        });
    }
}
