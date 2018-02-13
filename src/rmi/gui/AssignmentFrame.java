package rmi.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author rossdaly
 */
public class AssignmentFrame extends JFrame{
    
    private AssignmnetPanel assignmentPanel;
    
    public AssignmentFrame(String title){
        super(title);
        
        setLayout(new BorderLayout());
        
        assignmentPanel = new AssignmnetPanel();
        
        Container container = getContentPane();
        container.add(assignmentPanel, BorderLayout.WEST);
    }
}
