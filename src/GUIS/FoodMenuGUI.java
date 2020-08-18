package GUIS;

import Backend.Server_Implementation;
import DISCO.Clientfunc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class FoodMenuGUI extends JFrame{

    private JPanel panel1;
    private JTextField ChickenRiceQTY;
    private JTextField FriedRiceQTY;
    private JTextField MiloQTY;
    private JTextField CoffeeQTY;
    private JTextField TeaQTY;
    private JButton proceedButton;
    private JButton calculateTotalButton;
    private JTextField TotalAMT;
    private JButton resetButton;
    private JTextField NasiLemakQTY;
    private JButton LogoutButton;
    private JComboBox Orderbox;

    Login login = new Login();



    public FoodMenuGUI() throws Exception {
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        proceedButton.setVisible(false);

        calculateTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nasilemak = NasiLemakQTY.getText();
                String chickenrice = ChickenRiceQTY.getText();
                String friedrice = FriedRiceQTY.getText();
                String milo = MiloQTY.getText();
                String coffee = CoffeeQTY.getText();
                String tea = TeaQTY.getText();
                double NL = Double.parseDouble(nasilemak);
                double CR = Double.parseDouble(chickenrice);
                double FR = Double.parseDouble(friedrice);
                double M = Double.parseDouble(milo);
                double C = Double.parseDouble(coffee);
                double T = Double.parseDouble(tea);
                double total = (NL*9.50)+(CR*7.50)+(FR*9.00)+(M*2.50)+(C*2.00)+(T*2.00);
                String totalstring = String.valueOf(total);
                TotalAMT.setText((totalstring));
                proceedButton.setVisible(true);
            }


        });
        Orderbox.addItem("Dine-In");
        Orderbox.addItem("Take Away");

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NasiLemakQTY.setText("");
                ChickenRiceQTY.setText("");
                FriedRiceQTY.setText("");
                MiloQTY.setText("");
                CoffeeQTY.setText("");
                TeaQTY.setText("");
                TotalAMT.setText("");
            }
        });
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Clientfunc functions = new Clientfunc();
                boolean test = false;
                String nasilemak = NasiLemakQTY.getText();
                String chickenrice = ChickenRiceQTY.getText();
                String friedrice = FriedRiceQTY.getText();
                String milo = MiloQTY.getText();
                String coffee = CoffeeQTY.getText();
                String tea = TeaQTY.getText();
                String total = TotalAMT.getText();
                String ordertype = String.valueOf(Orderbox.getSelectedItem());
                String username = login.usernamepass();



                try {
                    functions.orderinput(username,nasilemak,chickenrice,friedrice,milo,coffee,tea,total,ordertype);
                    test =true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (test)
                {
                    try {
                        OrderConfirmation orderConfirmation = new OrderConfirmation();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (NotBoundException e) {
                        e.printStackTrace();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Order Failed!");
                }

            }
        });

        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Login login = new Login();
                    dispose();
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
