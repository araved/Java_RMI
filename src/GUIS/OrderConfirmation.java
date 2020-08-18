package GUIS;

import javax.swing.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class OrderConfirmation extends JDialog {
    private JPanel ConfirmPanel;
    private JButton newOrderButton;
    private JButton logOutButton;
    private JButton buttonOK;
    private JButton buttonCancel;


    public OrderConfirmation() throws RemoteException, NotBoundException, MalformedURLException {

        setContentPane(ConfirmPanel);
        setModal(true);
        pack();
        setVisible(true);


        newOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    FoodMenuGUI foodMenuGUI = new FoodMenuGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dispose();
                setVisible(false);


            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Login login = new Login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dispose();
                setVisible(false);

            }
        });
    }




 /*   public static void main(String[] args) {
        OrderConfirmation dialog = new OrderConfirmation();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }*/
}
