package rmi.gui;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author rossdaly
 */
public class IndividualAssignments {

    private ArrayList currentUser = new ArrayList();
    
    IndividualAssignments(ArrayList<String> assignmentList) {
        this.currentUser = assignmentList;
    }
    
    public void IndividualAssignments(){
        System.out.println(currentUser);
        
        JFrame assinmentFrame = new MainFrame("Assignment List");   //change from MainFrame and create a new Frame class for assignments
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                assinmentFrame.setSize(500,400);
                assinmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                assinmentFrame.setVisible(true);
            }
        });
    }
    
}
