package rmi.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        
        //edit all to produce the correct assignment listings
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
                 // preform action here
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

}
