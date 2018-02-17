package rmi.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.EventListenerList;

/**
 *
 * @author rossdaly
 */
public class DetailsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
private EventListenerList listener = new EventListenerList();
   
   public DetailsPanel(){
       Dimension size = getPreferredSize();
       size.width = 300;
       setPreferredSize(size);
       setBorder(BorderFactory.createTitledBorder("Personal Details"));
       JLabel idLabel = new JLabel("Student ID: ");
       JLabel passwordLabel = new JLabel("Password: ");
       final JTextField idField = new JTextField(10);
       final JPasswordField passwordField = new JPasswordField(10);
       JButton addBtn = new JButton("Submit");
       addBtn.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                String id = idField.getText();
                String password = passwordField.getText();
                try{
                    RMIGui.token = RMIGui.server.login(id, password);
                    ArrayList<String> details = new ArrayList<String>(RMIGui.server.getAvailableSummary(RMIGui.token));
                    for(int i=0; i < details.size(); i++){
	                     String[] splitText = details.get(i).split("-");
	                     RMIGui.assessmentIDs.add(splitText[0]);
	                     RMIGui.assessmentStatuses.add(splitText[1]);
	                     RMIGui.assessmentMarks.add(splitText[2]);
	                     RMIGui.assessmentTitles.add(splitText[3]);
                    }
                    IndividualAssignments currentUser = new IndividualAssignments(id); 
                    currentUser.IndividualAssignments(); 
                } catch (Exception badLogin){
                    System.err.println("Access Denied");
                    badLogin.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Access Denied");
                    System.exit(0); //failed login will result in termination
                }
                fireDetailEvent(new DetailEvent(this, "Login"));
           }

       });
       
       setLayout(new GridBagLayout());
       
       GridBagConstraints gc = new GridBagConstraints();
       
       //// First Column /////////
       gc.anchor = GridBagConstraints.LINE_END;
       
       gc.weightx = .5;
       gc.weighty = .5;
       
       gc.gridx = 0;
       gc.gridy = 0;
       add(idLabel, gc);
       
       gc.gridx = 0;
       gc.gridy = 1;
       add(passwordLabel, gc);
       
       //// Second Column ////////
       gc.anchor = GridBagConstraints.LINE_START;
       
       gc.gridx = 1;
       gc.gridy = 0;
       add(idField, gc);
       
       gc.gridx = 1;
       gc.gridy = 1;
       add(passwordField, gc);
       
       //// Final Row /////////
       gc.weighty = 10;
       
       gc.anchor = GridBagConstraints.FIRST_LINE_START;
       gc.gridx = 1;
       gc.gridy = 2;
       add(addBtn, gc);   
   }
   
   public void fireDetailEvent(DetailEvent event){
       Object[] listeners = listenerList.getListenerList();
       
       for(int i=0; i<listeners.length; i+=2){
           if(listeners[i] == DetailListener.class){
               ((DetailListener)listeners[i+1]).detailEvenOccured(event);
           }
       }
   }
   
   public void addDetailListener(DetailListener listener){
       listenerList.add(DetailListener.class, listener);
   }
   public void removeDetailListener(DetailListener listener){
       listenerList.remove(DetailListener.class, listener);
   }
}