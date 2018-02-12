package rmi.gui;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author rossdaly
 */
public class IndividualAssignments {

    private String id;
    private ArrayList currentUser = new ArrayList();
    
    IndividualAssignments(ArrayList<String> assignmentList, String id) {
        this.currentUser = assignmentList;
        this.id = id;
    }
    
    public void IndividualAssignments(){
        System.out.println(currentUser);
        
        JFrame assinmentFrame = new AssignmentFrame("Logged in as: "+id);   //change from MainFrame and create a new Frame class for assignments
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                assinmentFrame.setSize(500,250);
                assinmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                assinmentFrame.setVisible(true);
            }
        });
    }
    
}
