package model;

public class PanierModel {
	
	private String nomMed;
	private int qteDemandee;
	private float prixTotalArticle;
	
	
	public PanierModel() {
		this.nomMed="";
		this.qteDemandee=0;
		this.prixTotalArticle=0;
	}


	public String getNomMed() {
		return nomMed;
	}


	public void setNomMed(String nomMed) {
		this.nomMed = nomMed;
	}


	public int getQteDemandee() {
		return qteDemandee;
	}


	public void setQteDemandee(int qteDemandee) {
		this.qteDemandee = qteDemandee;
	}


	public float getPrixTotalArticle() {
		return prixTotalArticle;
	}


	public void setPrixTotalArticle(float prixTotalArticle) {
		this.prixTotalArticle = prixTotalArticle;
	}
	
	public String toString() {
		String aRetourner="";
		
		aRetourner=nomMed+", quantité : "+qteDemandee+", total article = "+prixTotalArticle+"€";
				
		return aRetourner;
	}

}
