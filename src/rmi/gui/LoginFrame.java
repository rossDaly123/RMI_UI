package rmi.gui;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author rossdaly
 */
public class LoginFrame extends JFrame {
    
    private DetailsPanel detailsPanel;
    
    public LoginFrame(String title){
        super(title);
        
        setLayout(new BorderLayout());
        
//        final JTextArea textArea = new JTextArea();
        
        detailsPanel = new DetailsPanel();
        
        detailsPanel.addDetailListener(new DetailListener(){
            public void detailEvenOccured(DetailEvent event){
                String text = event.getText();
                //send this information to be varified
//                textArea.append(text);
                System.out.println(text);
            }
        });
        
        Container container = getContentPane();
//        container.add(textArea, BorderLayout.CENTER);
        container.add(detailsPanel, BorderLayout.WEST);
        
    }
}
