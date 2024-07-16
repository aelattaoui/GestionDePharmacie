package model;

public class UtilisateurModel {
	
	private int idUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String dateDerniereConnexion;
	private String identifiant;
	private String motDePasse;
	private String adresseMail;
	private int idDroitAcces;
	
	public UtilisateurModel() {
		this.idUtilisateur=0;
		this.nomUtilisateur="";
		this.prenomUtilisateur="";
		this.dateDerniereConnexion="";
		this.identifiant="";
		this.motDePasse="";
		this.adresseMail="";
		this.idDroitAcces=0;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getDateDerniereConnexion() {
		return dateDerniereConnexion;
	}

	public void setDateDerniereConnexion(String dateDerniereConnexion) {
		this.dateDerniereConnexion = dateDerniereConnexion;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public int getIdDroitAcces() {
		return idDroitAcces;
	}

	public void setIdDroitAcces(int idDroitAcces) {
		this.idDroitAcces = idDroitAcces;
	}

	public String toString() {
		String aRetourner="";
		String droitAcces="";
		
		if (idDroitAcces==1) {
			droitAcces="Pharmacien";
		}
		else if (idDroitAcces==2) {
			droitAcces="Gestionnaire de Stock";
		}
		else if (idDroitAcces==3) {
			droitAcces="Administrateur";
		}
		
		aRetourner=idUtilisateur+", "+nomUtilisateur+", "+prenomUtilisateur+", "+droitAcces;
		
		return aRetourner;
	}
}
