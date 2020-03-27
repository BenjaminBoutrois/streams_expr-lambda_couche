package service;

import java.util.Scanner;

import exceptions.BusinessServiceException;
import metier.Etudiant;

public class GestionScanner
{
	public static String seConnecter(Scanner sc) throws BusinessServiceException
	{
		String role = "";
		String mail, mdp;
		
		while(true)
		{
			System.out.println("Tapez votre email pour vous connecter : ");
			mail = sc.nextLine();
			
			System.out.println("Tapez votre mot de passe pour vous connecter : ");
			mdp = sc.nextLine();
			
			role = GestionEcole.connecter(mail, mdp);
			
			if ( role.equals("directeur") || role.equals("responsable"))
				break;
			else
				System.out.println("Identifiants incorrects.\n");
		}
		
		return role;
	}
	
	public static void creerEtudiant(Scanner sc) throws BusinessServiceException
	{
		String nom, prenom, mail, adresse, numero, dateNaissance;
		
		System.out.println("Nom de l'étudiant ?");
		nom = sc.nextLine();
		
		System.out.println("Prenom de l'étudiant ?");
		prenom = sc.nextLine();
		
		System.out.println("Mail de l'étudiant ?");
		mail = sc.nextLine();
		
		System.out.println("Adresse de l'étudiant ?");
		adresse = sc.nextLine();
		
		System.out.println("Telephone de l'étudiant ?");
		numero = sc.nextLine();
		
		System.out.println("Date de naissance de l'étudiant ?");
		dateNaissance = sc.nextLine();
		
		Etudiant etudiant=new Etudiant();
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setAdresse(adresse);
		etudiant.setMail(mail);
		etudiant.setDateNaissanceEtudiant(dateNaissance);
		etudiant.setTelephone(numero);
		
		GestionEcole.creerEtudiant(etudiant);
	}
	
	public static void associerCoursEtudiant(Scanner sc) throws BusinessServiceException
	{
		String mail, cours;
		
		System.out.println("Entrer l'email de l'étudiant ?");
		mail = sc.nextLine();
		
		System.out.println("Cours de l'étudiant ?");
		cours = sc.nextLine();
		
		GestionEcole.associerCoursEtudiant(mail,cours);
	}
	
	public static void lireEtudiant(Scanner sc) throws BusinessServiceException
	{
		String mail;
		
		System.out.println("Entrer l'email  de l'étudiant ?");
		mail = sc.nextLine();
		
		GestionEcole.lireEtudiant(mail);
	}
	
	public static void modifierEtudiant(Scanner sc) throws BusinessServiceException
	{
		String mail, adresse;
		
		System.out.println("Entrer l'email  de l'étudiant ?");
		mail = sc.nextLine();
		
		System.out.println("Adresse de l'étudiant ?");
		adresse = sc.nextLine();
		
		GestionEcole.modifierAdresseEtudiant(mail, adresse);
	}
	
	public static void supprimerEtudiant(Scanner sc) throws BusinessServiceException
	{
		String mail;
		
		System.out.println("Entrer l'email de l'étudiant ?");
		mail = sc.nextLine();
		
		GestionEcole.supprimerEtudiant(mail);
	}
	
	public static void listerEtudiants(Scanner sc, String role) throws BusinessServiceException
	{
		if(role.equals("directeur"))
			GestionEcole.listerEtudiants();
		else
			System.out.println("Vous n'avez pas les droits");
	}
	
	public static void rechercherEtudiants(Scanner sc, String role) throws BusinessServiceException
	{
		if(role.equals("directeur"))
		{
			System.out.println("Entrer une chaîne à chercher parmi les IDs," +
								" noms et prénoms des étudiants :");
			
			String chaine = sc.nextLine();
			GestionEcole.rechercherEtudiant(chaine);
		}
		else
			System.out.println("Vous n'avez pas les droits");
	}
	
	public static void quitterMenu(Scanner sc)
	{
		System.out.println("A bientôt !");
		sc.close();
		System.exit(0);
	}
}
