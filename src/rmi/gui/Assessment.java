package rmi.gui;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author rossdaly
 */
class Assessment {
    
    private ArrayList questions = new ArrayList();
    
    Assessment(ArrayList<String> questionsList) {
        this.questions = questionsList;
        System.out.println(questionsList);
    }
    
    public void Assessment(){
        JFrame assessmentFrame = new AssessmentFrame("Assessment");   //change from MainFrame and create a new Frame class for assignments
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                assessmentFrame.setSize(500,250);
                assessmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                assessmentFrame.setVisible(true);
            }
        });
    }
}
