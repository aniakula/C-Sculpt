import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LeftButtonPanel extends JPanel {
	 JButton bond = new JButton("Bond");
     JButton cycloH = new JButton("CycloHexane");
     JButton cycloP = new JButton("CycloPentane");
     JButton eraser = new JButton("Eraser");
     JButton sweep = new JButton("Sweep");
     DrawPanel dP;
	
	public LeftButtonPanel(DrawPanel dp){
		 
		 this.setLayout(new GridLayout(0, 1));
		 this.dP = dp;
		 
		 
		 bond.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					Bond b = new Bond(BondType.SINGLE, Color.black, 90, 90, 50, 50);
				
					dp.getBonds().add(b);
					dp.getAtoms().add(b.getEndAtom());
					dp.getAtoms().add(b.getStartAtom());
					dp.repaint();
				} 
	    	});
	    	
		 
		 
		 
		 
		 
		 
		 
		 this.add(bond);
	     this.add(cycloH);
	     this.add(cycloP);
	     this.add(eraser);
	     this.add(sweep);
		
	}
	
	
	
	
	

}
