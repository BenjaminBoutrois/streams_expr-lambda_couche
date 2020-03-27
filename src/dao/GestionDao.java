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

	// Informations d'accès à la base de données
	static String url = "jdbc:mysql://localhost/gestion_ecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String login = "root";
	static String password = "";
	
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet rs = null;
	
	/**
	 * Essaie de connecter l'utilisateur à la base de données.
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
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql = "Select * from Enseignant  WHERE mail ='" + email + "' and mdp ='" + mdp + "'";
			
			// Etape 4 : Exécution requête
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
				// Etape 5 : Libérer ressources de la mémoire
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
	 * Crée un étudiant dans la base de données.
	 * @param étudiant L'objet étudiant à créer.
	 * @return L'étudiant créé.
	 */
	public static Etudiant creerEtudiant(Etudiant etudiant)
	{
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql =
					"INSERT INTO Etudiant(nom,prenom,mail,adresse,numero,dateNaissance) " +
					"VALUES ('" + etudiant.getNom() + "','" +
					etudiant.getPrenom() + "','" +
					etudiant.getMail() + "','" +
					etudiant.getAdresse() + "','" +
					etudiant.getTelephone() + "','" +
					etudiant.getDateNaissanceEtudiant() + "')";

			// Etape 4 : Exécution requête
			statement.executeUpdate(sql);
			
			System.out.println("L'étudiant " + etudiant.getNom() + " " + etudiant.getPrenom() + " a été créé.\n");
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
				// Etape 5 : Libérer ressources de la mémoire
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
	 * Affiche les informations d'un étudiant grÃ¢ce à son email.
	 * @param email Email de l'étudiant.
	 */
	public static void lireEtudiant(String email)
	{
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql ="Select * FROM Etudiant WHERE mail ='"+email+"'";
			
			// Etape 4 : Exécution requête
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
				System.out.println("Aucun étudiant n'a cet email.\n");
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
				// Etape 5 : Libérer ressources de la mémoire
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
	 * Supprime un étudiant de la base de données.
	 * @param email Email de l'étudiant.
	 */
	public static void supprimerEtudiant(String email)
	{
		int resultat;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql = "delete from Etudiant where mail ='"+email+"'";
			
			// Etape 4 : Exécution requête
			resultat= statement.executeUpdate(sql);
			
			if(resultat == 0)
				System.out.println("Aucun étudiant ne possède cet email.\n");
			else
				System.out.println("L'étudiant a bien été supprime.\n");
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
				// Etape 5 : Libérer ressources de la mémoire
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
	 * Liste l'ensemble des étudiants de la base de données.
	 */
	public static void listerEtudiants()
	{
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql ="Select * FROM Etudiant order by nom";
			
			// Etape 4 : Exécution requête
			rs = statement.executeQuery(sql);
			System.out.println("Voici l'ensemble des étudiants : \n");
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
				// Etape 5 : Libérer ressources de la mémoire
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
	 * Modifie l'adresse d'un étudiant.
	 * @param email Email de l'étudiant.
	 * @param nouvelleAdresse Nouvelle adresse de l'étudiant.
	 */
	public static void modifierAdresseEtudiant(String email, String nouvelleAdresse)
	{
		int resultat;
	
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql = "Update Etudiant Set adresse= '"+nouvelleAdresse+"'where mail ='"+email+"'";
			
			// Etape 4 : Exécution requête
			resultat = statement.executeUpdate(sql);
			
			if (resultat == 0)
				System.out.println("Aucun étudiant ne possède cet id.\n");
			else
				System.out.println("Nouvelle adresse mise à jour.\n");
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
				// Etape 5 : Libérer ressources de la mémoire
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
	 * Associe un cours à un étudiant.
	 * @param mailEtudiant Email de l'étudiant.
	 * @param theme Theme du cours à associer.
	 */
	public static void associerCoursEtudiant(String mailEtudiant, String theme)
	{
		int resultat;
	
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql =
					"INSERT INTO CoursEtudiant " +
					"VALUES ('" + theme + "', '" + mailEtudiant + "')";
			
			// Etape 4 : Exécution requête
			resultat = statement.executeUpdate(sql);
			
			if (resultat == 0)
				System.out.println("Aucun étudiant ne possède cet id.\n");
			else
				System.out.println("Cours associé a l'étudiant.\n");
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
				// Etape 5 : Libérer ressources de la mémoire
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
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql = "SELECT id, nom, prenom FROM etudiant";
			
			// Etape 4 : Exécution requête
			rs = statement.executeQuery(sql);
			
			if (rs.next() == false)
				System.out.println("Aucun étudiant trouvé.\n");
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
				// Etape 5 : Libérer ressources de la mémoire
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
