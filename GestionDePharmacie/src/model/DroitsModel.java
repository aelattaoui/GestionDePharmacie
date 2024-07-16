package model;

public class DroitsModel {
	
	private int idDroitsAcces;
	private String nomRole;
	
	public DroitsModel() {
		this.idDroitsAcces=0;
		this.nomRole="";
	}

	public int getIdDroitsAcces() {
		return idDroitsAcces;
	}

	public void setIdDroitsAcces(int idDroitsAcces) {
		this.idDroitsAcces = idDroitsAcces;
	}

	public String getNomRole() {
		return nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
	
	public String toString() {
		String aRetourner="";
		
		aRetourner=" id Droits d'accès : "+idDroitsAcces+" - "+nomRole;
		
		return aRetourner;
	}

}
