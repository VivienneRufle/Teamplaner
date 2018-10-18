import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TermininformationGUI extends JFrame implements ActionListener{
	//ÜbergabeVariabeln
	int zusagen;
	String zusageString;
	int absage;
	String absageString;
	int absagecounter = 0;
	
	//Verknüpfungen
	Daten d = new Daten();
	ArrayList<Termin> termin;
	ArrayList<JButton> example = new ArrayList<JButton>();
	StartbildschirmGUI startB;
	
	//frames
	JFrame frameStartbildschirm = null;
	JFrame frameTermineditieren = null;
	
	//Panel
	JPanel centerPanel = new JPanel();
	JPanel southPanel = new JPanel();
	JPanel southPanelup = new JPanel();
	JPanel southPaneldown = new JPanel();
	//Titel
	JLabel labelTitel = new JLabel("");
	JLabel labelTitelLeer = new JLabel("");
	//Beschreibung
	JLabel labelBeschreibung = new JLabel("");
	JLabel labelBeschreibungLeer = new JLabel("");
	//Datum
	JLabel labelDatumText = new JLabel("Datum:");
	JLabel labelDatum = new JLabel("");
	//StartZeit
	JLabel labelStartZeitText = new JLabel ("Beginn:");
	JLabel labelStartZeit = new JLabel("");
	//EndZeit
	JLabel labelEndzeitText = new JLabel("Ende:");
	JLabel labelEndzeit = new JLabel("");
	//Zusage
	JLabel labelZusagenText = new JLabel("Zusagen:");
	JLabel labelZusgae = new JLabel("");
	//Absage
	JLabel labelAbsagenText = new JLabel("Absagen:");
	JLabel labelAbsage = new JLabel("");
	//Infos
	JLabel labelInfos = new JLabel("");
	//Button
	JButton buttonzuruck = new JButton("Zurück");
	JButton buttoneditieren = new JButton ("editieren");
	JButton buttonloschen = new JButton ("löschen");
	JButton buttonZusagen = new JButton("Zusagen");
	JButton buttonAbsagen = new JButton("Absagen");

	//public TermininformationGUI() {
	public TermininformationGUI(StartbildschirmGUI startB, Termin termin) {
		
		//layout
		setLayout(new BorderLayout());
		
		//verknüpfen Startbildschirm
		this.startB = startB;
		
		//termindaten übergeben
		labelTitel.setText(termin.getTitel());
		labelBeschreibung.setText(termin.getBeschreibung());
		labelDatum.setText(termin.getDatum());
		labelStartZeit.setText(termin.getStartZeit());
		labelEndzeit.setText(termin.getEndZeit());
		labelZusgae.setText(Integer.toString(termin.getZusagen()));
		labelAbsage.setText(Integer.toString(termin.getAbsagen()));
		labelInfos.setText(termin.getInfo());
		
		//"grund" layout
		add((centerPanel), BorderLayout.CENTER);
		add((southPanel), BorderLayout.SOUTH);		
		
		//Center Panel Labels setzen
		centerPanel.setLayout(new GridLayout(8, 2));
		//titel
		centerPanel.add(labelTitel);
		centerPanel.add(labelTitelLeer);
		//beschreibung
		centerPanel.add(labelBeschreibung);
		centerPanel.add(labelBeschreibungLeer);
		//datum
		centerPanel.add(labelDatumText);
		centerPanel.add(labelDatum);
		//start zeit
		centerPanel.add(labelStartZeitText);
		centerPanel.add(labelStartZeit);
		//endzeit
		centerPanel.add(labelEndzeitText);
		centerPanel.add(labelEndzeit);
		//zusagen
		centerPanel.add(labelZusagenText);
		centerPanel.add(labelZusgae);
		//absagen
		centerPanel.add(labelAbsagenText);
		centerPanel.add(labelAbsage);
		//infos
		centerPanel.add(labelInfos);

		//SouthPanel Panel setzen
		southPanel.setLayout(new GridLayout(2, 1));
		southPanel.add(southPanelup);
		southPanel.add(southPaneldown);
		
		//southPanelUp Buttons setzen
		southPanelup.setLayout(new GridLayout(1, 3));
		southPanelup.add(buttonzuruck);
		southPanelup.add(buttoneditieren);
		southPanelup.add(buttonloschen);
		
		//SouthPanelDown Buttons setzen
		southPaneldown.setLayout(new GridLayout(1, 2));
		southPaneldown.add(buttonZusagen);
		southPaneldown.add(buttonAbsagen);
		
		//Button aktivieren
		buttonzuruck.addActionListener(this);
		buttoneditieren.addActionListener(this);
		buttonloschen.addActionListener(this);
		buttonZusagen.addActionListener(this);
		buttonAbsagen.addActionListener(this);
		
		//view allgemein
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250, 350);
		setVisible(true);
		setTitle("Termininformation");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//wenn button -> view wechsel zu startbildschirm
		if (e.getSource() == buttonzuruck) {
			startB.showWindow();
			dispose();
		}
		//wenn Button -> view wechsel zu startbildschirm
		if (e.getSource() == buttonloschen) {
			startB.showWindow();
			dispose();
		}
		//wenn button -> view wechsel zu termineditieren
		if (e.getSource() == buttoneditieren) {
			frameTermineditieren = new TerminEditierenGUI();
		}
		
		//wenn button -> zu termin zusagen
		if (e.getSource() == buttonZusagen) {
			if (absagecounter == 0 ) {
				//anzahl zusagen hochsetzen
				zusagen = Integer.parseInt(labelZusgae.getText());
				zusagen++;
				zusageString = Integer.toString(zusagen);
				labelZusgae.setText(zusageString);
				//Button aktivieren/deaktivieren
				buttonAbsagen.setEnabled(true);
				buttonZusagen.setEnabled(false);
				//Counter
				absagecounter++;
			}else if (absagecounter == 1){
				//anzahl zusagen hochsetzen
				zusagen = Integer.parseInt(labelZusgae.getText());
				zusagen++;
				zusageString = Integer.toString(zusagen);
				labelZusgae.setText(zusageString);
				//anzahl absagen runter setzen
				absage = Integer.parseInt(labelAbsage.getText());
				absage = absage - 1;
				absageString = Integer.toString(absage);
				labelAbsage.setText(absageString);
				//Button aktivieren/deaktivieren
				buttonAbsagen.setEnabled(true);
				buttonZusagen.setEnabled(false);
			}else {
				
			}
			
		}
		
		//wenn button -> termin absagen
		if (e.getSource() == buttonAbsagen) {
			if (absagecounter == 0 ) {
				//Anzahl absagen hochsetzen
				absage = Integer.parseInt(labelAbsage.getText());
				absage++;
				absageString = Integer.toString(absage);
				labelAbsage.setText(absageString);
				//Button aktivieren/deaktivieren
				buttonAbsagen.setEnabled(false);
				buttonZusagen.setEnabled(true);
				//Counter
				absagecounter++;
			}else if (absagecounter == 1){
				//Anzahl absagen hochsetzen
				absage = Integer.parseInt(labelAbsage.getText());
				absage++;
				absageString = Integer.toString(absage);
				labelAbsage.setText(absageString);
				//Anzahl zusagen runter setzen
				zusagen = Integer.parseInt(labelZusgae.getText());
				zusagen = zusagen - 1;
				zusageString = Integer.toString(zusagen);
				labelZusgae.setText(zusageString);
				//Button aktivieren/deaktivieren
				buttonAbsagen.setEnabled(false);
				buttonZusagen.setEnabled(true);
			}else {
				
			}
		}
	}

	public void showWindow() {
		setVisible(true);
	}
}
