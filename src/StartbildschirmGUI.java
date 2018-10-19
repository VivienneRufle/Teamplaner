import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StartbildschirmGUI extends JFrame implements ActionListener {

	// Frames
	JFrame frameTermininformation = null;
	JFrame frameTerminhinzufuegen = null;

	// Panel
	JPanel centerPanel = new JPanel();
	JPanel southPanel = new JPanel();

	// Scroll
	JScrollPane scrollPane = new JScrollPane(centerPanel);

	// Button
	JButton add = new JButton("+");
	
	//Classen
	Daten d = new Daten();
	
	//Arrays
	ArrayList<Termin> termin;
	ArrayList<JButton> buttonArray = new ArrayList<JButton>();

	public StartbildschirmGUI() {
		// Layout
		setLayout(new BorderLayout());
		
		termin = d.generateTermin();

		// "grund" Panel
		add((scrollPane), BorderLayout.CENTER);
		add((southPanel), BorderLayout.SOUTH);

		// center Panel
		centerPanel.setLayout(new GridLayout(termin.size(), 1));
		
		//Termin Buttons
		for (Termin t : termin) {
			JButton button = new JButton(
					"<html><b>" + t.getTitel() + "</b><br>" + t.getDatum() + " - " + t.getStartZeit() + "<html>");

			centerPanel.add(button);
			button.setOpaque(true);
			button.addActionListener(this);
			
			//Hintergrund der Buttons
			if (t.getStatus() == 0) {
				button.setBackground(Color.GRAY);
				button.setToolTipText("<html><b>" + t.getTitel() + "</b><br>" + t.getBeschreibung() + "<br>" + t.getDatum()
				+ "<br>" + t.getStartZeit() + " - " + t.getEndZeit() + "<br>-");
			}else if (t.getStatus() == 1){
				button.setBackground(Color.GREEN);
				button.setToolTipText("<html><b>" + t.getTitel() + "</b><br>" + t.getBeschreibung() + "<br>" + t.getDatum()
				+ "<br>" + t.getStartZeit() + " - " + t.getEndZeit() + "<br>zugesagt");
			}else if (t.getStatus() == 2){
				button.setBackground(Color.RED);
				button.setToolTipText("<html><b>" + t.getTitel() + "</b><br>" + t.getBeschreibung() + "<br>" + t.getDatum()
				+ "<br>" + t.getStartZeit() + " - " + t.getEndZeit() + "<br>abgesagt");
			}
			buttonArray.add(button);
		}
		
		// south Panel
		southPanel.setLayout(new GridLayout(1, 1));
		
		// Button Hinzufügen
		southPanel.add(add);
		
		// Button aktivieren
		add.addActionListener(this);

		// View allgemein
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250, 350);
		setVisible(true);
		setTitle("Termin übersicht");
	}

	public static void main(String[] args) {
		// starter
		StartbildschirmGUI gui = new StartbildschirmGUI();
	}
	
	public void actionPerformed(ActionEvent e) {
		//Button hinzufügen -> View wechseln zu Hinzufügen
		//nicht Button hinzufügen -> View wechseln zu Info
		if (e.getSource() == add) {
			frameTerminhinzufuegen = new TerminHinzufuegenGUI();
			dispose();
		} else {
			for (int i = 0; i < buttonArray.size(); i++) {
				if (e.getSource() == buttonArray.get(i)) {
					frameTermininformation = new TermininformationGUI(this, termin.get(i));
					setVisible(false);
					break;
				}
			}
		}

	}
	
	//Methode Fenster anzeigen
	public void showWindow() {
		setVisible(true);
	}
 
}
