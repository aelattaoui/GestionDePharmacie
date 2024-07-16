package model;

import java.sql.*;
import java.util.ArrayList;


public class UtilisateurDAO {
		//attributs
	private Connection conn ;
	
		//constructeur
	
	public UtilisateurDAO() {
		conn = Maconnexion.getConnection();
	}


	
	// récupérer l'ensemble des utilisateurs
	
	public ArrayList<UtilisateurModel> getAllUtilisateur(){
		ArrayList<UtilisateurModel> UtilisateurMListe = new ArrayList<UtilisateurModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("select * from Utilisateur order by idUtil");
			while (resultats.next()) {
				UtilisateurModel UtilisateurM = new UtilisateurModel();
				
				UtilisateurM.setIdUtilisateur(resultats.getInt("idUtil"));
				UtilisateurM.setNomUtilisateur(resultats.getString("nomUtil"));
				UtilisateurM.setPrenomUtilisateur(resultats.getString("prenomUtil"));
				UtilisateurM.setDateDerniereConnexion(resultats.getString("derniereCo"));
				UtilisateurM.setIdentifiant(resultats.getString("identifiant"));
				UtilisateurM.setMotDePasse(resultats.getString("mdp"));
				UtilisateurM.setAdresseMail(resultats.getString("adMail"));
				UtilisateurM.setIdDroitAcces(resultats.getInt("idDroitsAcc"));
				
										
				UtilisateurMListe.add(UtilisateurM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UtilisateurMListe;
	}
	/******************************************************************/
	// ajouter nouvel utilisateur
	
	public void ajouterUtilisateur(UtilisateurModel UtilisateurM) {
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("insert into Utilisateur(nomUtil, prenomUtil, derniereCo, identifiant, mdp, adMail, idDroitsAcc) values (?,?,?,?,?,?,?)");

			preparedStatement.setString(1, UtilisateurM.getNomUtilisateur());
			preparedStatement.setString(2, UtilisateurM.getPrenomUtilisateur());
			preparedStatement.setString(3, UtilisateurM.getDateDerniereConnexion());
			preparedStatement.setString(4, UtilisateurM.getIdentifiant());
			preparedStatement.setString(5, UtilisateurM.getMotDePasse());
			preparedStatement.setString(6, UtilisateurM.getAdresseMail());
			preparedStatement.setInt(7, UtilisateurM.getIdDroitAcces());
			preparedStatement.executeUpdate();

			// récupérer le dernier id ajouté après un insert :
			ResultSet resultat = conn.createStatement().executeQuery("SELECT MAX(idUtil) as idUtil_max FROM Utilisateur");
			int idUtil_max = 0;
			while (resultat.next())
				idUtil_max = resultat.getInt("idUtil_max");
			
			//actualiser ID de contact
			UtilisateurM.setIdUtilisateur(idUtil_max);
			resultat.close(); 
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	/******************************************************************/
	
	// modifier un utilisateur
	
	public void modifierUtilisateur(UtilisateurModel UtilisateurM) {
		//A compléter
		
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			String nom=UtilisateurM.getNomUtilisateur();
			String prenom=UtilisateurM.getPrenomUtilisateur();
			String derniereConnexion=UtilisateurM.getDateDerniereConnexion();
			String identifiant=UtilisateurM.getIdentifiant();
			String motDePasse=UtilisateurM.getMotDePasse();
			String adresseMail=UtilisateurM.getAdresseMail();
			int idDroitsAcces=UtilisateurM.getIdDroitAcces();
			int idUtilisateur=UtilisateurM.getIdUtilisateur();
			
		res = statement1.executeUpdate("update Utilisateur set nomUtil='"+nom+"', prenomUtil='"+prenom+"',derniereCo='"+derniereConnexion+"',identifiant='"+identifiant+"',mdp='"+motDePasse+"', adMail='"+adresseMail+"', idDroitsAcc='"+idDroitsAcces+" where idUtil="+idUtilisateur+");");
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllUtilisateur();
		
	}
	
	/**************************************************************************************/
		//supprimer utilisateur
	
	public void supprimerUtilisateur(int idUtilisateur) {
		//A compléter
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			res = statement1.executeUpdate("delete from Utilisateur where idUtil="+idUtilisateur+";");
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllUtilisateur();
	}
	
	/*****************************************************************************************/
		//rechercher utilisateur
	
	public ArrayList<UtilisateurModel> rechercherUtilisateur(String recherche) {
		
		ArrayList<UtilisateurModel> UtilisateurRList =new ArrayList<UtilisateurModel>();
		
		try {
			Statement statement1 = conn.createStatement();
			
			ResultSet resultats = statement1.executeQuery("select * from Utilisateur where nomUtil like'%"+recherche+"%' or prenomUtil like '%"+recherche+"%' or identifiant like '%"+recherche+"%' or idDroitsAcc like '%"+recherche+"%' ;");
			
			while(resultats.next()) {
					UtilisateurModel UtilisateurRecherche=new UtilisateurModel();
					
						UtilisateurRecherche.setIdUtilisateur(resultats.getInt("idUtil"));
						UtilisateurRecherche.setNomUtilisateur(resultats.getString("nomUtil"));
						UtilisateurRecherche.setPrenomUtilisateur(resultats.getString("prenomUtil"));
						UtilisateurRecherche.setDateDerniereConnexion(resultats.getString("derniereCo"));
						UtilisateurRecherche.setIdentifiant(resultats.getString("identifiant"));
						UtilisateurRecherche.setMotDePasse(resultats.getString("mdp"));
						UtilisateurRecherche.setAdresseMail(resultats.getString("adMail"));
						UtilisateurRecherche.setIdDroitAcces(resultats.getInt("idDroitsAcc"));
						
						UtilisateurRList.add(UtilisateurRecherche);
						
				}
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		return(UtilisateurRList);
	}
}
