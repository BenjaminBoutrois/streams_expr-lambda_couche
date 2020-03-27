package presentation;

import java.util.Scanner;

import exceptions.BusinessServiceException;
import service.*;

/**
 * Classe Lanceur : représente le point d'entrée du programme.
 *
 */
public class Lanceur
{

	/**
	 * Méthode principale et point d'entrée du programme.
	 * @param args Arguments passés au programme.
	 */
	public static void main(String[] args)
	{
		boolean connexion = false;
		
		Scanner sc = new Scanner(System.in);
		String requete = "-1";
		
		try
		{
			// Phase de connexion, nécessite d'être responsable ou directeur
			String role = GestionScanner.seConnecter(sc);
			
			if(role.equals("directeur"))
			{
				System.out.println("Bienvenue, monsieur le directeur.");
				connexion = true;
			}
			else if(role.equals("responsable"))
			{
				System.out.println("Bienvenue, monsieur le responsable.");
				connexion = true;
			}
			else
			{
				System.out.println("");
			}
		
			// Tant que la personne ne quitte pas on continue
			while(requete.toUpperCase().trim() != "Q" && connexion == true)
			{
				System.out.println("MENU PRINCIPAL - Entrez un caractère pour effectuer une action :");
				System.out.println("-------------------------------------------------\n");
				System.out.println("A. Créer un étudiant");
				System.out.println("B. Associer un cours à un étudiant");
				System.out.println("C. Lire les informations d'un étudiant");
				System.out.println("D. Modifier l'adresse d'un étudiant");
				System.out.println("E. Supprimer un étudiant");
				System.out.println("F. Lister l'ensemble des étudiants");
				System.out.println("G. Rechercher un étudiant");
				System.out.println("Q. Quitter l'application");
				
				requete = sc.nextLine();
				switch(requete.toUpperCase())
				{
					case "A":
						// TODO : Gérer le cas où il y a un apostrophe dans une des chaînes de caractères
						GestionScanner.creerEtudiant(sc);
						break;
						
					case "B":
						GestionScanner.associerCoursEtudiant(sc);
						break;
						
					case "C":
						GestionScanner.lireEtudiant(sc);
						break;
						
					case "D":
						GestionScanner.modifierEtudiant(sc);
						break;
						
					case "E":
						GestionScanner.supprimerEtudiant(sc);
						break;
						
					case "F":
						GestionScanner.listerEtudiants(sc, role);
						break;
						
					case "G":
						GestionScanner.rechercherEtudiants(sc, role);
						break;
						
					case "Q":
						GestionScanner.quitterMenu(sc);
						
					default:
						continue;
				}
			}
		}
		catch (BusinessServiceException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
