package rmi.gui;

import ct414.Assessment;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

/**
 *
 * @author rossdaly
 */
class AssignmnetPanel extends JPanel {
    private EventListenerList listener = new EventListenerList();

    public AssignmnetPanel(){
        
        Dimension size = getPreferredSize();
        size.width = 500;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Assignment List"));
        JLabel headingCol1 = new JLabel("Assignment");
        JLabel headingCol2 = new JLabel("Status");
        JLabel headingCol3 = new JLabel("Score");
        JLabel headingCol4 = new JLabel("Access");
        headingCol1.setFont(new Font("Serif", Font.BOLD, 20));
        headingCol2.setFont(new Font("Serif", Font.BOLD, 20));
        headingCol3.setFont(new Font("Serif", Font.BOLD, 20));
        headingCol4.setFont(new Font("Serif", Font.BOLD, 20));
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        ArrayList<JButton> buttonArray = new ArrayList<JButton>();
        
        for(int a=0; a < RMIGui.assessmentTitles.size(); a++){
            gc.anchor = GridBagConstraints.LINE_START;
            gc.weightx = .5;
            gc.weighty = .5;
            
            JLabel assignLabel = new JLabel(RMIGui.assessmentTitles.get(a));
            JLabel status = new JLabel(RMIGui.assessmentStatuses.get(a));
            JLabel marks = new JLabel(RMIGui.assessmentMarks.get(a));
            JButton assignBtn = new JButton("Check");
            assignBtn.putClientProperty( "ID", RMIGui.assessmentIDs.get(a));
            gc.gridx = 0;
            gc.gridy = a+1;
            add(assignLabel, gc);
            gc.gridx = 1;
            add(status, gc);
            gc.gridx = 2;
            add(marks, gc);
            gc.gridx = 3;
            add(assignBtn, gc);
            buttonArray.add(assignBtn);
            assignBtn.addActionListener(new ActionListener(){
                public void actionPerformed(java.awt.event.ActionEvent evt){
                    try{
                    		System.out.println(assignBtn.getClientProperty("ID").toString());
                        RMIGui.workingAssessment = (Assessment) RMIGui.server.getAssessmentByID(RMIGui.token, assignBtn.getClientProperty("ID").toString());
                    }catch(Exception e){
                        System.out.println("---" + e);
                    }
                }
            });
        }

        //// First Column /////////
        gc.anchor = GridBagConstraints.LINE_START;

        gc.weightx = .5;
        gc.weighty = .5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(headingCol1, gc);

        //// Second Column ////////
        gc.anchor = GridBagConstraints.LINE_START;

        gc.gridx = 1;
        gc.gridy = 0;
        add(headingCol2, gc);

        //// Third Column ////////
        gc.anchor = GridBagConstraints.LINE_START;
        
        gc.gridx = 2;
        gc.gridy = 0;
        add(headingCol3, gc);
        
        //// Fourth Column ////////
        gc.anchor = GridBagConstraints.LINE_START;
        
        gc.gridx = 3;
        gc.gridy = 0;
        add(headingCol4, gc);
        
          
   }

}
