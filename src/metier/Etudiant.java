package metier;

/**
 * Classe Etudiant : représente un étudiant dans la base de données.
 * Spécification de la classe Personne.
 *
 */
public class Etudiant extends Personne {

	// Propriétés
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String adresse;
	private String telephone;
	private String dateNaissanceEtudiant;

	/**
	 * Constructeur par défaut de la classe Etudiant.
	 */
	public Etudiant() {}
	
	/**
	 * Constructeur avec arguments de la classe Etudiant.
	 * @param id Id de l'étudiant.
	 * @param nom Nom de l'étudiant.
	 * @param prenom Prénom de l'étudiant.
	 * @param mail Mail de l'étudiant.
	 * @param adresse Adresse de l'étudiant.
	 * @param telephone Numéro de téléphone de l'étudiant.
	 * @param dateNaissanceEtudiant Date de naissance de l'étudiant.
	 */
	public Etudiant(int id, String nom, String prenom, String mail,
			String adresse, String telephone, String dateNaissanceEtudiant) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
	}

	public int getIdEtudiant() {
		return id;
	}
	
	public void setIdEtudiant(int idEtudiant) {
		this.id = idEtudiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getDateNaissanceEtudiant() {
		return dateNaissanceEtudiant;
	}

	public void setDateNaissanceEtudiant(String dateNaissanceEtudiant) {
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
	}

	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
				+ ", adresse=" + adresse + ", telephone=" + telephone + ", dateNaissanceEtudiant="
				+ dateNaissanceEtudiant + "]";
	}
}
