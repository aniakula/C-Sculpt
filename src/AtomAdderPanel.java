import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AtomAdderPanel extends JPanel {
	
	JButton H = new JButton("H");
    JButton C = new JButton("C");
    JButton O = new JButton("O");
    JButton N = new JButton("N");
    JButton Cl = new JButton("Cl");
    JButton S = new JButton("S");
    JButton P = new JButton("P");
    JButton pTable = new JButton("Periodic Table");
    PTable p = null;
    
    public AtomAdderPanel(){
    	this.setLayout(new GridLayout(2, 0));
    	H.setOpaque(true);
    	C.setOpaque(true);
    	O.setOpaque(true);
    	N.setOpaque(true);
    	Cl.setOpaque(true);
    	S.setOpaque(true);
    	P.setOpaque(true);
    	
    	H.setForeground(Color.LIGHT_GRAY);
    	C.setForeground(Color.BLACK);
    	O.setForeground(Color.RED);
    	N.setForeground(Color.BLUE);
    	Cl.setForeground(Color.GREEN);
    	S.setForeground(Color.yellow.darker());
    	P.setForeground(Color.ORANGE);
    	
    	
    	pTable.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				if(p == null) {
				p = new PTable();
				p.setVisible(true);
				}
				
				else {
				p.dispose();
				p = new PTable();
				p.setVisible(true);
				}
			} 
    	});
    	
    	
    	
    	
    	
    	
    	this.add(H);
    	this.add(C);
    	this.add(O);
    	this.add(N);
    	this.add(Cl);
    	this.add(S);
    	this.add(P);
    	this.add(pTable);
    	
    	
    }

}
