package model;

public class PatientModel {
	
	private int id;
	private String dateOrdonnance;
	private String nom;
	private String prenom;
	private String nss;
	
	public PatientModel() {
		this.id=-1;
		this.dateOrdonnance="";
		this.nom="";
		this.prenom="";
		this.nss="";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getDateOrdonnance() {
		return dateOrdonnance;
	}

	public void setDateOrdonnance(String dateOrdonnance) {
		this.dateOrdonnance = dateOrdonnance;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}
	
	public String toString() {
		String aRetourner="";
		
		aRetourner="Patient numéro "+id+" , ordonnance du : "+dateOrdonnance+" concernant "+nom+", "+prenom+", numéro de sécurité sociale :"+nss;
		
		return aRetourner;
	}
}
