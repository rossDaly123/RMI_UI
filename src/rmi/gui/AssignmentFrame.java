/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
//        final JTextArea textArea = new JTextArea();
        
        assignmentPanel = new AssignmnetPanel();
        
        //need a listener to check if the submit button has been pressed
        
        Container container = getContentPane();
//        container.add(textArea, BorderLayout.CENTER);
        container.add(assignmentPanel, BorderLayout.WEST);
    }
}
