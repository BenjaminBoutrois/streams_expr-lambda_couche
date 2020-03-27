package presentation;

import java.util.Scanner;

import metier.Etudiant;
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
		
		String nom="";
		String prenom="";
		String mail="";
		String adresse="";
		String numero;
		String dateNaissance="";
		String cours="";
		String mdp="";
		Gestion gestion =  new Gestion();
		
		boolean connexion = false;
		
		Scanner sc = new Scanner(System.in);
		String requete = "-1";

		// Phase de connexion, n�cessite d'�tre responsable ou directeur
		System.out.println("Tapez votre email pour vous connecter");
		mail=sc.nextLine();
		
		System.out.println("Tapez votre mot de passe pour vous connecter");
		mdp=sc.nextLine();
		
		String role = gestion.connecter(mail, mdp);
		
		if(role.equals("directeur"))
		{
			System.out.println("Bienvenue monsieur le directeur");
			connexion = true;
		}
		else if(role.equals("responsable"))
		{
			System.out.println("Bienvenue monsieur le responsable");
			connexion = true;
		}
		else
		{
			System.out.println("");
		}
		
		try
		{
			// Tant que la personne ne quitte pas on continue
			while(requete.toUpperCase().trim() != "Q" && connexion == true)
			{
				System.out.println("MENU PRINCIPAL - Cliquez sur la touche associ�e pour effectuer une action");
				System.out.println("-------------------------------------------------\n");
				System.out.println("A. Cr�er un �tudiant");
				System.out.println("B. Associer un cours a un �tudiant");
				System.out.println("C. Lire les infos d'un �tudiant");
				System.out.println("D. Modifier l'adresse d'un �tudiant");
				System.out.println("E. Supprimer un �tudiant");
				System.out.println("F. Lister l'ensemble des etudiants");
				System.out.println("G. Rechercher un �tudiant");
				System.out.println("Q. Quitter le menu");
				
				requete = sc.nextLine();
				switch(requete.toUpperCase())
				{
					case "A":
						
						System.out.println("Nom de l'�tudiant ?");
						nom = sc.nextLine();
						System.out.println("Prenom de l'�tudiant ?");
						prenom = sc.nextLine();
						System.out.println("Mail de l'�tudiant ?");
						mail = sc.nextLine();
						System.out.println("Adresse de l'�tudiant ?");
						adresse = sc.nextLine();
						System.out.println("Telephone de l'�tudiant ?");
						numero = sc.nextLine();
						System.out.println("Date de naissance de l'�tudiant ?");
						dateNaissance = sc.nextLine();
						
						Etudiant etudiant=new Etudiant();
						etudiant.setNom(nom);
						etudiant.setPrenom(prenom);
						etudiant.setAdresse(adresse);
						etudiant.setMail(mail);
						etudiant.setDateNaissanceEtudiant(dateNaissance);
						etudiant.setTelephone(numero);
						
						gestion.creerEtudiant(etudiant);
						
						break;
						
					case "B":
						System.out.println("Entrer l'email de l'�tudiant ?");
						mail = sc.nextLine();
						System.out.println("Cours de l'�tudiant ?");
						cours = sc.nextLine();
						gestion.associerCoursEtudiant(mail,cours);
						break;
						
					case "C":
						System.out.println("Entrer l'email  de l'�tudiant ?");
						mail = sc.nextLine();
						gestion.lireEtudiant(mail);
						break;
						
					case "D":
						System.out.println("Entrer l'email  de l'�tudiant ?");
						mail = sc.nextLine();
						System.out.println("Adresse de l'�tudiant ?");
						adresse = sc.nextLine();
						gestion.modifierAdresseEtudiant(mail, adresse);
						break;
						
					case "E":
						System.out.println("Entrer l'email de l'�tudiant ?");
						mail = sc.nextLine();
						gestion.supprimerEtudiant(mail);
						break;
						
					case "F":
						if(role.equals("directeur"))
							gestion.listerEtudiants();
						else
							System.out.println("Vous n'avez pas les droits");
						break;
						
					case "G":
						if(role.equals("directeur"))
						{
							System.out.println("Entrer une cha�ne � chercher parmi les IDs," +
												" noms et pr�noms des �tudiants :");
							
							String chaine = sc.nextLine();
							gestion.rechercherEtudiant(chaine);
						}
						else
							System.out.println("Vous n'avez pas les droits");
						break;
						
					case "Q":
						System.out.println("A bient�t !");
						sc.close();
						System.exit(0);
					default:
						continue;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Message de l'exception : " + e.getMessage());
		}
	}

}
