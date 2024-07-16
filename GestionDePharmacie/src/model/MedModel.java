package model;

public class MedModel {
	
	// variables correspondant à un médicament.
	
	private int id;
	private int ref;
	private String nom;
	private String description;
	private int categorie;
	private int quantiteStock;
	private float prixVenteU;
	
	//constructeur
	
	public MedModel() {
		this.id=-1;
		this.nom="";
		this.description="";
		this.categorie=-1;
		this.quantiteStock=0;
		this.prixVenteU=0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public int getQuantiteStock() {
		return quantiteStock;
	}

	public void setQuantiteStock(int quantiteStock) {
		this.quantiteStock = quantiteStock;
	}

	public float getPrixVenteU() {
		return prixVenteU;
	}

	public void setPrixVenteU(float prixVenteU) {
		this.prixVenteU = prixVenteU;
	}

	public String toString() {
		String aRetourner="";
		String nomCategorie="";
		
		if(categorie==1) {
			nomCategorie="Antalgique";
		}
		else if (categorie==2) {
			nomCategorie="Antibiotique";
		}
		else if (categorie==3) {
			nomCategorie="Anti-inflammatoire";
		}
		else if (categorie==4) {
			nomCategorie="Anti-emetique";
		}
		else if(categorie==5) {
			nomCategorie="Antipyretique";
		}
		else if(categorie==6) {
			nomCategorie="Anxiolytique";
		}
		else if(categorie==7) {
			nomCategorie="Antispasmodique";
		}
		
		aRetourner=id+", "+nomCategorie+", quantité en stock : "+quantiteStock+", "+prixVenteU+"€";
		
		return aRetourner;
	}
		

}
