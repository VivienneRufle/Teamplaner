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

	// Buttons | Termineinträge
	JButton example1 = new JButton("<html><b>Termin1</b><br>19.09.2018 - 19:00Uhr<html>");
	JButton example2 = new JButton("<html><b>Termin2</b><br>19.09.2018 - 19:00Uhr<html>");
	JButton example3 = new JButton("<html><b>Termin3</b><br>19.09.2018 - 19:00Uhr<html>");
	JButton example4 = new JButton("<html><b>Termin4</b><br>19.09.2018 - 19:00Uhr<html>");
	JButton example5 = new JButton("<html><b>Termin5</b><br>19.09.2018 - 19:00Uhr<html>");

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
		// Button aktivieren | Termineinträge
		/*example1.addActionListener(this);
		example2.addActionListener(this);
		example3.addActionListener(this);
		example4.addActionListener(this);*/
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

		// Views
		StartbildschirmGUI startbildschirm = new StartbildschirmGUI();
		TerminHinzufuegenGUI terminhinzufuegen = new TerminHinzufuegenGUI();
		//TermininformationGUI termininformation = new TermininformationGUI();
		//TerminEditierenGUI termineditieren = new TerminEditierenGUI();

		// View wechsel startbildschirm -> termininformation|terminhinzufügen
		//startbildschirm.setframeTermininformation(termininformation);
		startbildschirm.setframeTerminhinzufuegen(terminhinzufuegen);

		// View wechsel terminhinzufügen -> startbildschirm
		terminhinzufuegen.setframeStartbildschirm(startbildschirm);

		// View wechsel termininformation -> startbildschirm|termineditieren
		//termininformation.setframeStartbildschirm(startbildschirm);
		//termininformation.setframeTermineditieren(termineditieren);

		// View wechsel termineditieren -> Termininfo
		//termineditieren.setframeTermininformation(termininformation);

		// aktuelles view sichtbar
		startbildschirm.setVisible(true);
	}

	// View wechsel zu termininfo
	public void setframeTermininformation(JFrame frameTermininformation) {
		this.frameTermininformation = frameTermininformation;
	}

	// View wechsel zu terminhinzufügen
	public void setframeTerminhinzufuegen(JFrame frameTerminhinzufuegen) {
		this.frameTerminhinzufuegen = frameTerminhinzufuegen;
	}

	public void actionPerformed(ActionEvent e) {
		/*// wenn Button -> view wechsel zu termininfo
		if (e.getSource() == example1) {
			frameTermininformation.setVisible(true);
			setVisible(false);
		}*/
		// wenn Button -> view wechsel zu termininfo oder hinzufügen
		if (e.getSource() == add) {
			frameTerminhinzufuegen.setVisible(true);
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
