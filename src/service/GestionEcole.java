package service;

import java.sql.SQLException;
import java.util.List;

import dao.GestionDao;
import exceptions.BusinessServiceException;
import metier.Etudiant;

/**
 * Classe Gestion : permet de faire la liaison entre le dao et le metier.
 * Impl�mente l'interface IGestion.
 */
public class GestionEcole
{
	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	public static Etudiant creerEtudiant (Etudiant etudiant) throws BusinessServiceException
	{
		try
		{
			return GestionDao.creerEtudiant(etudiant);
		}
		catch (ClassNotFoundException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
		catch (SQLException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
	}
	
	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	public static void lireEtudiant(String email) throws BusinessServiceException
	{
		try
		{
			GestionDao.lireEtudiant(email);
		}
		catch (ClassNotFoundException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
		catch (SQLException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
	}

	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	public static void supprimerEtudiant(String email) throws BusinessServiceException
	{
		try
		{
			GestionDao.supprimerEtudiant(email);
		}
		catch (ClassNotFoundException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
		catch (SQLException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
	}

	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	public static void modifierAdresseEtudiant(String email,String nouvelleAdresse) throws BusinessServiceException
	{
		try
		{
			GestionDao.modifierAdresseEtudiant(email, nouvelleAdresse);
		}
		catch (ClassNotFoundException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
		catch (SQLException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
	}

	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	public static void associerCoursEtudiant(String mailEtudiant,String theme) throws BusinessServiceException
	{
		try
		{
			GestionDao.associerCoursEtudiant(mailEtudiant, theme);
		}
		catch (ClassNotFoundException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
		catch (SQLException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
	}

	/**
	 * R�cup�re la liste de tous les �tudiants avec la m�thode recupererListeEtudiants dans la classe GestionDao et les affiche.
	 */
	public static void listerEtudiants() throws BusinessServiceException
	{
		try
		{
			List<String> listeEtudiants = GestionDao.recupererListeEtudiants();
			
			System.out.println("Etudiants trouv�s :\n");
			System.out.println("ID | Nom | Pr�nom | Mail\n");
			
			listeEtudiants.stream()
				.forEach(System.out::println);
			
			System.out.println();
		}
		catch (ClassNotFoundException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
		catch (SQLException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
	}

	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	public static String connecter(String email, String mdp) throws BusinessServiceException
	{
		String roleUtilisateur = "aucun";
		
		try
		{
			roleUtilisateur = GestionDao.seConnecter(email, mdp);
		}
		catch (ClassNotFoundException e)
		{
			BusinessServiceException businessServiceException =
					new BusinessServiceException("Une exception de type " +
													e.getClass().getName() +
													" est survenue.\n\n" +
													"Message d'erreur : \n\n" +
													e.getMessage());
			
			throw businessServiceException;
		}
		catch (SQLException e)
		{
			BusinessServiceException businessServiceException =
					new BusinessServiceException("Une exception de type " +
													e.getClass().getName() +
													" est survenue.\n\n" +
													"Message d'erreur : \n\n" +
													e.getMessage());
			
			throw businessServiceException;
		}
		
		return roleUtilisateur;
	}

	/**
	 * Appelle la m�thode recupererListeEtudiants dans la classe GestionDao et affiche les �tudiants dont le nom contient chaine.
	 * @param chaine La chaine � rechercher.
	 */
	public static void rechercherEtudiant(String chaine) throws BusinessServiceException
	{
		try
		{
			List<String> listeEtudiants = GestionDao.recupererListeEtudiants();

			System.out.println("Etudiants trouv�s :\n");
			System.out.println("ID | Nom | Pr�nom | Mail\n");
			
			listeEtudiants.stream()
				.filter(n -> n.toUpperCase().contains(chaine.toUpperCase()))
				.forEach(System.out::println);
			
			System.out.println();
		}
		catch (ClassNotFoundException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
		catch (SQLException e)
		{
			throw new BusinessServiceException("Une exception de type " +
												e.getClass().getName() +
												" est survenue.\n\n" +
												"Message d'erreur : \n\n" +
												e.getMessage());
		}
	}
}
