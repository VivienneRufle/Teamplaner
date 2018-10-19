
public class Termin {
	private int id;
	private String titel;
	private String beschreibung;
	private String datum;
	private String startZeit;
	private String endZeit;
	private int zusagen;
	private int absagen;
	private String info;
	private int status;

	//Daten aus Array in Variablen hinterlegen
	public Termin(int id, String titel, String beschreibung, String datum, String startZeit, String endZeit,
			int zusagen, int absagen, String info, int status) {
	
		this.id = id;
		this.titel = titel;
		this.beschreibung = beschreibung;
		this.datum = datum;
		this.startZeit = startZeit;
		this.endZeit = endZeit;
		this.zusagen = zusagen;
		this.absagen = absagen;
		this.info = info;
		this.status = status;
		
	}
	
	public void print() {
		System.out.println(""+getId());
		System.out.println(""+getTitel());
		System.out.println(""+getBeschreibung());
		System.out.println(""+getDatum());
		System.out.println(""+getStartZeit());
		System.out.println(""+getEndZeit());
		System.out.println(""+getZusagen());
		System.out.println(""+getAbsagen());
		System.out.println(""+getInfo());
		System.out.println(""+getStatus());
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getStartZeit() {
		return startZeit;
	}

	public void setStartZeit(String startZeit) {
		this.startZeit = startZeit;
	}

	public String getEndZeit() {
		return endZeit;
	}

	public void setEndZeit(String endZeit) {
		this.endZeit = endZeit;
	}

	public int getZusagen() {
		return zusagen;
	}

	public void setZusagen(int zusagen) {
		this.zusagen = zusagen;
	}

	public int getAbsagen() {
		return absagen;
	}

	public void setAbsagen(int absagen) {
		this.absagen = absagen;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	  

}
