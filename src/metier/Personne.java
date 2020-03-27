package metier;

/*
 * Classe Personne : représente une personne dans la base de données.
 * Généralisation des classes Etudiant et Enseignant.
 */
public class Personne {
	
	// Propriétés
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String adresse;
	private String telephone;
	
	/**
	 * Constructeur par défaut de la classe Personne.
	 */
	public Personne() {	}
	
	/**
	 * Constructeur avec arguments de la classe Personne.
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param adresse
	 * @param telephone
	 */
	public Personne(int id, String nom, String prenom, String mail, String adresse, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	// Getters et Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", adresse=" + adresse
				+ ", telephone=" + telephone + "]";
	}
}
