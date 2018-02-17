package rmi.gui;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author rossdaly
 */
class AssessmentForm {
    
    private int numQuestions;
    
    AssessmentForm(int numQuestions) {
        this.numQuestions = numQuestions;
    }
    
    public void AssessmentForm(){
        JFrame assessmentFrame = new AssessmentFrame("Assessment");   //change from MainFrame and create a new Frame class for assignments
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                assessmentFrame.setSize(1200,100*numQuestions);
                assessmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                assessmentFrame.setVisible(true);
            }
        });
    }
}
