package model;

import java.sql.*;
import java.util.ArrayList;


public class CategorieDAO {
private Connection conn;
	
	public CategorieDAO() {
		conn = Maconnexion.getConnection();
	}
	
	// récupérer l'ensemble des categories
	
	public ArrayList<CategorieModel> getAllCategorie(){
		ArrayList<CategorieModel> categorieMListe = new ArrayList<CategorieModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("select * from categorie order by numCat");
			while (resultats.next()) {
				CategorieModel categorieM = new CategorieModel();
				
				categorieM.setNumCat(resultats.getInt("numCat"));
				categorieM.setNomCategorie(resultats.getString("nomCat"));
										
				categorieMListe.add(categorieM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorieMListe;
	}
	/******************************************************************/
	// ajouter nouvelle categorie
	
	public void ajouterCategorie(CategorieModel categorieM) {
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("insert into categorie(nomCat) values (?)");

			preparedStatement.setString(1, categorieM.getNomCategorie());
			preparedStatement.executeUpdate();

			// récupérer le dernier id ajouté après un insert :
			ResultSet resultat = conn.createStatement().executeQuery("SELECT MAX(numCat) as numCat_max FROM categorie");
			int numCat_max = 0;
			while (resultat.next())
				numCat_max = resultat.getInt("numCat_max");
			
			//actualiser ID de categorie
			categorieM.setNumCat(numCat_max);
			resultat.close(); 
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	/******************************************************************/
	
	// modifier une categorie
	
	public void modifierCategorie(CategorieModel categorieM) {
		//A compléter
		
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			String nomCat=categorieM.getNomCategorie();
			int numCat=categorieM.getNumCat();
			
		res = statement1.executeUpdate("update patient set nomCat='"+nomCat+" where numCat="+numCat+";");
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllCategorie();
		
	}
	
	/**************************************************************************************/
		//supprimer categorie
	
	public void supprimerCategorie(int numCat) {
		//A compléter
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			res = statement1.executeUpdate("delete from categorie where numCat="+numCat+";");
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllCategorie();
	}
	
	/*****************************************************************************************/
		//rechercher categorie
	
	public ArrayList<CategorieModel> rechercherCategorie(String recherche) {
		
		ArrayList<CategorieModel> categorieRList =new ArrayList<CategorieModel>();
		
		try {
			Statement statement1 = conn.createStatement();
			
			ResultSet resultats = statement1.executeQuery("select * from categorie where nomCat like'%"+recherche+"%';");
			
			while(resultats.next()) {
					CategorieModel categorieRecherche=new CategorieModel();
					
						categorieRecherche.setNumCat(resultats.getInt("numCat"));
						categorieRecherche.setNomCategorie(resultats.getString("nomCat"));
						
						categorieRList.add(categorieRecherche);
						
				}
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		return(categorieRList);
	}
}
