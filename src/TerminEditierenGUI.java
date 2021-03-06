import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class TerminEditierenGUI extends JFrame implements ActionListener{
	//ÜbergabeVariabeln	
	String titel;
	String beschreibung;
	String datum;
	int startZeit;
	int endZeit;
	String infos;
	
	//Classen
	Daten d = new Daten();
	
	//Arrays
	ArrayList<JButton> example = new ArrayList<JButton>();

	TermininformationGUI infoB;
	StartbildschirmGUI startB;
		
	//Frames
	JFrame frameTermininformation = null;
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
	JButton buttonEditieren = new JButton("Editieren");
	
	public TerminEditierenGUI (){
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
		
		//south Panel
		southPanel.setLayout(new GridLayout(1, 2));
		//Buttons
		southPanel.add(buttonAbbrechen);
		southPanel.add(buttonEditieren);
		
		
		//Buttons
		buttonAbbrechen.addActionListener(this);
		buttonEditieren.addActionListener(this);
		
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
		setTitle("Termin editieren");
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		//Button abbrechen -> View wechesln zu Termininfo
		if (e.getSource() == buttonAbbrechen) {
			infoB.showWindow();
			dispose();
		}
		
		//Button hinzufügen -> View wechseln zu Termininfo
		if (e.getSource() == buttonEditieren) {
			infoB.showWindow();
			dispose();
		}
	}
	
}

