import java.awt.Color;
import java.util.ArrayList;

public class Atom {

	private String symbol;
	private String charge;
	private Color color;
	private ArrayList<Atom> connected = new ArrayList<>();
	private ArrayList<Bond> bonds = new ArrayList<>();
	private int x;
	private int y;
	
	public Atom(String symbol, Color color, int x, int y) {
		
		this.symbol = symbol;
		this.color = color;
		charge = "0";
		this.x = x;
		this.y = y;
		
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public String geCharge() {
		return this.charge;
	}
	
	public void setCharge(String charge){
		//if charge is 0.5 or -0.5 this is considered partial pos or neg.
		this.charge = charge;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public ArrayList<Atom> getConnected() {
		return connected;
	}


	public ArrayList<Bond> getBonds() {
		return bonds;
	}


	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public int[] getPos() {
		int[] pos = {this.x, this.y};
		return pos;
	}

	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	
	
	
}
