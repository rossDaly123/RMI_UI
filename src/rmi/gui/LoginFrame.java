package rmi.gui;

import java.awt.*;
import javax.swing.*;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = -2485840487267507963L;
	private DetailsPanel detailsPanel;
    
    public LoginFrame(String title){
        super(title);
        
        setLayout(new BorderLayout());
        
        detailsPanel = new DetailsPanel();
        
        detailsPanel.addDetailListener(new DetailListener(){
            public void detailEvenOccured(DetailEvent event){
                String text = event.getText();
                System.out.println(text);
            }
        });
        
        Container container = getContentPane();
        container.add(detailsPanel, BorderLayout.WEST);
        
    }
}
