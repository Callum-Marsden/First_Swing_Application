package org.example;
import javax.swing.*;

public class App 
{
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    for ( UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                             UIManager.setLookAndFeel(info.getClassName());
                             break;
                        }
                    }
                } catch (Exception e) {
                }
                MainWindow main= new MainWindow();
                main.show();
            }
        });
    }
}
