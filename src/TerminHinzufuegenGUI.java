import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;



public class TerminHinzufuegenGUI extends JFrame implements ActionListener{
	//ÜbergabeVariabeln
	String startZeit;
	String endZeit;
	String id;
	
	//Arrays
	String[] newTermin = new String[10];
	ArrayList<Termin> termin;
	
	//Classen
	Daten d = new Daten();
	Update u = new Update(newTermin);
	
	StartbildschirmGUI startB;
	
	//Frames
	JFrame frameStartbildschirm = null;
	
	//JPanel
	JPanel centerPanel = new JPanel();
	JPanel southPanel = new JPanel();
	//Titel
	JLabel labelTitel = new JLabel("Titel:");
	JTextField textTitel = new JTextField();
	//Beschreibung
	JLabel labelBeschreibung = new JLabel("Beschreibung:");
	JTextField textBeschreibung = new JTextField();
	//Datum
	JLabel labelDatum = new JLabel("Datum:");
	JTextField textDatum = new JTextField();
	//Start Zeit
	String[] stringStartZeit = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
	JComboBox comboBoxStartZeit = new JComboBox(stringStartZeit);
	JLabel labelStartZeit = new JLabel("Start Zeit:");
	JTextField textStartZeit = new JTextField();
	//Endzeit
	String[] stringEndzeit = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
	JComboBox comboBoxEndzeit = new JComboBox(stringStartZeit);
	JLabel labelEndzeit = new JLabel("Endzet:");
	JTextField textEndzeit = new JTextField();
	//Infos
	JLabel labelInfos = new JLabel("Informationen:");
	JTextField textInfos = new JTextField();
	//Buttons
	JButton buttonAbbrechen = new JButton("Abbrechen");
	JButton buttonHinzufuegen = new JButton("Hinzufügen");
	
	public TerminHinzufuegenGUI() {
		
		//layout
		setLayout(new BorderLayout());
		
		//"grund" Panel
		add((centerPanel), BorderLayout.CENTER);
		add((southPanel), BorderLayout.SOUTH);
		
		//center Panel
		centerPanel.setLayout(new GridLayout(6, 2));
		//Titel
		centerPanel.add(labelTitel);
		centerPanel.add(textTitel);
		//Beschreibung
		centerPanel.add(labelBeschreibung);
		centerPanel.add(textBeschreibung);
		//Datum
		centerPanel.add(labelDatum);
		centerPanel.add(textDatum);
		//Start Zeit
		centerPanel.add(labelStartZeit);
		centerPanel.add(comboBoxStartZeit);
		//Endzeit
		centerPanel.add(labelEndzeit);
		centerPanel.add(comboBoxEndzeit);
		//Infos
		centerPanel.add(labelInfos);
		centerPanel.add(textInfos);

		//southPanel
		southPanel.setLayout(new GridLayout(1, 2));
		//Buttons
		southPanel.add(buttonAbbrechen);
		southPanel.add(buttonHinzufuegen);
		
		//Buttons aktivieren
		buttonAbbrechen.addActionListener(this);
		buttonHinzufuegen.addActionListener(this);
		
		//comboBox Start Zeit
		comboBoxStartZeit.setSelectedIndex(17);
		comboBoxStartZeit.addActionListener(this);
		//comboBox Endzeit
		comboBoxEndzeit.setSelectedIndex(20);
		comboBoxEndzeit.addActionListener(this);
		
		//View allgemein
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250, 350);
		setVisible(true);
		setTitle("Termin hinzufügen");
		
		//Array Daten in String speichern
		startZeit = Integer.toString(comboBoxStartZeit.getSelectedIndex());
		endZeit = Integer.toString(comboBoxEndzeit.getSelectedIndex());
		
		termin = d.generateTermin();
		id = Integer.toString(termin.size());
		
		//Array mit neuen Daten füllen
		newTermin[0] = id;
		newTermin[1] = textTitel.getText();
		newTermin[2] = textBeschreibung.getText();
		newTermin[3] = textDatum.getText();
		newTermin[4] = startZeit;
		newTermin[5] = endZeit;
		newTermin[6] = "0";
		newTermin[7] = "0";
		newTermin[8] = textInfos.getText();
		newTermin[9] = "0";
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Button abbrechen -> View wechseln zum Startbildschirm
		if (e.getSource() == buttonAbbrechen) {
			startB.showWindow();
			//frameStartbildschirm = new StartbildschirmGUI();
			dispose();
		}
		
		//Button hinzufügen -> View wechseln zum Startbildschirm
		if (e.getSource() == buttonHinzufuegen) {
			u = new Update(newTermin);
			startB.showWindow();
			//frameStartbildschirm = new StartbildschirmGUI();
			dispose();
		}
		
	}
}
