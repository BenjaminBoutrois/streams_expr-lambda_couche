package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.Etudiant;


public class GestionDao
{
	// Informations d'acc�s � la base de donn�es
	static final String url = "jdbc:mysql://localhost/gestion_ecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static final String login = "root";
	static final String password = "";
	
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet rs = null;
	
	/**
	 * Essaie de connecter l'utilisateur � la base de donn�es.
	 * @param email L'email de l'utilisateur.
	 * @param mdp Le mot de passe de l'utilisateur.
	 * @return
	 */
	public static String seConnecter(String email , String mdp) throws SQLException, ClassNotFoundException
	{
		String role = "";
		
		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Etape 2 : R�cup�ration de la connexion
		connection = DriverManager.getConnection(url, login, password);
		
		// Etape 3 : Cr�ation d'un statement
		statement = connection.createStatement();
		
		String sql = "Select * FROM Enseignant WHERE mail ='" + email + "' AND mdp ='" + mdp + "'";
		
		// Etape 4 : Ex�cution requ�te
		rs = statement.executeQuery(sql);
		
		if(rs.next())
			role = rs.getString("role");
		else
			role = "incorrect";

		// Etape 5 : Lib�rer ressources de la m�moire
		connection.close();
		statement.close();
		
		return role;
	}	
	
	/***
	 * Cr�e un �tudiant dans la base de donn�es.
	 * @param �tudiant L'objet �tudiant � cr�er.
	 * @return L'�tudiant cr��.
	 */
	public static Etudiant creerEtudiant(Etudiant etudiant) throws SQLException, ClassNotFoundException
	{
		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Etape 2 : R�cup�ration de la connexion
		connection = DriverManager.getConnection(url, login, password);
		
		// Etape 3 : Cr�ation d'un statement
		statement = connection.createStatement();
		
		String sql =
				"INSERT INTO Etudiant(id, nom, prenom, mail, adresse, numero, dateNaissance) " +
				"VALUES ('" + Math.random() * (100000 - 1) + "','" +
				etudiant.getNom() + "','" +
				etudiant.getPrenom() + "','" +
				etudiant.getMail() + "','" +
				etudiant.getAdresse() + "','" +
				etudiant.getTelephone() + "','" +
				etudiant.getDateNaissanceEtudiant() + "')";

		// Etape 4 : Ex�cution requ�te
		statement.executeUpdate(sql);
		
		System.out.println("L'�tudiant " + etudiant.getNom() + " " + etudiant.getPrenom() + " a �t� cr��.\n");

		// Etape 5 : Lib�rer ressources de la m�moire
		connection.close();
		statement.close();
		
		return new Etudiant();
	}
	
	/***
	 * Affiche les informations d'un �tudiant gr�ce � son email.
	 * @param email Email de l'�tudiant.
	 */
	public static void lireEtudiant(String email) throws SQLException, ClassNotFoundException
	{
		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Etape 2 : R�cup�ration de la connexion
		connection = DriverManager.getConnection(url, login, password);
		
		// Etape 3 : Cr�ation d'un statement
		statement = connection.createStatement();
		
		String sql ="SELECT * FROM Etudiant WHERE mail ='" + email + "'";
		
		// Etape 4 : Ex�cution requ�te
		rs=statement.executeQuery(sql);
		if(rs.next())
		{
			System.out.println("Nom : "+ rs.getString("nom"));
			System.out.println("Prenom : "+ rs.getString("prenom"));
			System.out.println("Mail : "+ rs.getString("mail"));
			System.out.println("Adresse : "+ rs.getString("adresse"));
			System.out.println("Numero : "+ rs.getString("numero"));
			System.out.println("dateNaissance : "+ rs.getString("dateNaissance"));
		}
		else
			System.out.println("Aucun �tudiant n'a cet email.\n");

		// Etape 5 : Lib�rer ressources de la m�moire
		connection.close();
		statement.close();
	}
	
	/**
	 * Supprime un �tudiant de la base de donn�es.
	 * @param email Email de l'�tudiant.
	 */
	public static void supprimerEtudiant(String email) throws SQLException, ClassNotFoundException
	{
		int resultat;
		
		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Etape 2 : R�cup�ration de la connexion
		connection = DriverManager.getConnection(url, login, password);
		
		// Etape 3 : Cr�ation d'un statement
		statement = connection.createStatement();
		
		String sql = "DELETE FROM Etudiant WHERE mail ='"+email+"'";
		
		// Etape 4 : Ex�cution requ�te
		resultat= statement.executeUpdate(sql);
		
		if(resultat == 0)
			System.out.println("Aucun �tudiant ne poss�de cet email.\n");
		else
			System.out.println("L'�tudiant a bien �t� supprime.\n");

		// Etape 5 : Lib�rer ressources de la m�moire
		connection.close();
		statement.close();
	}

	/**
	 * R�cup�re la liste de l'ensemble des �tudiants de la base de donn�es.
	 */
	public static List<String> recupererListeEtudiants() throws SQLException, ClassNotFoundException
	{
		List<String> listeEtudiants = new ArrayList<String>();
		
		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Etape 2 : R�cup�ration de la connexion
		connection = DriverManager.getConnection(url, login, password);
		
		// Etape 3 : Cr�ation d'un statement
		statement = connection.createStatement();
		
		String sql = "SELECT id, nom, prenom, mail FROM etudiant\n";
		
		// Etape 4 : Ex�cution requ�te
		rs = statement.executeQuery(sql);
		
		if (rs.next() == false)
			System.out.println("Aucun �tudiant trouv�.\n");
		else
			while(rs.next())
				listeEtudiants.add(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4));

		// Etape 5 : Lib�rer ressources de la m�moire
		connection.close();
		statement.close();
		
		return listeEtudiants;
	}
	
	/**
	 * Modifie l'adresse d'un �tudiant.
	 * @param email Email de l'�tudiant.
	 * @param nouvelleAdresse Nouvelle adresse de l'�tudiant.
	 */
	public static void modifierAdresseEtudiant(String email, String nouvelleAdresse) throws SQLException, ClassNotFoundException
	{
		int resultat;
		
		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Etape 2 : R�cup�ration de la connexion
		connection = DriverManager.getConnection(url, login, password);
		
		// Etape 3 : Cr�ation d'un statement
		statement = connection.createStatement();
		
		String sql = "UPDATE Etudiant SET adresse= '" + nouvelleAdresse + "'WHERE mail ='" + email + "'";
		
		// Etape 4 : Ex�cution requ�te
		resultat = statement.executeUpdate(sql);
		
		if (resultat == 0)
			System.out.println("Aucun �tudiant ne poss�de cet id.\n");
		else
			System.out.println("Nouvelle adresse mise � jour.\n");

		// Etape 5 : Lib�rer ressources de la m�moire
		connection.close();
		statement.close();
	}
	
	/**
	 * Associe un cours � un �tudiant.
	 * @param mailEtudiant Email de l'�tudiant.
	 * @param theme Theme du cours � associer.
	 */
	public static void associerCoursEtudiant(String mailEtudiant, String theme) throws SQLException, ClassNotFoundException
	{
		int resultat;
		
		// Etape 1 : Chargement du driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Etape 2 : R�cup�ration de la connexion
		connection = DriverManager.getConnection(url, login, password);
		
		// Etape 3 : Cr�ation d'un statement
		statement = connection.createStatement();
		
		String sql =
				"INSERT INTO CoursEtudiant " +
				"VALUES ('" + theme + "', '" + mailEtudiant + "')";
		
		// Etape 4 : Ex�cution requ�te
		resultat = statement.executeUpdate(sql);
		
		if (resultat == 0)
			System.out.println("Aucun �tudiant ne poss�de cet id.\n");
		else
			System.out.println("Cours associ� a l'�tudiant.\n");

		// Etape 5 : Lib�rer ressources de la m�moire
		connection.close();
		statement.close();
	}
}
