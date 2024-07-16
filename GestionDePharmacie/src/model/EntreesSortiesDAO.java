package model;

import java.sql.*;
import java.util.ArrayList;

public class EntreesSortiesDAO {
	
	private Connection conn;
	
		public EntreesSortiesDAO() {
			conn = Maconnexion.getConnection();
		}
		
		// récupérer l'ensemble des entrées et sorties
		
		public ArrayList<EntreesSortiesModel> getAllES(){
			ArrayList<EntreesSortiesModel> ESMListe = new ArrayList<EntreesSortiesModel>();
			try {
				Statement statement = conn.createStatement();
				ResultSet resultats = statement.executeQuery("select * from EntreesSorties order by idEs");
				while (resultats.next()) {
					EntreesSortiesModel ESM = new EntreesSortiesModel();
					
					ESM.setIdEs(resultats.getInt("idEs"));
					ESM.setIdMed(resultats.getInt("idMed"));
					ESM.setIdFour(resultats.getInt("idFourEs"));
					ESM.setQuantite(resultats.getInt("qte"));
					ESM.setDateFabrication(resultats.getString("datFab"));
					ESM.setDateExpiration(resultats.getString("dateExp"));
					ESM.setDateEntreesSorties(resultats.getString("dateEntreesSorties"));
					ESM.setPrixUnitaire(resultats.getDouble("prixUnitAchat"));
					ESM.setEntreeSortie(resultats.getString("entreeSortie"));
											
					ESMListe.add(ESM);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ESMListe;
		}
		
		/******************************************************************/
		// ajouter nouvelle entrée sortie
		
		public void ajouterES(EntreesSortiesModel ESM) {
			try {
				PreparedStatement preparedStatement = conn
						.prepareStatement("insert into EntreesSorties(idMed, idFourEs, qte, datFab, dateExp, dateEntreesSorties, prixUnitAchat, entreeSortie) values (?,?,?,?,?,?,?,?)");

				preparedStatement.setInt(1, ESM.getIdMed());
				preparedStatement.setInt(2, ESM.getIdFour());
				preparedStatement.setInt(3, ESM.getQuantite());
				preparedStatement.setString(4, ESM.getDateFabrication());
				preparedStatement.setString(5, ESM.getDateExpiration());
				preparedStatement.setString(6, ESM.getDateEntreesSorties());
				preparedStatement.setDouble(7, ESM.getPrixUnitaire());
				preparedStatement.setString(8, ESM.getEntreeSortie());
				preparedStatement.executeUpdate();

				// récupérer le dernier id ajouté après un insert :
				ResultSet resultat = conn.createStatement().executeQuery("SELECT MAX(idEs) as idEs_max FROM EntreesSorties");
				int idEs_max = 0;
				while (resultat.next())
					idEs_max = resultat.getInt("idEs_max");
				
				//actualiser ID de contact
				ESM.setIdEs(idEs_max);
				resultat.close(); 
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
				System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
			}
		}
		
		/******************************************************************/
		
		// modifier une Entree sortie
		
		public void modifierES(EntreesSortiesModel ESM) {
			//A compléter
			
			int res;
			
			try {
				Statement statement1 = conn.createStatement();
				
				int idMed=ESM.getIdMed();
				int idFourEs=ESM.getIdFour();
				int qte=ESM.getQuantite();
				String dateFab=ESM.getDateFabrication();
				String dateExp=ESM.getDateExpiration();
				String dateEntreesSorties=ESM.getDateEntreesSorties();
				double prixUnitAchat=ESM.getPrixUnitaire();
				int idEs=ESM.getIdEs();
				String entreeSortie=ESM.getEntreeSortie();
				
				res = statement1.executeUpdate("update EntreesSorties set idMed="+idMed+", idFourEs="+idFourEs+", qte="+qte+", datFab='"+dateFab+"', dateExp='"+dateExp+"', dateEntreesSorties='"+dateEntreesSorties+"', prixUnitAchat="+prixUnitAchat+", entreeSortie='"+entreeSortie+"' where idEs="+idEs+";");
				
			}catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
				System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
			}
			
			getAllES();
			
		}
		
		/**************************************************************************************/
			//supprimer entrée sortie
		
		public void supprimerES(int idEs) {
			//A compléter
			int res;
			
			try {
				Statement statement1 = conn.createStatement();
				
				res = statement1.executeUpdate("delete from EntreesSorties where idEs="+idEs+";");
				
			}catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
				System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
			}
			
			getAllES();
		}
		
		/*****************************************************************************************/
			//rechercher entree sortie
		
		public ArrayList<EntreesSortiesModel> rechercherES(String recherche) {
			
			ArrayList<EntreesSortiesModel> ESRList =new ArrayList<EntreesSortiesModel>();
			
			try {
				Statement statement1 = conn.createStatement();
				
				ResultSet resultats = statement1.executeQuery("select * from EntreesSorties where idEs like '%"+recherche+"%' or idMed like '%"+recherche+"%' or idFourEs like '%"+recherche+"%' or datFab like '%"+recherche+"%' or dateExp like '%"+recherche+"%' or dateEntreesSorties like '%"+recherche+"%';");
				
				while(resultats.next()) {
						EntreesSortiesModel ESRecherche=new EntreesSortiesModel();
						
							ESRecherche.setIdEs(resultats.getInt("idEs"));
							ESRecherche.setIdMed(resultats.getInt("idMed"));
							ESRecherche.setIdFour(resultats.getInt("idFourEs"));
							ESRecherche.setQuantite(resultats.getInt("qte"));
							ESRecherche.setDateFabrication(resultats.getString("datFab"));
							ESRecherche.setDateExpiration(resultats.getString("dateExp"));
							ESRecherche.setDateEntreesSorties(resultats.getString("dateEntreesSorties"));
							ESRecherche.setPrixUnitaire(resultats.getDouble("prixUnitAchat"));
							ESRecherche.setEntreeSortie(resultats.getString("entreeSortie"));
							
							ESRList.add(ESRecherche);
							
					}
				
			}catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
				System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
			}
			return(ESRList);
		}
		
}


