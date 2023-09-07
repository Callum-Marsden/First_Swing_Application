package org.example;
import net.miginfocom.swing.MigLayout;

import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;


public class MainWindow implements ActionListener{

    private JFrame window;
    private JLabel label;
    private JTextField textField;
    private JButton button;
    private JButton button2;
    private JPanel p;
    private double balance;
    private String results;
    private JLabel resultsLabel;

    public MainWindow(){
        initialise();
        balance=0;
    }

    private void initialise(){

        window = new JFrame();
        window.setTitle("First swing GUI");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(800,500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        p = new JPanel(new MigLayout());
        p.setBackground(Color.gray);

        //Create two buttons: deposit and withdraw
        button= new JButton("Deposit");
        createButton(button);

        button2= new JButton("Withdraw");
        createButton(button2);

        //Create label for displaying balance
        label= new JLabel("Balance= £0.00");
        label.setFont(new Font("Serif", Font.PLAIN, 20));

        //Text field for entering balance deposit/withdrawal amount
        textField = new JTextField(16);

        //Setting up JLabel for the activity Label
        results="";
        resultsLabel= new JLabel(results, SwingConstants.CENTER);

        p.add(label,"wrap,gap 10");
        p.add(textField);
        p.add(button);
        p.add(button2,"wrap,gap 10");
        p.add(resultsLabel);


        button.addActionListener(this);
        button2.addActionListener(this);

        window.add(p);

    }

    public void show(){
        window.setVisible(true);
    }

    //Method for creating buttons to reduce code duplication
    public void createButton(JButton genericButton){
        genericButton.setFocusable(false);
        genericButton.setMargin(new Insets(10,10,10,10));
        genericButton.setSize(new Dimension(70,55));
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.UK);
        if(e.getSource() == button){
            balance+=Double.valueOf(textField.getText());
        }
        else if (e.getSource() == button2){
            balance-=Double.valueOf(textField.getText());
        }
        label.setText("Balance= "+currencyFormatter.format(balance));
        results=results+(e.getSource()==button ? "+" : "-") +currencyFormatter.format(Double.valueOf(textField.getText()))+"<br/>";
        resultsLabel.setText("<html>" + results +"</html>");


    }
}
