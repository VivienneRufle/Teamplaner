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
	
	Daten d = new Daten();
	ArrayList<Termin> termin;
	ArrayList<JButton> example = new ArrayList<JButton>();

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
		int i = 0;
		for (Termin t : termin) {
			JButton button = new JButton(
					"<html><b>" + t.getTitel() + "</b><br>" + t.getDatum() + " - " + t.getStartZeit() + "<html>");

			centerPanel.add(button);
			button.setToolTipText("<html><b>" + t.getTitel() + "</b><br>" + t.getBeschreibung() + "<br>" + t.getDatum()
					+ "<br>" + t.getStartZeit() + " - " + t.getEndZeit() + "<br>zugesagt");
			button.setOpaque(true);
			button.setBackground(Color.GRAY);
			button.addActionListener(this);
			i++;
			example.add(button);
		}

		// south Panel
		southPanel.setLayout(new GridLayout(1, 1));
		// Button
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
		// wenn Button add -> view wechsel zu hinzufügen
		//wenn nicht Button add -> view zu info wechseln
		if (e.getSource() == add) {
			frameTerminhinzufuegen = new TerminHinzufuegenGUI();
			//frameTerminhinzufuegen.setVisible(true);
			setVisible(false);
		} else {
			for (int i = 0; i < example.size(); i++) {
				if (e.getSource() == example.get(i)) {
					//frameTermininformation.setVisible(true);
					frameTermininformation = new TermininformationGUI(this, termin.get(i));
					setVisible(false);
					break;
				}
			}
		}

	}
	public void showWindow() {
		setVisible(true);
	}
 
}
