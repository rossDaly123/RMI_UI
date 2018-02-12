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

        JLabel ques1 = new JLabel("Question 1~~~~~");   //pass in the string 1 from the array
        JLabel ques2 = new JLabel("Question 2~~~~~");
        JLabel ques3 = new JLabel("Question 3~~~~~");
//        headingCol1.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel trueLabel = new JLabel("True");
        trueLabel.setFont(new Font("Serif", Font.BOLD, 16));
        JLabel falseLabel = new JLabel("False");
        falseLabel.setFont(new Font("Serif", Font.BOLD, 16));
        
//        final JTextField idField = new JTextField(10);
//        final JPasswordField passwordField = new JPasswordField(10);

        JRadioButton assign1Btn = new JRadioButton("Check");
        JRadioButton assign2Btn = new JRadioButton("Check");
        JRadioButton assign3Btn = new JRadioButton("Check");
        JRadioButton assign4Btn = new JRadioButton("Check");
        JRadioButton assign5Btn = new JRadioButton("Check");
        JRadioButton assign6Btn = new JRadioButton("Check");

        ButtonGroup group1 = new ButtonGroup();
        group1.add(assign1Btn);
        group1.add(assign2Btn);
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(assign3Btn);
        group2.add(assign4Btn);
        
        ButtonGroup group3 = new ButtonGroup();
        group3.add(assign5Btn);
        group3.add(assign6Btn);
        
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


        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //// First Column /////////
//        gc.anchor = GridBagConstraints.LINE_START;

        gc.weightx = .5;
        gc.weighty = .5;

        gc.gridx = 0;
        gc.gridy = 1;
        add(ques1, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        add(ques2, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(ques3, gc);

        //// Second Column ////////
        gc.anchor = GridBagConstraints.LINE_START;
        
        gc.gridx = 1;
        gc.gridy = 0;
        add(trueLabel, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        add(assign1Btn, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(assign3Btn, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        add(assign5Btn, gc);
        
        //// Third Column ////////
        gc.anchor = GridBagConstraints.LINE_START;
        
        gc.gridx = 2;
        gc.gridy = 0;
        add(falseLabel, gc);
        
        gc.gridx = 2;
        gc.gridy = 1;
        add(assign2Btn, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        add(assign4Btn, gc);
        
        gc.gridx = 2;
        gc.gridy = 3;
        add(assign6Btn, gc);
        
        //// Final Row /////////
//        gc.weighty = 10;

//        gc.anchor = GridBagConstraints.FIRST_LINE_START;
//        gc.gridx = 1;
        gc.gridy = 4;
        add(submitBtn, gc);   
   }

}
