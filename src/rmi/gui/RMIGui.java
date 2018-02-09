package rmi.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class RMIGui {

    public static void main(String[] args) {
        JFrame frame = new MainFrame("Student Login");
        
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                frame.setSize(300,150);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        
        //Receive details about the user from this and us it to get that users assignments frame
        

    }
    
}
