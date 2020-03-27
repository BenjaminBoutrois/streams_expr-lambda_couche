package metier;

/**
 * Classe Enseignant : représente un enseignant dans la base de données.
 * Spécification de la classe Personne.
 *
 */
public class Enseignant extends Personne{
	
	// Propriétés
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String adresse;
	private String telephone;
	private String matiere;
	
	/**
	 * Constructeur de la classe Enseignant.
	 * @param id Id de l'enseignant.
	 * @param nom Nom de l'enseignant.
	 * @param prenom Prénom de l'enseignant.
	 * @param mail Mail de l'enseignant.
	 * @param adresse Adresse de l'enseignant.
	 * @param telephone Numéro de téléphone de l'enseignant.
	 * @param matiere Matière de l'enseignant.
	 */
	public Enseignant(int id, String nom, String prenom, String mail,
			String adresse, String telephone, String matiere) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;
		this.telephone = telephone;
		this.matiere = matiere;
	}
	
	public String getMatiere() {
		return matiere;
	}
	
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	
	@Override
	public String toString() {
		return "Enseignant [id=" + id + ", nom=" + nom + ", prenom="
				+ prenom + ", mail=" + mail + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", matiere=" + matiere + "]";
	}
}
