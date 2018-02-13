package rmi.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.EventListenerList;

/**
 *
 * @author rossdaly
 */
class AssessmentPanel extends JPanel {
    private EventListenerList listener = new EventListenerList();
    
    public AssessmentPanel(){
        
        //edit all to produce the correct assignment listings
        Dimension size = getPreferredSize();
        size.width = 500;
        setPreferredSize(size);


        setBorder(BorderFactory.createTitledBorder("Assessment Number: "));
        
        //Remove this test~~~~~~~
        ArrayList<String> questionsList = new ArrayList<String>(); //test start
        questionsList.add("Where do babys come from?");
        questionsList.add("What is the meaning of life?");
        questionsList.add("How long is a peice of string?");
        
        ArrayList<String> answerList = new ArrayList<String>(); //test start
        answerList.add("Jesus");
        answerList.add("Mexico");
        answerList.add("7");
        answerList.add("All of these");
        
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = .5;
        gc.weighty = .5;
        for(int i=0; i < questionsList.size(); i++){
            JLabel ques1 = new JLabel(questionsList.get(i));
            gc.gridx = 0;
            gc.gridy = i+1;
            add(ques1, gc);
            
            ButtonGroup group2 = new ButtonGroup();     //create radio group for this question
            gc.anchor = GridBagConstraints.LINE_START;
            
            gc.gridy = i+1;
            for(int j=0; j< answerList.size(); j++){
                gc.gridx = j+1;
                JRadioButton radioBtn = new JRadioButton(answerList.get(j));
                add(radioBtn, gc);
                
                //add radio button to group
                group2.add(radioBtn);
            }
            

        }
        
        
//        JLabel ques1 = new JLabel(questionsList.get(0));   //pass in the string 1 from the array
//        JLabel ques2 = new JLabel(questionsList.get(1));
//        JLabel ques3 = new JLabel(questionsList.get(2));
//        headingCol1.setFont(new Font("Serif", Font.BOLD, 20));

//        JLabel answerLabelA = new JLabel("A");
//        answerLabelA.setFont(new Font("Serif", Font.BOLD, 16));
//        JLabel answerLabelB = new JLabel("B");
//        answerLabelB.setFont(new Font("Serif", Font.BOLD, 16));
//        JLabel answerLabelC = new JLabel("C");
//        answerLabelC.setFont(new Font("Serif", Font.BOLD, 16));
//        JLabel answerLabelD = new JLabel("D");
//        answerLabelD.setFont(new Font("Serif", Font.BOLD, 16));
        
//        final JTextField idField = new JTextField(10);
//        final JPasswordField passwordField = new JPasswordField(10);

//        JRadioButton radioBtnGroup1A = new JRadioButton();    //could swap the static text for an answer set supplied by the server
//        JRadioButton radioBtnGroup1B = new JRadioButton();
//        JRadioButton radioBtnGroup1C = new JRadioButton();
//        JRadioButton radioBtnGroup1D = new JRadioButton();
//        JRadioButton radioBtnGroup2A = new JRadioButton();
//        JRadioButton radioBtnGroup2B = new JRadioButton();
//        JRadioButton radioBtnGroup2C = new JRadioButton();
//        JRadioButton radioBtnGroup2D = new JRadioButton();
//        JRadioButton radioBtnGroup3A = new JRadioButton();
//        JRadioButton radioBtnGroup3B = new JRadioButton();
//        JRadioButton radioBtnGroup3C = new JRadioButton();
//        JRadioButton radioBtnGroup3D = new JRadioButton();
//
//        ButtonGroup group1 = new ButtonGroup();
//        group1.add(radioBtnGroup1A);
//        group1.add(radioBtnGroup1B);
//        group1.add(radioBtnGroup1C);
//        group1.add(radioBtnGroup1D);
//        
//        ButtonGroup group2 = new ButtonGroup();
//        group2.add(radioBtnGroup2A);
//        group2.add(radioBtnGroup2B);
//        group2.add(radioBtnGroup2C);
//        group2.add(radioBtnGroup2D);
//        
//        ButtonGroup group3 = new ButtonGroup();
//        group3.add(radioBtnGroup3A);
//        group3.add(radioBtnGroup3B);
//        group3.add(radioBtnGroup3C);
//        group3.add(radioBtnGroup3D);
        
        JButton submitBtn = new JButton("Submit");
        
        submitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("you pressed the submit button");
                //get users questions by passing the user id and assignment number
                
//                ArrayList<String> questionsList = new ArrayList<String>(); //test start
//                questionsList.add("Where do babys come from?");
//                questionsList.add("What is the meaning of life?");
//                questionsList.add("How long is a peice of string?");
//                Assessment assessment = new Assessment(questionsList);
                 // preform action here for assignmnet 1
            }
        });


//        setLayout(new GridBagLayout());
//
//        GridBagConstraints gc = new GridBagConstraints();

        //// First Column /////////
//        gc.anchor = GridBagConstraints.LINE_START;

//        gc.weightx = .5;
//        gc.weighty = .5;
//
//        gc.gridx = 0;
//        gc.gridy = 1;
//        add(ques1, gc);
//        
//        gc.gridx = 0;
//        gc.gridy = 2;
//        add(ques2, gc);
//
//        gc.gridx = 0;
//        gc.gridy = 3;
//        add(ques3, gc);

        //// Second Column ////////
//        gc.anchor = GridBagConstraints.LINE_START;
//        
//        gc.gridx = 1;
//        gc.gridy = 0;
//        add(answerLabelA, gc);
//        
//        gc.gridx = 1;
//        gc.gridy = 1;
//        add(radioBtnGroup1A, gc);
//
//        gc.gridx = 1;
//        gc.gridy = 2;
//        add(radioBtnGroup2A, gc);
//        
//        gc.gridx = 1;
//        gc.gridy = 3;
//        add(radioBtnGroup3A, gc);
//        
//        //// Third Column ////////
//        gc.anchor = GridBagConstraints.LINE_START;
//        
//        gc.gridx = 2;
//        gc.gridy = 0;
//        add(answerLabelB, gc);
//        
//        gc.gridx = 2;
//        gc.gridy = 1;
//        add(radioBtnGroup1B, gc);
//
//        gc.gridx = 2;
//        gc.gridy = 2;
//        add(radioBtnGroup2B, gc);
//        
//        gc.gridx = 2;
//        gc.gridy = 3;
//        add(radioBtnGroup3B, gc);
//        
//        //// Fourth Column ///////
//        gc.anchor = GridBagConstraints.LINE_START;
//        
//        gc.gridx = 3;
//        gc.gridy = 0;
//        add(answerLabelC, gc);
//        
//        gc.gridx = 3;
//        gc.gridy = 1;
//        add(radioBtnGroup1C, gc);
//        
//        gc.gridx = 3;
//        gc.gridy = 2;
//        add(radioBtnGroup2C, gc);
//        
//        gc.gridx = 3;
//        gc.gridy = 3;
//        add(radioBtnGroup3C, gc);
//        
//        //// Fifth Column ///////
//        gc.anchor = GridBagConstraints.LINE_START;
//        
//        gc.gridx = 4;
//        gc.gridy = 0;
//        add(answerLabelD, gc);
//        
//        gc.gridx = 4;
//        gc.gridy = 1;
//        add(radioBtnGroup1D, gc);
//        
//        gc.gridx = 4;
//        gc.gridy = 2;
//        add(radioBtnGroup2D, gc);
//        
//        gc.gridx = 4;
//        gc.gridy = 3;
//        add(radioBtnGroup3D, gc);
        
        //// Final Row /////////
//        gc.weighty = 10;

//        gc.anchor = GridBagConstraints.FIRST_LINE_START;
//        gc.gridx = 1;
        gc.gridy = 4;
        add(submitBtn, gc);   
   }

}
