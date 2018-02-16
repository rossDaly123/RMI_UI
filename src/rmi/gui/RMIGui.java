package rmi.gui;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ct414.ExamServer;
import java.util.ArrayList;

public class RMIGui {
    protected static ExamServer server;
    protected static String token;
    protected static ArrayList<String> assessmentIDs;
    protected static ArrayList<String> assessmentTitles;
    
    
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Registry registry = LocateRegistry.getRegistry("159.65.23.223", 1099);
            server = (ExamServer) registry.lookup("ExamServer");
            assessmentIDs = new ArrayList<String>();
            assessmentTitles = new ArrayList<String>();
            
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
}
