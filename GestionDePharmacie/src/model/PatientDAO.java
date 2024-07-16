package model;

import java.sql.*;
import java.util.ArrayList;

public class PatientDAO {
	
private Connection conn;
	
	public PatientDAO() {
		conn = Maconnexion.getConnection();
	}
	
	// récupérer l'ensemble des patients
	
	public ArrayList<PatientModel> getAllPatient(){
		ArrayList<PatientModel> patientMListe = new ArrayList<PatientModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("select * from Patient order by idPatient");
			while (resultats.next()) {
				PatientModel patientM = new PatientModel();
				
				patientM.setId(resultats.getInt("idPatient"));
				patientM.setDateOrdonnance(resultats.getString("dateOrdo"));
				patientM.setNom(resultats.getString("nomPatient"));
				patientM.setPrenom(resultats.getString("prenomPatient"));
				patientM.setNss(resultats.getString("nss"));
										
				patientMListe.add(patientM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patientMListe;
	}
	/******************************************************************/
	// ajouter nouveau patient
	
	public void ajouterPatient(PatientModel patientM) {
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("insert into Patient(dateOrdo,nomPatient,prenomPatient,nss) values (?,?,?,?)");

			preparedStatement.setString(1, patientM.getDateOrdonnance());
			preparedStatement.setString(2, patientM.getNom());
			preparedStatement.setString(3, patientM.getPrenom());
			preparedStatement.setString(4, patientM.getNss());
			preparedStatement.executeUpdate();

			// récupérer le dernier id ajouté après un insert :
			ResultSet resultat = conn.createStatement().executeQuery("SELECT MAX(idPatient) as idPatient_max FROM patient");
			int idPatient_max = 0;
			while (resultat.next())
				idPatient_max = resultat.getInt("idPatient_max");
			
			//actualiser ID de patient
			patientM.setId(idPatient_max);
			resultat.close(); 
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	/******************************************************************/
	
	// modifier un patient
	
	public void modifierPatient(PatientModel patientM) {
		//A compléter
		
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			String dateOrdonnance=patientM.getDateOrdonnance();
			String nom=patientM.getNom();
			String prenom=patientM.getPrenom();
			String nss=patientM.getNss();
			int id=patientM.getId();
			
		res = statement1.executeUpdate("update patient set dateOrdo='"+dateOrdonnance+"', nomPatient='"+nom+"',prenomPatient='"+prenom+"',nss='"+nss+" where idPatient="+id);
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllPatient();
		
	}
	
	/**************************************************************************************/
		//supprimer patient
	
	public void supprimerPatient(int idPatient) {
		//A compléter
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			res = statement1.executeUpdate("delete from patient where idPatient="+idPatient+";");
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllPatient();
	}
	
	/*****************************************************************************************/
		//rechercher patient
	
	public ArrayList<PatientModel> rechercherPatient(String recherche) {
		
		ArrayList<PatientModel> patientRList =new ArrayList<PatientModel>();
		
		try {
			Statement statement1 = conn.createStatement();
			
			ResultSet resultats = statement1.executeQuery("select * from Patient where nomPatient like'%"+recherche+"%' or prenomPatient like '%"+recherche+"%' or nss like '%"+recherche+"%';");
			
			while(resultats.next()) {
					PatientModel patientRecherche=new PatientModel();
					
						patientRecherche.setId(resultats.getInt("idPatient"));
						patientRecherche.setDateOrdonnance(resultats.getString("dateOrdo"));
						patientRecherche.setNom(resultats.getString("nomPatient"));
						patientRecherche.setPrenom(resultats.getString("prenomPatient"));
						patientRecherche.setNss(resultats.getString("nss"));
						
						patientRList.add(patientRecherche);
						
				}
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		return(patientRList);
	}

}
