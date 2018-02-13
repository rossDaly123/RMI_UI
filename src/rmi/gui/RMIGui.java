package rmi.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class RMIGui {
    JFrame frame;
    
    public static void main(String[] args) {
        JFrame frame = new LoginFrame("Student Login");
        
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                frame.setSize(300,150);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        
    }
    public void setLoginInvisible(){
        frame.setVisible(false);
    }
    
}
