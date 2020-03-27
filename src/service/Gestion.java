package service;

import java.util.List;

import dao.GestionDao;
import interfaces.IGestion;
import metier.Etudiant;

/**
 * Classe Gestion : permet de faire la liaison entre le dao et le metier.
 * Impl�mente l'interface IGestion.
 */
public class Gestion implements IGestion
{
	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	@Override
	public Etudiant creerEtudiant (Etudiant etudiant)
	{
		return GestionDao.creerEtudiant(etudiant);
	}
	
	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	@Override
	public void lireEtudiant(String email)
	{
		GestionDao.lireEtudiant(email);
	}

	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	@Override
	public void supprimerEtudiant(String email)
	{
		GestionDao.supprimerEtudiant(email);
	}

	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	@Override
	public void modifierAdresseEtudiant(String email,String nouvelleAdresse)
	{
		GestionDao.modifierAdresseEtudiant(email, nouvelleAdresse);
	}

	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	@Override
	public void associerCoursEtudiant(String mailEtudiant,String theme)
	{
		GestionDao.associerCoursEtudiant(mailEtudiant, theme);
	}

	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	@Override
	public void listerEtudiants()
	{
		GestionDao.listerEtudiants();
	}

	/**
	 * Appelle la m�thode ayant la m�me signature dans la classe GestionDao.
	 */
	@Override
	public String connecter(String email, String mdp)
	{
		return GestionDao.connecter(email, mdp);
	}

	public void rechercherEtudiant(String chaine)
	{
		List<String> listeEtudiants = GestionDao.rechercherEtudiant(chaine);
		
		System.out.println("Etudiants trouv�s :\n");
		System.out.println("ID | Nom | Pr�nom\n");
		
		listeEtudiants.stream()
			.filter(n -> n.contains(chaine))
			.forEach(System.out::println);
		
		System.out.println();
	}
}
