package model;

import java.sql.*;
import java.util.ArrayList;


public class FournisseurDAO {
	
private Connection conn;
	
	public FournisseurDAO() {
		conn = Maconnexion.getConnection();
	}
	
	// récupérer l'ensemble des fournisseurs
	
	public ArrayList<FournisseurModel> getAllFournisseur(){
		ArrayList<FournisseurModel> fournisseurMListe = new ArrayList<FournisseurModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("select * from Fournisseur order by idFour");
			while (resultats.next()) {
				FournisseurModel fournisseurM = new FournisseurModel();
				
				fournisseurM.setIdFournisseur(resultats.getInt("idFour"));
				fournisseurM.setNomFournisseur(resultats.getString("nomFour"));
				fournisseurM.setAdresseFournisseur(resultats.getString("adFour"));
				fournisseurM.setVilleFournisseur(resultats.getString("villeFour"));
				fournisseurM.setCpFournisseur(resultats.getInt("cpFour"));
										
				fournisseurMListe.add(fournisseurM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fournisseurMListe;
	}
	/******************************************************************/
	// ajouter nouveau fournisseur
	
	public void ajouterFournisseur(FournisseurModel fournisseurM) {
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("insert into Fournisseur(nomFour, adFour, villeFour, cpFour) values (?,?,?,?)");

			preparedStatement.setString(1, fournisseurM.getNomFournisseur());
			preparedStatement.setString(2, fournisseurM.getAdresseFournisseur());
			preparedStatement.setString(3, fournisseurM.getVilleFournisseur());
			preparedStatement.setInt(4, fournisseurM.getCpFournisseur());
			preparedStatement.executeUpdate();

			// récupérer le dernier numéro ajouté après un insert :
			ResultSet resultat = conn.createStatement().executeQuery("SELECT MAX(idFour) as idFour_max FROM Fournisseur");
			int idFour_max = 0;
			while (resultat.next())
				idFour_max = resultat.getInt("idFour_max");
			
			//actualiser numéro de fournisseur
			fournisseurM.setIdFournisseur(idFour_max);
			resultat.close(); 
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	/******************************************************************/
	
	// modifier fournisseur
	
	public void modifierFournisseur(FournisseurModel fournisseurM) {
		//A compléter
		
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			String nomFour=fournisseurM.getNomFournisseur();
			String adFour=fournisseurM.getAdresseFournisseur();
			String villeFour=fournisseurM.getVilleFournisseur();
			int cpFour=fournisseurM.getCpFournisseur();
			int idFour=fournisseurM.getIdFournisseur();
			
		res = statement1.executeUpdate("update Fournisseur set nomFour='"+nomFour+"', adFour='"+adFour+"',villeFour='"+villeFour+"', cpFour='"+cpFour+"' where idFour="+idFour);
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllFournisseur();
		
	}
	
	/**************************************************************************************/
		//supprimer facture
	
	public void supprimerFournisseur(int idFournisseur) {
		//A compléter
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			res = statement1.executeUpdate("delete from Fournisseur where idFour="+idFournisseur+";");
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllFournisseur();
	}
	
	/*****************************************************************************************/
		//rechercher fournisseur
	
	public ArrayList<FournisseurModel> rechercherFournisseur(String recherche) {
		
		ArrayList<FournisseurModel> fournisseurRList =new ArrayList<FournisseurModel>();
		
		try {
			Statement statement1 = conn.createStatement();
			
			ResultSet resultats = statement1.executeQuery("select * from Fournisseur where idFour like'%"+recherche+"%' or nomFour like '%"+recherche+"%' or adFour like '%"+recherche+"%' or villeFour like '%"+recherche+"%' or cpFour like '%"+recherche+"%';");
			
			while(resultats.next()) {
					FournisseurModel fournisseurRecherche=new FournisseurModel();
					
						fournisseurRecherche.setIdFournisseur(resultats.getInt("idFour"));
						fournisseurRecherche.setNomFournisseur(resultats.getString("nomFour"));
						fournisseurRecherche.setAdresseFournisseur(resultats.getString("adFour"));
						fournisseurRecherche.setVilleFournisseur(resultats.getString("villeFour"));
						fournisseurRecherche.setCpFournisseur(resultats.getInt("cpFour"));
						
						fournisseurRList.add(fournisseurRecherche);
						
				}
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		return(fournisseurRList);
	}

}
