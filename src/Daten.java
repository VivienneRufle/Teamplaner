import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Daten {

	 public ArrayList<Termin> generateTermin() {
	        ArrayList<Termin> termin = new ArrayList<Termin>();
	        try {
	            FileInputStream fstream = new FileInputStream("Termine.txt");
	            DataInputStream in = new DataInputStream(fstream);
	            BufferedReader br = new BufferedReader(new InputStreamReader(in));
	            String strLine;
	            while ((strLine = br.readLine()) != null) {
	                String[] tokens = strLine.split("\t");
	                Termin newTermin = new Termin(Integer.parseInt(tokens[0]), tokens[1], tokens[2],
	                		tokens[3], tokens[4], tokens[5], Integer.parseInt(tokens[6]),Integer.parseInt(tokens[7]), tokens[8], Integer.parseInt(tokens[9]));
	                termin.add(newTermin);
	            }
	            in.close();
	            return termin;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return new ArrayList<Termin>();
	    }
}
