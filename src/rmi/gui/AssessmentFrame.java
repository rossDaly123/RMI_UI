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
        
        assessmentPanel = new AssessmentPanel();
        
        Container container = getContentPane();
        container.add(assessmentPanel, BorderLayout.WEST);
        
    }
    
}