package model;

import java.sql.*;
import java.util.ArrayList;


public class FactureDAO {

private Connection conn;
	
	public FactureDAO() {
		conn = Maconnexion.getConnection();
	}
	
	// récupérer l'ensemble des factures
	
	public ArrayList<FactureModel> getAllFactures(){
		ArrayList<FactureModel> factureMListe = new ArrayList<FactureModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("select * from Facture order by numFact");
			while (resultats.next()) {
				FactureModel factureM = new FactureModel();
				
				factureM.setNumFacture(resultats.getInt("numFact"));
				factureM.setDateFacture(resultats.getString("dateFact"));
				factureM.setIdPatient(resultats.getInt("idPatient"));
				factureM.setNumCli(resultats.getInt("numCli"));
										
				factureMListe.add(factureM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return factureMListe;
	}
	/******************************************************************/
	// ajouter nouvelle facture
	
	public void ajouterFacture(FactureModel factureM) {
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("insert into Facture(dateFact, idPatient, numCli) values (?,?,?)");

			preparedStatement.setString(1, factureM.getDateFacture());
			preparedStatement.setInt(2, factureM.getIdPatient());
			preparedStatement.setInt(3, factureM.getNumCli());
			preparedStatement.executeUpdate();

			// récupérer le dernier numéro ajouté après un insert :
			ResultSet resultat = conn.createStatement().executeQuery("SELECT MAX(numFact) as numFact_max FROM facture");
			int numFact_max = 0;
			while (resultat.next())
				numFact_max = resultat.getInt("numFact_max");
			
			//actualiser numéro de facture
			factureM.setNumFacture(numFact_max);
			resultat.close(); 
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	/******************************************************************/
	
	// modifier une facture
	
	public void modifierFacture(FactureModel factureM) {
		//A compléter
		
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			String dateFacture=factureM.getDateFacture();
			int idPatient=factureM.getIdPatient();
			int numCli=factureM.getNumCli();
			int numFact=factureM.getNumFacture();
			
		res = statement1.executeUpdate("update facture set dateFact='"+dateFacture+"', idPatient='"+idPatient+"',numCli='"+numCli+"' where numFact="+numFact);
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllFactures();
		
	}
	
	/**************************************************************************************/
		//supprimer facture
	
	public void supprimerFacture(int numFacture) {
		//A compléter
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			res = statement1.executeUpdate("delete from facture where numFact="+numFacture+";");
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllFactures();
	}
	
	/*****************************************************************************************/
		//rechercher facture
	
	public ArrayList<FactureModel> rechercherFacture(String recherche) {
		
		ArrayList<FactureModel> factureRList =new ArrayList<FactureModel>();
		
		try {
			Statement statement1 = conn.createStatement();
			
			ResultSet resultats = statement1.executeQuery("select * from Facture where numFact like'%"+recherche+"%' or dateFact like '%"+recherche+"%' or idPatient like '%"+recherche+"%' or numCli like '%"+recherche+"%';");
			
			while(resultats.next()) {
					FactureModel factureRecherche=new FactureModel();
					
						factureRecherche.setNumFacture(resultats.getInt("numFact"));
						factureRecherche.setDateFacture(resultats.getString("dateFact"));
						factureRecherche.setIdPatient(resultats.getInt("idPatient"));
						factureRecherche.setNumCli(resultats.getInt("numCli"));
						
						factureRList.add(factureRecherche);
						
				}
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		return(factureRList);
	}
}
