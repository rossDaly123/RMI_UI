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
                    System.out.println("you pressed: " + evt);
                    
                    //trying to set the id of a button to allow us to find the correct assignment for the button pressed (set a hidden id with the button to keep track)
                    for(int b=0; b<buttonArray.size(); b++){
                        if(evt.equals(buttonArray.get(b))){
                            System.out.println("We got ignition!!!");
                        }
                    }
                    
                    //get users questions by passing the user id and assignment number
                    System.out.println("Assessment ID: "+ RMIGui.assessmentIDs.get(0)+".");
                    try{
                        Assessment a = (Assessment) RMIGui.server.getAssessmentByID(RMIGui.token, RMIGui.assessmentIDs.get(0));
                        // Assessment a = (Assessment) RMIGui.server.getAssessmentByID(RMIGui.token, RMIGui.assessmentIDs.get(0));
                        // System.out.println(a.getQuestion(0));
                        
                    }catch(Exception e){
                        System.out.println("---" + e);
                    }
                   // ArrayList<String> questionsList = new ArrayList<String>(); //test start
//                    questionsList.add("Where do babys come from?");
//                    questionsList.add("What is the meaning of life?");
//                    questionsList.add("How long is a peice of string?");
                    // AssessmentForm assessment = new AssessmentForm(questionsList);
                    // assessment.AssessmentForm();
                     // preform action depending on the button pressed to find the relivent assignmnet
                }
            });
            // add to a preveously created button array
        }
//        System.out.println("The buttonArray contains: "+ buttonArray);
//        if(buttonArray.get(0)==buttonArray.get(1)){
//            System.out.println("The buttons are the same");
//        }
//        if(buttonArray.get(0)==buttonArray.get(2)){
//            System.out.println("The buttons are the same");
//        }
        //based on the position in the button assignmnet
        
//        JLabel assignLabel1 = new JLabel("-Assignment 1");
//        JLabel assignLabel2 = new JLabel("-Assignment 2");
//        JLabel assignLabel3 = new JLabel("-Assignment 3");
//        
////        final JTextField idField = new JTextField(10);
////        final JPasswordField passwordField = new JPasswordField(10);
//
//        JLabel status1 = new JLabel("Done");
//        JLabel status2 = new JLabel("Make Dynamic");
//        JLabel status3 = new JLabel("Done");
//
//        JButton assign1Btn = new JButton("Check");
//        JButton assign2Btn = new JButton("Check");
//        JButton assign3Btn = new JButton("Check");

//        assign1Btn.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                System.out.println("you pressed 1");
//                //get users questions by passing the user id and assignment number
//                
//                ArrayList<String> questionsList = new ArrayList<String>(); //test start
//                questionsList.add("Where do babys come from?");
//                questionsList.add("What is the meaning of life?");
//                questionsList.add("How long is a peice of string?");
//                AssessmentForm assessment = new AssessmentForm(questionsList);
//                assessment.AssessmentForm();
//                 // preform action here for assignmnet 1
//            }
//        });
//        assign2Btn.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                System.out.println("you pressed 2");
//                // preform action here for assignmnet 2
//                 
//                ArrayList<String> questionsList = new ArrayList<String>(); //test start
//                questionsList.add("Where do babys come from?");
//                questionsList.add("What is the meaning of life?");
//                questionsList.add("How long is a peice of string?");
//                AssessmentForm assessment = new AssessmentForm(questionsList);
//                assessment.AssessmentForm();
//            }
//        });
//        assign3Btn.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                System.out.println("you pressed 3");
//                // preform action here for assignmnet 3
//                
//                ArrayList<String> questionsList = new ArrayList<String>(); //test start
//                questionsList.add("Where do babys come from?");
//                questionsList.add("What is the meaning of life?");
//                questionsList.add("How long is a peice of string?");
//                AssessmentForm assessment = new AssessmentForm(questionsList);
//                assessment.AssessmentForm();
//            }
//        });

//        setLayout(new GridBagLayout());
//
//        GridBagConstraints gc = new GridBagConstraints();

        //// First Column /////////
        gc.anchor = GridBagConstraints.LINE_START;

        gc.weightx = .5;
        gc.weighty = .5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(headingCol1, gc);
        
//        gc.gridx = 0;
//        gc.gridy = 1;
//        add(assignLabel1, gc);
//
//        gc.gridx = 0;
//        gc.gridy = 2;
//        add(assignLabel2, gc);
//        
//        gc.gridx = 0;
//        gc.gridy = 3;
//        add(assignLabel3, gc);

        //// Second Column ////////
        gc.anchor = GridBagConstraints.LINE_START;

        gc.gridx = 1;
        gc.gridy = 0;
        add(headingCol2, gc);
        
//        gc.gridx = 1;
//        gc.gridy = 1;
//        add(status1, gc);
//
//        gc.gridx = 1;
//        gc.gridy = 2;
//        add(status2, gc);
//        
//        gc.gridx = 1;
//        gc.gridy = 3;
//        add(status3, gc);

        //// Third Column ////////
        gc.anchor = GridBagConstraints.LINE_START;
        
        gc.gridx = 2;
        gc.gridy = 0;
        add(headingCol3, gc);
        
//        gc.gridx = 2;
//        gc.gridy = 1;
//        add(assign1Btn, gc);
//
//        gc.gridx = 2;
//        gc.gridy = 2;
//        add(assign2Btn, gc);
//        
//        gc.gridx = 2;
//        gc.gridy = 3;
//        add(assign3Btn, gc);
          
   }

}
