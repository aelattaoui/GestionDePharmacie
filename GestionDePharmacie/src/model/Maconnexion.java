package model;

import java.sql.*;
import java.util.*;
import java.io.*;
 

//class de connexion avec la base de donnée
public class Maconnexion {
 //Attributs
	/*private static String url = "jdbc:mysql://localhost:3306/pharmacie_database?useSSL=false&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "root";
	private static String driver = "com.mysql.cj.jdbc.Driver";*/
	private static Connection connexion = null;

	// Constructeur par défaut
	public Maconnexion() {
		try {
			InputStream input = new FileInputStream("config/db.properties");
			Properties prop = new Properties();
			
			prop.load(input);
			String driver = prop.getProperty("driver");
			String user = prop.getProperty("user");
			String url = prop.getProperty("url");
			String password = prop.getProperty("password");
			
			Class.forName(driver);
			connexion = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Créer ou retourner une connexion
	public static Connection getConnection() {
		if (connexion == null) {
			new Maconnexion();
		}
		return connexion;
	}

	// Fermer la connexion à la base de données
	public static void stop() {
		if (connexion != null) {
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
