import java.awt.Color;
import java.awt.geom.Line2D;

enum BondType{
	SINGLE,
	DOUBLE,
	TRIPLE,
	DASHED,
	HASHED,
	BOLD,
	HASHEDWEDGE,
	SOLIDWEDGE,
	HOLLOWWEDGE,
	WAVY
}

public class Bond {
	
	
	private BondType type = BondType.SINGLE;
	private Color color = Color.black;
	private int length;
	//start and end coordinates of line
	private int stX;
	private int stY;
	private int endX;
	private int endY;
	private Atom startAtom;
	private Atom endAtom;
	private int preset = 1;
	
	public Bond(BondType type, Color color, int stX, int stY, int endX, int endY) {
		this.type = type;
		this.setColor(color);
		this.setStX(stX);
		this.setStY(stY);
		this.setEndX(endX);
		this.setEndY(endY);
		startAtom = new Atom("C", Color.black, stX, stY);
		endAtom = new Atom("C", Color.black, endX, endY);
	}
	
	public Bond(BondType type, Color color, int stX, int stY, int endX, int endY, Atom startAtom) {
		this.type = type;
		this.setColor(color);
		this.setStX(stX);
		this.setStY(stY);
		this.setEndX(endX);
		this.setEndY(endY);
		this.startAtom = startAtom;
		endAtom = new Atom("C", Color.black, endX, endY);
	}
	
	public Bond(BondType type, Color color, int stX, int stY, int endX, int endY, Atom startAtom, Atom endAtom) {
		this.type = type;
		this.setColor(color);
		this.setStX(stX);
		this.setStY(stY);
		this.setEndX(endX);
		this.setEndY(endY);
		this.startAtom = startAtom;
		this.endAtom = endAtom;
	}
	
	 public boolean isInsideLine(int x, int y) {
	        int startX = this.startAtom.getX() + 25;
	        int startY = this.startAtom.getY() + 25;
	        int endX = this.endAtom.getX() + 25;
	        int endY = this.endAtom.getY() + 25;

	        Line2D lineSegment = new Line2D.Double(startX, startY, endX, endY);
	        double distance = lineSegment.ptSegDist(x, y);

	        return distance <= 20; // Adjust the range as needed
	    }
	 
	 public int Dist(int x1, int y1, int x2, int y2) {
	        int deltaX = x2 - x1;
	        int deltaY = y2 - y1;
	        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	        return (int)distance;
	    }

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}

	public int getStY() {
		return stY;
	}

	public void setStY(int stY) {
		this.stY = stY;
	}

	public int getStX() {
		return stX;
	}

	public void setStX(int stX) {
		this.stX = stX;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
	public Atom getEndAtom() {
		return endAtom;
	}
	
	public Atom getStartAtom() {
		return startAtom;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getPreset() {
		return preset;
	}

	public void setPreset(int preset) {
		this.preset = preset;
	}
	
	

}
