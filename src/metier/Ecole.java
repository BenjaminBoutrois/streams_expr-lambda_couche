package metier;

/**
 * Classe Ecole : représente une école dans la base de données.
 *
 */
public class Ecole {
	
	private String nomEcole;
	private String mailEcole;
	private String adresseEcole;
	private String telephoneEcole;
	private String directeurEcole;
	
	/**
	 * Constructeur de la classe Ecole.
	 * @param nomEcole Nom de l'école.
	 * @param mailEcole Mail de l'école.
	 * @param adresseEcole Adresse de l'école.
	 * @param telephoneEcole Numéro de téléphone de l'école.
	 * @param directeurEcole Directeur de l'école.
	 */
	public Ecole(String nomEcole, String mailEcole, String adresseEcole, String telephoneEcole, String directeurEcole) {
		super();
		this.nomEcole = nomEcole;
		this.mailEcole = mailEcole;
		this.adresseEcole = adresseEcole;
		this.telephoneEcole = telephoneEcole;
		this.directeurEcole = directeurEcole;
	}

	// Getters et Setters
	public String getNomEcole() {
		return nomEcole;
	}

	public void setNomEcole(String nomEcole) {
		this.nomEcole = nomEcole;
	}

	public String getMailEcole() {
		return mailEcole;
	}

	public void setMailEcole(String mailEcole) {
		this.mailEcole = mailEcole;
	}

	public String getAdresseEcole() {
		return adresseEcole;
	}

	public void setAdresseEcole(String adresseEcole) {
		this.adresseEcole = adresseEcole;
	}

	public String getTelephoneEcole() {
		return telephoneEcole;
	}

	public void setTelephoneEcole(String telephoneEcole) {
		this.telephoneEcole = telephoneEcole;
	}

	public String getDirecteurEcole() {
		return directeurEcole;
	}

	public void setDirecteurEcole(String directeurEcole) {
		this.directeurEcole = directeurEcole;
	}

	@Override
	public String toString() {
		return "Ecole [nomEcole=" + nomEcole + ", mailEcole=" + mailEcole + ", adresseEcole=" + adresseEcole
				+ ", telephoneEcole=" + telephoneEcole + ", directeurEcole=" + directeurEcole + "]";
	}
}
