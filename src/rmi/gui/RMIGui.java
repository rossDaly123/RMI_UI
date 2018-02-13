package rmi.gui;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ct414.ExamServer;


public class RMIGui {
    JFrame frame;
    
    public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		try {
			Registry registry = LocateRegistry.getRegistry("159.65.23.223", 1099);
	        ExamServer e = (ExamServer) registry.lookup("ExamServer");
	        JFrame frame = new LoginFrame("Student Login");
	        SwingUtilities.invokeLater(new Runnable(){
	            public void run(){
	                frame.setSize(300,150);
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setVisible(true);
	            }
	        });
		} catch (Exception e) {
	        System.err.println("Didnt Work!");
	        e.printStackTrace();
	    }
        
    }
    public void setLoginInvisible(){
        frame.setVisible(false);
    }
    
}
