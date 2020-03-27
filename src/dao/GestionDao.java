package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.Etudiant;


public class GestionDao {

	// Informations d'acc�s � la base de donn�es
	static String url = "jdbc:mysql://localhost/gestion_ecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String login = "root";
	static String password = "";
	
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet rs = null;
	
	/**
	 * Essaie de connecter l'utilisateur � la base de donn�es.
	 * @param email L'email de l'utilisateur.
	 * @param mdp Le mot de passe de l'utilisateur.
	 * @return
	 */
	public static String connecter(String email , String mdp) {
		
		String role = "";
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql = "Select * from Enseignant  WHERE mail ='" + email + "' and mdp ='" + mdp + "'";
			
			// Etape 4 : Ex�cution requ�te
			rs = statement.executeQuery(sql);
			
			if(rs.next())
				role = rs.getString("role");
			else
				System.out.println("Email ou mot de passe incorrect");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return role;
	}	
	
	/***
	 * Cr�e un �tudiant dans la base de donn�es.
	 * @param �tudiant L'objet �tudiant � cr�er.
	 * @return L'�tudiant cr��.
	 */
	public static Etudiant creerEtudiant(Etudiant etudiant)
	{
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql =
					"INSERT INTO Etudiant(nom,prenom,mail,adresse,numero,dateNaissance) " +
					"VALUES ('" + etudiant.getNom() + "','" +
					etudiant.getPrenom() + "','" +
					etudiant.getMail() + "','" +
					etudiant.getAdresse() + "','" +
					etudiant.getTelephone() + "','" +
					etudiant.getDateNaissanceEtudiant() + "')";

			// Etape 4 : Ex�cution requ�te
			statement.executeUpdate(sql);
			
			System.out.println("L'�tudiant " + etudiant.getNom() + " " + etudiant.getPrenom() + " a �t� cr��.\n");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return new Etudiant();
	}
	
	/***
	 * Affiche les informations d'un �tudiant grâce � son email.
	 * @param email Email de l'�tudiant.
	 */
	public static void lireEtudiant(String email)
	{
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql ="Select * FROM Etudiant WHERE mail ='"+email+"'";
			
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
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Supprime un �tudiant de la base de donn�es.
	 * @param email Email de l'�tudiant.
	 */
	public static void supprimerEtudiant(String email)
	{
		int resultat;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql = "delete from Etudiant where mail ='"+email+"'";
			
			// Etape 4 : Ex�cution requ�te
			resultat= statement.executeUpdate(sql);
			
			if(resultat == 0)
				System.out.println("Aucun �tudiant ne poss�de cet email.\n");
			else
				System.out.println("L'�tudiant a bien �t� supprime.\n");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Liste l'ensemble des �tudiants de la base de donn�es.
	 */
	public static void listerEtudiants()
	{
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql ="Select * FROM Etudiant order by nom";
			
			// Etape 4 : Ex�cution requ�te
			rs = statement.executeQuery(sql);
			System.out.println("Voici l'ensemble des �tudiants : \n");
			System.out.println("Nom " + "Prenom" + " mail \n");
			System.out.println("----------------------");
			
			while(rs.next())
				System.out.println(rs.getString("nom") + " " + rs.getString("prenom")+ " " + rs.getString("mail"));
			
			System.out.println("\n");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Modifie l'adresse d'un �tudiant.
	 * @param email Email de l'�tudiant.
	 * @param nouvelleAdresse Nouvelle adresse de l'�tudiant.
	 */
	public static void modifierAdresseEtudiant(String email, String nouvelleAdresse)
	{
		int resultat;
	
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql = "Update Etudiant Set adresse= '"+nouvelleAdresse+"'where mail ='"+email+"'";
			
			// Etape 4 : Ex�cution requ�te
			resultat = statement.executeUpdate(sql);
			
			if (resultat == 0)
				System.out.println("Aucun �tudiant ne poss�de cet id.\n");
			else
				System.out.println("Nouvelle adresse mise � jour.\n");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Associe un cours � un �tudiant.
	 * @param mailEtudiant Email de l'�tudiant.
	 * @param theme Theme du cours � associer.
	 */
	public static void associerCoursEtudiant(String mailEtudiant, String theme)
	{
		int resultat;
	
		try
		{
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
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static List<String> rechercherEtudiant(String chaine)
	{
		List<String> listeEtudiants = new ArrayList<String>();
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql = "SELECT id, nom, prenom FROM etudiant";
			
			// Etape 4 : Ex�cution requ�te
			rs = statement.executeQuery(sql);
			
			if (rs.next() == false)
				System.out.println("Aucun �tudiant trouv�.\n");
			else
				while(rs.next())
					listeEtudiants.add(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return listeEtudiants;
	}
}
