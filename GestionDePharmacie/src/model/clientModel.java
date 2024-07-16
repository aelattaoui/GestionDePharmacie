package model;

public class clientModel {
	
	private int num;
	private String nom;
	private String prenom;
	private String rue;
	private String ville;
	private String cp;
	private String tel;

	public clientModel() {
		this.num=-1;
		this.nom="";
		this.prenom="";
		this.rue="";
		this.ville="";
		this.cp="";
		this.tel="";
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String toString() {
		String aRetourner="";
		
		aRetourner="Client numéro "+num+", "+nom+", "+prenom+", adresse : "+rue+" "+cp+" "+ville+"";
		
		return aRetourner;
	}
}
