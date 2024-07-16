package model;

public class EntreesSortiesModel {
	
	private int idEs;
	private int idMed;
	private int idFour;
	private int quantite;
	private String dateFabrication;
	private String dateExpiration;
	private String dateEntreesSorties;
	private double prixUnitaire;
	private String entreeSortie;
	
	public EntreesSortiesModel() {
		this.idEs=0;
		this.idMed=0;
		this.idFour=0;
		this.quantite=0;
		this.dateFabrication="";
		this.dateExpiration="";
		this.dateEntreesSorties="";
		this.prixUnitaire=0.00;
		this.entreeSortie="A";
	}

	public int getIdMed() {
		return idMed;
	}

	public void setIdMed(int idMed) {
		this.idMed = idMed;
	}

	public int getIdFour() {
		return idFour;
	}

	public void setIdFour(int idFour) {
		this.idFour = idFour;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDateFabrication() {
		return dateFabrication;
	}

	public void setDateFabrication(String dateFabrication) {
		this.dateFabrication = dateFabrication;
	}

	public String getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public String getDateEntreesSorties() {
		return dateEntreesSorties;
	}

	public void setDateEntreesSorties(String dateEntreesSorties) {
		this.dateEntreesSorties = dateEntreesSorties;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getIdEs() {
		return idEs;
	}

	public void setIdEs(int idEs) {
		this.idEs = idEs;
	}
	
	
	public String getEntreeSortie() {
		return entreeSortie;
	}

	public void setEntreeSortie(String entreeSortie) {
		this.entreeSortie = entreeSortie;
	}

	public String toString() {
		String aRetourner="";
		String nomMed="";
		String nomFournisseur="";
		
		switch (idMed) {
		case 1:
			nomMed="Paracetamol";
			break;
		case 2:
			nomMed="Amoxicilline";
			break;
		case 3:
			nomMed="Ibuprofene";
			break;
		case 4:
			nomMed="Meteoclopramide";
			break;
		case 5:
			nomMed="Aspirine";
			break;
		case 6:
			nomMed="Diazepam";
			break;
		case 7:
			nomMed="Drotaverine";
			break;
		default:
			nomMed="inconnu";
			break;
		}
		
		switch (idFour) {
		case 1:
			nomFournisseur="Pfizer";
			break;
		case 2:
			nomFournisseur="Chouquette";
			break;
		case 3:
			nomFournisseur="Danielle";
			break;
		case 4:
			nomFournisseur="Fukushima";
			break;
		case 5:
			nomFournisseur="House";
			break;
		case 6:
			nomFournisseur="Martin";
			break;
		case 7:
			nomFournisseur="Nozman";
			break;
		default:
			nomFournisseur="inconnu";
			break;
		}
		
		aRetourner=idEs+", "+nomMed+", "+nomFournisseur+", quantité : "+quantite+", date de fabrication : "+dateFabrication+", date expiration : "+dateExpiration+", date Entrée/sortie : "+dateEntreesSorties+", prix unitaire : "+prixUnitaire+"€, type :"+entreeSortie;
		
		return aRetourner;
	}

}
