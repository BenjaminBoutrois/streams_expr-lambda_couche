package service;

import java.util.List;

import dao.GestionDao;
import interfaces.IGestion;
import metier.Etudiant;

/**
 * Classe Gestion : permet de faire la liaison entre le dao et le metier.
 * Implémente l'interface IGestion.
 */
public class Gestion implements IGestion
{
	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public Etudiant creerEtudiant (Etudiant etudiant)
	{
		return GestionDao.creerEtudiant(etudiant);
	}
	
	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public void lireEtudiant(String email)
	{
		GestionDao.lireEtudiant(email);
	}

	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public void supprimerEtudiant(String email)
	{
		GestionDao.supprimerEtudiant(email);
	}

	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public void modifierAdresseEtudiant(String email,String nouvelleAdresse)
	{
		GestionDao.modifierAdresseEtudiant(email, nouvelleAdresse);
	}

	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public void associerCoursEtudiant(String mailEtudiant,String theme)
	{
		GestionDao.associerCoursEtudiant(mailEtudiant, theme);
	}

	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public void listerEtudiants()
	{
		GestionDao.listerEtudiants();
	}

	/**
	 * Appelle la méthode ayant la même signature dans la classe GestionDao.
	 */
	@Override
	public String connecter(String email, String mdp)
	{
		return GestionDao.connecter(email, mdp);
	}

	public void rechercherEtudiant(String chaine)
	{
		List<String> listeEtudiants = GestionDao.rechercherEtudiant(chaine);
		
		System.out.println("Etudiants trouvés :\n");
		System.out.println("ID | Nom | Prénom\n");
		
		listeEtudiants.stream()
			.filter(n -> n.contains(chaine))
			.forEach(System.out::println);
		
		System.out.println();
	}
}
