package rmi.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.EventListenerList;

import ct414.Assessment;
import ct414.InvalidOptionNumber;
import ct414.InvalidQuestionNumber;
import ct414.NoMatchingAssessment;
import ct414.Question;
import ct414.UnauthorizedAccess;

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
        setBorder(BorderFactory.createTitledBorder(RMIGui.workingAssessment.getInformation()));
        ArrayList<Question> questions = new ArrayList<Question>(RMIGui.workingAssessment.getQuestions());      
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = .5;
        gc.weighty = .5;
        for(int i=0; i < questions.size(); i++){
            JLabel ques1 = new JLabel(questions.get(i).getQuestionDetail());
            gc.gridx = 0;
            gc.gridy = i+1;
            add(ques1, gc);
            ButtonGroup group = new ButtonGroup();     //create radio group for this question
            gc.anchor = GridBagConstraints.LINE_START;
            gc.gridy = i+1;
            for(int j=0; j< questions.get(i).getAnswerOptions().length; j++){
                gc.gridx = j+1;
                JRadioButton radioBtn = new JRadioButton(questions.get(i).getAnswerOptions()[j]);
                final int questionIndex = i;
                final int answerIndex = j;
                radioBtn.addActionListener(new ActionListener() {
                		public void actionPerformed(ActionEvent e){
                			if(radioBtn.isSelected()) {
                				try {
									RMIGui.workingAssessment.selectAnswer(questionIndex, answerIndex);
								} catch (InvalidQuestionNumber e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (InvalidOptionNumber e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
                			}
                		}
                });
                add(radioBtn, gc);
                group.add(radioBtn);
            }
        }

        JButton submitBtn = new JButton("Submit");   
        submitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
					RMIGui.server.submitAssessment(RMIGui.token, (Assessment) RMIGui.workingAssessment);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnauthorizedAccess e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoMatchingAssessment e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        gc.gridy = 4;
        add(submitBtn, gc);   
   }

}
