import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	
	private ArrayList<Atom> atomList = new ArrayList<Atom>();
	private ArrayList<Bond> bondList = new ArrayList<Bond>();
	private Point dragOffset;
	private Atom selectedAtom;
	private Bond selectedBond;
	
	public DrawPanel(){
		selectedAtom = null;
		selectedBond = null;
		dragOffset = null;
		
	
        
		this.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	            selectAtom(e.getX(), e.getY());
	            selectBond(e.getX(), e.getY());
	        }

	        public void mouseReleased(MouseEvent e) {
	            selectedAtom = null;
	            selectedBond = null;
	        }

	        public void mouseClicked(MouseEvent e) {
	            selectAtom(e.getX(), e.getY());
	            selectBond(e.getX(), e.getY());
	            if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON2) {
	                //menu.setVisible(false);
	                //menuLine.setVisible(false);
	            }

	            if (selectedAtom != null) {
	                if (e.getButton() == MouseEvent.BUTTON3) {
	                    //menu.show(null, selectedAtom.getX(), selectedAtom.getY());
	                }
	            }
	            else if(selectedBond != null) {
	            	//menuLine.show(null, (selectedBond.getEndX() + selectedBond.getStX())/2, (selectedBond.getEndY() + selectedBond.getStY())/2 );
	            }
	        }
	    });
		
	     //allows for dragging of atoms
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (selectedAtom != null) {
                    int newX = e.getX() - dragOffset.x;
                    int newY = e.getY() - dragOffset.y;
                    selectedAtom.setX(newX);
                    selectedAtom.setY(newY);
                   
                    repaint();
                    
                  for(Bond bond: bondList)
                  {
                	  if(bond.getStartAtom().equals(selectedAtom)||bond.getEndAtom().equals(selectedAtom))
                	  {
                		  int p1 = bond.Dist(bond.getStartAtom().getX() + 4, bond.getStartAtom().getY() + 4, bond.getEndAtom().getX() + 16, bond.getEndAtom().getY() + 16);
                		  int p2 = bond.Dist(bond.getStartAtom().getX(), bond.getStartAtom().getY() + 10, bond.getEndAtom().getX() + 20, bond.getEndAtom().getY() + 10);
                		 int p3 = bond.Dist(bond.getStartAtom().getX() + 4, bond.getStartAtom().getY() + 16, bond.getEndAtom().getX() + 16, bond.getEndAtom().getY() + 4);
                		  int p4 = bond.Dist(bond.getStartAtom().getX() + 10, bond.getStartAtom().getY() + 20, bond.getEndAtom().getX() + 10, bond.getEndAtom().getY());
                		  int p5 = bond.Dist(bond.getStartAtom().getX() + 16, bond.getStartAtom().getY() + 16, bond.getEndAtom().getX() + 4, bond.getEndAtom().getY() + 4);
                		  int p6 = bond.Dist(bond.getStartAtom().getX() + 20, bond.getStartAtom().getY() + 10, bond.getEndAtom().getX() + 0, bond.getEndAtom().getY() + 10);
                		 int p7 = bond.Dist(bond.getStartAtom().getX() + 16, bond.getStartAtom().getY() + 4, bond.getEndAtom().getX() + 4, bond.getEndAtom().getY() + 16);
                		  int p8 = bond.Dist(bond.getStartAtom().getX() + 10, bond.getStartAtom().getY(), bond.getEndAtom().getX() + 10, bond.getEndAtom().getY() + 20);
                		  int dist = bond.Dist(bond.getStartAtom().getX(), bond.getStartAtom().getY(), bond.getEndAtom().getX(), bond.getEndAtom().getY());
                		  
                		  int pf = Math.min(Math.min(Math.min(Math.min(dist, p1), Math.min(p2, p3)),Math.min(Math.min(p4, p5), Math.min(p6, p4))), p8);
                		 
                		  if(pf == p1)
                			  bond.setPreset(1); 
                		  else if( pf == p2)
                			  bond.setPreset(2);
                		  else if( pf == p3)
                			  bond.setPreset(3);
                		  else if( pf == p4)
                			  bond.setPreset(4);
                		  else if( pf == p5)
                			  bond.setPreset(5);
                		  else if( pf == p6)
                			  bond.setPreset(6);			  
                		  else if( pf == p7)
                			  bond.setPreset(4);				  
                		  else if(pf == p8)
                			  bond.setPreset(8);
                			  
                	  }
                	  
                  }
                }
            }
        });
		

	}
	
	public void addAtom(String symbol, Color c, int x, int y) {
		Atom create = new Atom(symbol, c, x, y);
		atomList.add(create);
	}
	
	public void addBond(BondType type, Color color, int stX, int stY, int endX, int endY) {
		Bond create = new Bond(type, color, stX, stY, endX, endY);
		bondList.add(create);
	}
	
	public void addBond(BondType type, Color color, int stX, int stY, int endX, int endY, Atom startA) {
		Bond create = new Bond(type, color, stX, stY, endX, endY, startA);
		bondList.add(create);
		
	}
	
	public void addBond(BondType type, Color color, int stX, int stY, int endX, int endY, Atom startA, Atom endA) {
		Bond create = new Bond(type, color, stX, stY, endX, endY, startA, endA);
		bondList.add(create);
	}
	
	public Atom getA() {
		return selectedAtom;
	}
	
	public Bond getB() {
		return selectedBond;
	}
	
	public ArrayList<Bond> getBonds(){
		return bondList;
	}
	
	public ArrayList<Atom> getAtoms(){
		return atomList;
	}
	
	public void selectAtom(int x, int y) {
		for (Atom atom : atomList) {
            int atomX = atom.getX();
            int atomY = atom.getY();
            if (x >= atomX && x <= atomX + 20 && y >= atomY && y <= atomY + 20) {
                selectedAtom = atom;
                dragOffset = new Point(x - atomX, y - atomY);
                break;
            } 
            else {
                selectedAtom = null;
            }
        }
	}
	
	public void selectBond(int x, int y) {
		 // Check if a bond is selected
        for (Bond bond : bondList) {
            if (bond.isInsideLine(x, y)) {
                selectedBond = bond;
                break;
            } 
            else {
                selectedBond = null;
            }
        }
	}
	
	 //paint function called whenever workspace is updated using the repaint() method
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
       
     
        for (Atom atom : atomList) 
        {
//        	if(atom.getX() >= 1485)
//        	{
//        		atom.setX(1485);
//        	}
//        	else if(atom.getX() <= 0)
//        	{
//        		atom.setX(0);
//        	}
//        	
//        	if(atom.getY() >= 420)
//        	{
//        		atom.setY(420);
//        	}
//        	else if(atom.getY() <= 0)
//        	{
//        		atom.setY(0);
//        	}
        	
        				
        	//drawing the shape of the atom
            int x = atom.getX();
            int y = atom.getY();
            g2.setColor(atom.getColor());
            //g2.fillOval(x, y, 20, 20);
            g2.setColor(Color.BLACK);
           // g2.drawOval(x, y, 20, 20);
            
            //displaying the correct value based on the display type of the atoms
//            switch(atom.getDisplay()){
//            case "names" :
            	g2.drawString(atom.getSymbol(), x + 5, y + 15);
//            	break;
//            case "values":
//            	g2.drawString(atom.getValue(), x + 24, y + 30);
//            	break;
//            case "levels":
//            	g2.drawString(atom.getLevel()+"", x + 24, y + 30);
//            	break;
            	
            	
            }
        
       //drawing all the bonds with provided color and thickness, and setting proper orientation preset
        for (Bond bond : bondList){
        	g2.setColor(bond.getColor());
        	int startX = 0;
    		int startY = 0;
    		int endX = 0;
    		int endY = 0;
        	switch(bond.getPreset()) {
        	
        	case 1:
        	    startX = bond.getStartAtom().getX() + 4;
        	    startY = bond.getStartAtom().getY() + 4;
        		endX = bond.getEndAtom().getX() + 16;
        		endY = bond.getEndAtom().getY() + 16;
        		break;
        		
        	case 2:
        		startX = bond.getStartAtom().getX();
        	    startY = bond.getStartAtom().getY() + 10;
        		endX = bond.getEndAtom().getX() + 20;
        		endY = bond.getEndAtom().getY() + 10;
        		break;
        		
        	case 3:
        		startX = bond.getStartAtom().getX() + 4;
        	    startY = bond.getStartAtom().getY() + 16;
        		endX = bond.getEndAtom().getX() + 16;
        		endY = bond.getEndAtom().getY() + 4;
        		break;
        		
        	case 4:
        		startX = bond.getStartAtom().getX() + 10;
        		startY = bond.getStartAtom().getY() + 20;
        		endX = bond.getEndAtom().getX() + 10;
        		endY = bond.getEndAtom().getY();
        		break;
        		
        	case 5:
        		startX = bond.getStartAtom().getX() + 16;
        	    startY = bond.getStartAtom().getY() + 16;
        		endX = bond.getEndAtom().getX() + 4;
        		endY = bond.getEndAtom().getY() + 4;
        		break;
        		
        	case 6:
        		startX = bond.getStartAtom().getX() + 20;
        	    startY = bond.getStartAtom().getY() + 10;
        		endX = bond.getEndAtom().getX();
        		endY = bond.getEndAtom().getY() + 10;
        		break;
        		
        	case 7:
        		startX = bond.getStartAtom().getX() + 16;
        	    startY = bond.getStartAtom().getY() + 4;
        		endX = bond.getEndAtom().getX() + 4;
        		endY = bond.getEndAtom().getY() + 16;
        		break;
        		
        	case 8:
        		startX = bond.getStartAtom().getX() + 10;
        	    startY = bond.getStartAtom().getY();
        		endX = bond.getEndAtom().getX() + 10;
        		endY = bond.getEndAtom().getY() + 20;
        		break;
            
        	}
            // Draw a bond between atoms
            //g2.setStroke(new BasicStroke(bond.getThick()));
            g2.drawLine(startX, startY, endX, endY);
        }
        
    }
    
    
	
	

}
