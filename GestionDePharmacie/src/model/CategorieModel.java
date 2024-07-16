package model;

public class CategorieModel {
	
	private int numCat;
	private String nomCategorie;
	
	public CategorieModel() {
		this.numCat=0;
		this.nomCategorie="";
	}

	public int getNumCat() {
		return numCat;
	}

	public void setNumCat(int numCat) {
		this.numCat = numCat;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	
	public String toString() {
		String aRetourner="";
		
		aRetourner="id Catégorie : "+numCat+", nom catégorie : "+nomCategorie;
		
		return aRetourner;
	}

}
