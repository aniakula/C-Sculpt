import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PTable extends JFrame {
	private JButton[][] table = new JButton[9][18];
	private String[] elemNames;
	private String[][] elemSym = new String[9][18];
	private int[][] atomicNum = new int[9][18];
	
	
	
	
	
	public PTable() {
		String elems = """
				H 
				He 
				Li 
				Be 
				B 
				C 
				N 
				O 
				F 
				Ne 
				Na 
				Mg 
				Al 
				Si 
				P 
				S 
				Cl 
				Ar 
				K 
				Ca 
				Sc 
				Ti 
				V 
				Cr 
				Mn 
				Fe 
				Co 
				Ni 
				Cu 
				Zn 
				Ga 
				Ge 
				As 
				Se 
				Br 
				Kr 
				Rb 
				Sr 
				Y 
				Zr 
				Nb 
				Mo 
				Tc 
				Ru 
				Rh 
				Pd 
				Ag 
				Cd 
				In 
				Sn 
				Sb 
				Te 
				I 
				Xe 
				Cs 
				Ba  
				Hf 
				Ta 
				W 
				Re 
				Os 
				Ir 
				Pt 
				Au 
				Hg 
				Tl 
				Pb 
				Bi 
				Po 
				At 
				Rn 
				Fr 
				Ra  
				Rf 
				Db 
				Sg 
				Bh 
				Hs 
				Mt 
				Ds 
				Rg 
				Cn 
				Nh 
				Fl 
				Mc 
				Lv 
				Ts 
				Og 
				La 
				Ce 
				Pr 
				Nd 
				Pm 
				Sm 
				Eu 
				Gd 
				Tb 
				Dy 
				Ho 
				Er 
				Tm 
				Yb 
				Lu
				Ac 
				Th 
				Pa 
				U 
				Np 
				Pu 
				Am 
				Cm 
				Bk 
				Cf 
				Es 
				Fm 
				Md 
				No 
				Lr
				""" ;
		elemNames = elems.split("\n");
		this.setSize(700, 400);
		this.setLayout(new GridLayout(9, 18));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int[] gaps = {16, 10, 10, 0, 0, 1, 1, 3, 3};
		int[] gapI = {1, 2, 2, 0, 0, 2, 2, 0, 0};
		int count = 0;
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table[0].length; j++) {
				if(j >= gapI[i] && j < (gaps[i] + gapI[i])) {
					JButton spacer = new JButton();
					spacer.setEnabled(false);
					table[i][j] = spacer;
				}
				else {
					JButton elem = new JButton(elemNames[count]);
					elem.setOpaque(true);
					
					if(j == 0 && i != 0)
						elem.setForeground(Color.yellow.darker());
					else if(j == 1)
						elem.setForeground(Color.lightGray);
					else if(j == 2) 
						elem.setForeground(Color.magenta);
					else if(j >= 3 && j <= 11 && i <= 6 && i >= 3)
						elem.setForeground(Color.orange);
					else if(j == 16 && i <= 6) 
						elem.setForeground(Color.green.darker());
					else if(j == 17 && i <= 6)
						elem.setForeground(Color.cyan.darker());
					else if(i == 7)
						elem.setForeground(Color.magenta);
						
					else if(i == 8) 
						elem.setForeground(Color.PINK);
					
					table[i][j] = elem;
					count++;
				}
				
				this.add(table[i][j]);
			}
		}
		
		
	}
	
	public static void main(String args[]) {
//		String elements =  """
//				1	H - Hydrogen, 
//				2	He - Helium,
//				3	Li - Lithium,
//				4	Be - Beryllium,
//				5	B - Boron,
//				6	C - Carbon,
//				7	N - Nitrogen,
//				8	O - Oxygen,
//				9	F - Fluorine,
//				10	Ne - Neon,
//				11	Na - Sodium,
//				12	Mg - Magnesium,
//				13	Al - Aluminum,
//				14	Si - Silicon,
//				15	P - Phosphorus,
//				16	S - Sulfur,
//				17	Cl - Chlorine,
//				18	Ar - Argon,
//				19	K - Potassium,
//				20	Ca - Calcium,
//				21	Sc - Scandium,
//				22	Ti - Titanium,
//				23	V - Vanadium,
//				24	Cr - Chromium,
//				25	Mn - Manganese,
//				26	Fe - Iron,
//				27	Co - Cobalt,
//				28	Ni - Nickel,
//				29	Cu - Copper,
//				30	Zn - Zinc,
//				31	Ga - Gallium,
//				32	Ge - Germanium,
//				33	As - Arsenic,
//				34	Se - Selenium,
//				35	Br - Bromine,
//				36	Kr - Krypton,
//				38	Rb - Rubidium,
//				39	Sr - Strontium,
//				40	Y - Yttrium,
//				41	Zr - Zirconium,
//				42	Nb - Niobium,
//				43	Mo - Molybdenum,
//				44	Tc - Technetium,
//				45	Ru - Ruthenium,
//				46	Rh - Rhodium, 
//				47	Pd - Palladium,
//				48	Ag - Silver,
//				49	Cd - Cadmium,
//				50	In - Indium,
//				51	Sn - Tin,
//				52	Sb - Antimony,
//				53	Te - Tellurium,
//				54	I - Iodine,
//				55	Xe - Xenon,
//				56	Cs - Cesium,
//				57	Ba - Barium,
//				58	La - Lanthanum,
//				59	Ce - Cerium,
//				60	Pr - Praseodymium,
//				61	Nd - Neodymium,
//				62	Pm - Promethium,
//				63	Sm - Samarium,
//				64	Eu - Europium,
//				65	Gd - Gadolinium,
//				66	Tb - Terbium,
//				67	Dy - Dysprosium,
//				68	Ho - Holmium,
//				69	Er - Erbium,
//				70	Tm - Thulium,
//				71	Yb - Ytterbium,
//				73	Lu - Lutetium,
//				74	Hf - Hafnium,
//				75	Ta - Tantalum,
//				76	W - Tungsten,
//				77	Re - Rhenium,
//				78	Os - Osmium,
//				79	Ir - Iridium,
//				80	Pt - Platinum,
//				81	Au - Gold,
//				82	Hg - Mercury,
//				83	Tl - Thallium,
//				84	Pb - Lead,
//				85	Bi - Bismuth,
//				86	Po - Polonium,
//				87	At - Astatine,
//				88	Rn - Radon,
//				89	Fr - Francium,
//				90	Ra - Radium,
//				91	Ac - Actinium,
//				92	Th - Thorium,
//				93	Pa - Protactinium,
//				94	U - Uranium,
//				95	Np - Neptunium,
//				96	Pu - Plutonium,
//				97	Am - Americium,
//				98	Cm - Curium,
//				99	Bk - Berkelium,
//			 100     Cf - Californium,
//				101	Es - Einsteinium,
//				102	Fm - Fermium,
//				103	Md - Mendelevium,
//				104 	No - Nobelium,
//				105	Lr - Lawrencium,
//				106 	Rf - Rutherfordium,
//			 108 	Db - Dubnium,
//				109 	Sg - Seaborgium,
//				110	Bh - Bohrium,
//				111	Hs - Hassium,
//				112	Mt - Meitnerium,
//				113	Ds - Darmstadtium,
//				114	Rg - Roentgenium,
//				115 	Cn - Copernicium,
//				116 	Nh - Nihonium,
//				117 	Fl - Flerovium,
//				118 	Mc - Moscovium,
//				119 	Lv - Livermorium,
//				120 	Ts - Tennessine,
//				121 	Og - Oganesson,
//				""" ;
		


		PTable p = new PTable();
		p.setVisible(true);
				
				
		

	}
	

}
