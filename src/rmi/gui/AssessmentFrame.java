package rmi.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author rossdaly
 */
public class AssessmentFrame extends JFrame {

    private AssessmentPanel assessmentPanel;
    
    public AssessmentFrame(String title) {
        super(title);
        
        setLayout(new BorderLayout());
        
//        final JTextArea textArea = new JTextArea();
        
        assessmentPanel = new AssessmentPanel();
        
        //need a listener to check if the submit button has been pressed
        
        Container container = getContentPane();
//        container.add(textArea, BorderLayout.CENTER);
        container.add(assessmentPanel, BorderLayout.WEST);
        
    }
    
}