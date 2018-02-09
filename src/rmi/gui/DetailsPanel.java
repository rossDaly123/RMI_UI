package rmi.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.EventListenerList;

/**
 *
 * @author rossdaly
 */
public class DetailsPanel extends JPanel {
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
               
               String text = id + ": " + password + "\n";
               // send password to relivent database and access the users account detials
               fireDetailEvent(new DetailEvent(this, text));
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