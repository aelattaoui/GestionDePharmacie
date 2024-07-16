package model;

public class FournisseurModel {
	
	private int idFournisseur;
	private String nomFournisseur;
	private String adresseFournisseur;
	private String villeFournisseur;
	private int cpFournisseur;
	
	public FournisseurModel() {
		this.idFournisseur=0;
		this.nomFournisseur="";
		this.adresseFournisseur="";
		this.villeFournisseur="";
		this.cpFournisseur=0;
	}

	public int getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public String getAdresseFournisseur() {
		return adresseFournisseur;
	}

	public void setAdresseFournisseur(String adresseFournisseur) {
		this.adresseFournisseur = adresseFournisseur;
	}

	public String getVilleFournisseur() {
		return villeFournisseur;
	}

	public void setVilleFournisseur(String villeFournisseur) {
		this.villeFournisseur = villeFournisseur;
	}

	public int getCpFournisseur() {
		return cpFournisseur;
	}

	public void setCpFournisseur(int cpFournisseur) {
		this.cpFournisseur = cpFournisseur;
	}

	public String toString() {
		String aRetourner="";
		
		aRetourner="id du fournisseur : "+idFournisseur+", "+nomFournisseur+", "+adresseFournisseur+" "+cpFournisseur+" "+villeFournisseur;
		
		return aRetourner;
	}
}
