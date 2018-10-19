import java.awt.Color;
import java.io.*;
import java.util.*; 
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Update {
	
	JFrame frameStartbildschirm = null;
	ArrayList<Termin> termin;
	ArrayList neu = new ArrayList();
	Daten d = new Daten();
	int i = 0;
	String strLine;

	
	public Update(String[] newTermin) {
		strLine.split("\t");
		for (Termin t : d.generateTermin()) {
			neu.add(t.getId());
			neu.add(t.getTitel());
			neu.add(t.getBeschreibung());
			neu.add(t.getDatum());
			neu.add(t.getStartZeit());
			neu.add(t.getEndZeit());
			neu.add(t.getZusagen());
			neu.add(t.getAbsagen());
			neu.add(t.getInfo());
			neu.add(t.getStatus());
			i++;
			neu.add(strLine);
		}
		
		System.out.println(neu);
		
		neu.add(i);
		neu.add(newTermin[1]);
		neu.add(newTermin[2]);
		neu.add(newTermin[3]);
		neu.add(newTermin[4]);
		neu.add(newTermin[5]);
		neu.add(newTermin[6]);
		neu.add(newTermin[7]);
		neu.add(newTermin[8]);
		neu.add(newTermin[9]);
		
		listInDatei(neu, new File("Termine.txt")); 
	}
	
	
	 private static void listInDatei(List list, File datei) { 
	        PrintWriter printWriter = null; 
	        try { 
	            printWriter = new PrintWriter(new FileWriter(datei)); 
	            Iterator iter = list.iterator(); 
	            while(iter.hasNext() ) { 
	                Object o = iter.next(); 
	                printWriter.println(o); 
	            } 
	        } catch (IOException e) { 
	            e.printStackTrace(); 
	        } finally { 
	            if(printWriter != null) printWriter.close(); 
	        } 
	    } 
}
