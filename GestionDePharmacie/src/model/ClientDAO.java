package model;

import java.sql.*;
import java.util.ArrayList;

public class ClientDAO {

	private Connection conn;
	
	public ClientDAO() {
		conn = Maconnexion.getConnection();
	}
	
	// récupérer l'ensemble des clients
	
	public ArrayList<clientModel> getAllClient(){
		ArrayList<clientModel> clientMListe = new ArrayList<clientModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("select * from Client order by numCli");
			while (resultats.next()) {
				clientModel clientM = new clientModel();
				
				clientM.setNum(resultats.getInt("numCli"));
				clientM.setNom(resultats.getString("nomCli"));
				clientM.setPrenom(resultats.getString("prenomCli"));
				clientM.setRue(resultats.getString("rueCli"));
				clientM.setCp(resultats.getString("cpCli"));
				clientM.setTel(resultats.getString("numTel"));
										
				clientMListe.add(clientM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientMListe;
	}
	/******************************************************************/
	// ajouter nouveau client
	
	public void ajouterClient(clientModel clientM) {
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("insert into Client(nomCli,prenomCli,rueCli,villeCli,cpCli,numTel) values (?,?,?,?,?,?)");

			preparedStatement.setString(1, clientM.getNom());
			preparedStatement.setString(2, clientM.getPrenom());
			preparedStatement.setString(3, clientM.getRue());
			preparedStatement.setString(4, clientM.getVille());
			preparedStatement.setString(5, clientM.getCp());
			preparedStatement.setString(6, clientM.getTel());
			preparedStatement.executeUpdate();

			// récupérer le dernier id ajouté après un insert :
			ResultSet resultat = conn.createStatement().executeQuery("SELECT MAX(numCli) as numCli_max FROM client");
			int numCli_max = 0;
			while (resultat.next())
				numCli_max = resultat.getInt("numCli_max");
			
			//actualiser ID de contact
			clientM.setNum(numCli_max);
			resultat.close(); 
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	/******************************************************************/
	
	// modifier un client
	
	public void modifierClient(clientModel clientM) {
		//A compléter
		
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			String nom=clientM.getNom();
			String prenom=clientM.getPrenom();
			String rue=clientM.getRue();
			String ville=clientM.getVille();
			String cp=clientM.getCp();
			String tel=clientM.getTel();
			int id=clientM.getNum();
			
		res = statement1.executeUpdate("update client set nomCli='"+nom+"', prenomCli='"+prenom+"',rueCli='"+rue+"',villeCli='"+ville+", cpCli='"+cp+"',numTel='"+tel+" where numCli="+id+");");
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllClient();
		
	}
	
	/**************************************************************************************/
		//supprimer client
	
	public void supprimerClient(int numClient) {
		//A compléter
		int res;
		
		try {
			Statement statement1 = conn.createStatement();
			
			res = statement1.executeUpdate("delete from client where numCli="+numClient+";");
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		
		getAllClient();
	}
	
	/*****************************************************************************************/
		//rechercher client
	
	public ArrayList<clientModel> rechercherClient(String recherche) {
		
		ArrayList<clientModel> clientRList =new ArrayList<clientModel>();
		
		try {
			Statement statement1 = conn.createStatement();
			
			ResultSet resultats = statement1.executeQuery("select * from client where nomCli like'%"+recherche+"%' or prenomCli like '%"+recherche+"%' or rueCli like '%"+recherche+"%' or villeCli like '%"+recherche+"%' or cpCli like '%"+recherche+"%' or numTel like '%"+recherche+"%';");
			
			while(resultats.next()) {
					clientModel clientRecherche=new clientModel();
					
						clientRecherche.setNum(resultats.getInt("numCli"));
						clientRecherche.setNom(resultats.getString("nomCli"));
						clientRecherche.setPrenom(resultats.getString("prenomCli"));
						clientRecherche.setRue(resultats.getString("rueCli"));
						clientRecherche.setVille(resultats.getString("villeCli"));
						clientRecherche.setCp(resultats.getString("cpCli"));
						clientRecherche.setTel(resultats.getString("numTel"));
						
						clientRList.add(clientRecherche);
						
				}
			
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
		return(clientRList);
	}
	
	}
