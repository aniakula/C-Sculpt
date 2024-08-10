import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ChemistryModelingTool extends JFrame {
    
    private LeftButtonPanel buttonPanel;
    private AtomAdderPanel atomPanel;
    private DrawPanel drawPanel;
    private JMenuBar menu = new JMenuBar();
   

    public ChemistryModelingTool() {
    	
        setTitle("C Sculpt");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        atomPanel = new AtomAdderPanel();
        drawPanel = new DrawPanel();
        buttonPanel = new LeftButtonPanel(drawPanel);
        
        //Make darkMode MenuItem and add functionality:
        JMenuItem darkMode = new JMenuItem("Dark Mode");
    	darkMode.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				if(darkMode.getText().equals("Dark Mode")) {
					darkMode.setText("Light Mode");
					
				}
				
				else {
					darkMode.setText("Dark Mode");
					
				}
			} 
    	});
    	
    	
    	menu.add(Box.createHorizontalGlue());
    	menu.add(darkMode);
    	
    	// added menu to Frame
        add(buttonPanel, BorderLayout.WEST);
        add(drawPanel, BorderLayout.CENTER);
        add(atomPanel, BorderLayout.SOUTH);
        this.setJMenuBar(menu);
        
        
        
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChemistryModelingTool frame = new ChemistryModelingTool();
            frame.setVisible(true);
        });
    }
}
