package rmi.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class RMIGui {

    public static void main(String[] args) {
        JFrame frame = new MainFrame("My Test Frame Title");
        
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                frame.setSize(500,400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        

    }
    
}
