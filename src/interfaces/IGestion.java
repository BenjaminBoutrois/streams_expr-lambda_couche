package interfaces;

import metier.Etudiant;

/**
 * Crée les points d'entrée des fonctionnalités.
 *
 */
public interface IGestion {

	abstract Etudiant creerEtudiant (Etudiant email);
	
	abstract void lireEtudiant(String email);
	
	abstract String connecter(String email, String mdp);
	
	abstract void supprimerEtudiant(String email);
	
	abstract void modifierAdresseEtudiant(String email,String nouvelleAdresse);
	
	abstract void associerCoursEtudiant(String mailEtudiant,String theme);
	
	abstract void listerEtudiants();
	
}
