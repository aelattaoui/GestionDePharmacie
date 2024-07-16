package model;

public class FactureModel {
	
	private int numFacture;
	private String dateFacture;
	private int idPatient;
	private int numCli;
	
	public FactureModel() {
		this.numFacture=0;
		this.dateFacture="";
		this.idPatient=0;
		this.numCli=0;
	}

	public int getNumFacture() {
		return numFacture;
	}

	public void setNumFacture(int numFacture) {
		this.numFacture = numFacture;
	}

	public String getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(String dateFacture) {
		this.dateFacture = dateFacture;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public int getNumCli() {
		return numCli;
	}

	public void setNumCli(int numCli) {
		this.numCli = numCli;
	}
	
	public String toString() {
		String aRetourner="";
		
		aRetourner="facture numéro "+numFacture+", le "+dateFacture+", client numéro : "+numCli+", patient numéro : "+idPatient;
		
		return aRetourner;
	}

}
