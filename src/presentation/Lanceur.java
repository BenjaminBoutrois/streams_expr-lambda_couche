package presentation;

import java.util.Scanner;

import exceptions.BusinessServiceException;
import service.*;

/**
 * Classe Lanceur : repr�sente le point d'entr�e du programme.
 *
 */
public class Lanceur
{

	/**
	 * M�thode principale et point d'entr�e du programme.
	 * @param args Arguments pass�s au programme.
	 */
	public static void main(String[] args)
	{
		boolean connexion = false;
		
		Scanner sc = new Scanner(System.in);
		String requete = "-1";
		
		try
		{
			// Phase de connexion, n�cessite d'�tre responsable ou directeur
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
				System.out.println("MENU PRINCIPAL - Entrez un caract�re pour effectuer une action :");
				System.out.println("-------------------------------------------------\n");
				System.out.println("A. Cr�er un �tudiant");
				System.out.println("B. Associer un cours � un �tudiant");
				System.out.println("C. Lire les informations d'un �tudiant");
				System.out.println("D. Modifier l'adresse d'un �tudiant");
				System.out.println("E. Supprimer un �tudiant");
				System.out.println("F. Lister l'ensemble des �tudiants");
				System.out.println("G. Rechercher un �tudiant");
				System.out.println("Q. Quitter l'application");
				
				requete = sc.nextLine();
				switch(requete.toUpperCase())
				{
					case "A":
						// TODO : G�rer le cas o� il y a un apostrophe dans une des cha�nes de caract�res
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
