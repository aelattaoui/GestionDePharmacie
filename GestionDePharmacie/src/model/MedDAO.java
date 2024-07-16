package model;

import java.sql.*;
import java.util.ArrayList;

public class MedDAO {
	
private Connection conn;
	
	public MedDAO() {
		conn = Maconnexion.getConnection();
	}
	
	// récupérer l'ensemble des médicaments
	
	public ArrayList<MedModel> getAllMed(){
		ArrayList<MedModel> medMListe = new ArrayList<MedModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("select * from Medicament order by idMed");
			while (resultats.next()) {
				MedModel MedM = new MedModel();
				
				MedM.setId(resultats.getInt("idMed"));
				MedM.setPrixVenteU(resultats.getFloat("prixVenteU"));
				MedM.setRef(resultats.getInt("refMed"));
				MedM.setNom(resultats.getString("nomMed"));
				MedM.setDescription(resultats.getString("descMed"));
				MedM.setCategorie(resultats.getInt("numCat"));
				MedM.setQuantiteStock(resultats.getInt("qteStock"));
										
				medMListe.add(MedM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medMListe;
	}
	/******************************************************************/
	// ajouter nouveau médicament
	
	public void ajouterMed(MedModel MedM) {
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("insert into Medicament(refMed, prixUnit, nomMed, descMed, numCat, qteStock) values (?,?,?,?,?,?)");

			preparedStatement.setInt(1, MedM.getRef());
			preparedStatement.setFloat(2, MedM.getPrixVenteU());
			preparedStatement.setString(3, MedM.getNom());
			preparedStatement.setString(4, MedM.getDescription());
			preparedStatement.setInt(5, MedM.getCategorie());
			preparedStatement.setInt(6, MedM.getQuantiteStock());
			preparedStatement.executeUpdate();

			// récupérer le dernier numéro ajouté après un insert :
			ResultSet resultat = conn.createStatement().executeQuery("SELECT MAX(idMed) as idMed_max FROM Medicament");
			int idMed_max = 0;
			while (resultat.next())
				idMed_max = resultat.getInt("idMed_max");
			
			//actualiser numéro de médicament
			MedM.setId(idMed_max);
			resultat.close(); 
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	/******************************************************************/
	
	// modifier medicament
	
	public void modifierMed(MedModel MedM) {
		//A compléter
		
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			int refMed=MedM.getRef();
			String nomMed=MedM.getNom();
			String descMed=MedM.getDescription();
			int numCat=MedM.getCategorie();
			int qteStock=MedM.getQuantiteStock();
			int idMed=MedM.getId();
			float prixVenteUnit=MedM.getPrixVenteU();
			
		res = statement1.executeUpdate("update Medicament set refMed='"+refMed+"', prixVenteU="+prixVenteUnit+", nomMed='"+nomMed+"',descMed='"+descMed+"', numCat='"+numCat+"', qteStock='"+qteStock+"' where idMed="+idMed+";");
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllMed();
		
	}
	
	/**************************************************************************************/
		//supprimer medicament
	
	public void supprimerMed(int idMed) {
		//A compléter
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			res = statement1.executeUpdate("delete from Medicament where idMed="+idMed+";");
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllMed();
	}
	
	/*****************************************************************************************/
		//rechercher médicament
	
	// Attention ajouter ensuite les jointures pour affichage et recherche
	
	public ArrayList<MedModel> rechercherMed(String recherche) {
		
		ArrayList<MedModel> MedRList =new ArrayList<MedModel>();
		
		try {
			Statement statement1 = conn.createStatement();
			
			ResultSet resultats = statement1.executeQuery("select * from Medicament where refMed like'%"+recherche+"%' or nomMed like '%"+recherche+"%' or numCat like '%"+recherche+"%';");
			
			while(resultats.next()) {
					MedModel MedRecherche=new MedModel();
					
						MedRecherche.setRef(resultats.getInt("refMed"));
						MedRecherche.setNom(resultats.getString("nomMed"));
						MedRecherche.setCategorie(resultats.getInt("numCat"));
						MedRecherche.setDescription(resultats.getString("descMed"));
						MedRecherche.setPrixVenteU(resultats.getFloat("prixVenteU"));
						MedRecherche.setQuantiteStock(resultats.getInt("qteStock"));
						MedRecherche.setId(resultats.getInt("idMed"));
						
						
						MedRList.add(MedRecherche);
						
				}
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		return(MedRList);
	}
	
	/********************************************************************************************/
	
		//mise à jour du stock
	
	public void miseAJourStock(int idMed, int qteStock) {
		
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			res = statement1.executeUpdate("update Medicament set qteStock="+qteStock+" where idMed="+idMed+";");
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	/*********************************************************************************************/
	
	
	
	/*********************************************************************************************/
	
	

}
