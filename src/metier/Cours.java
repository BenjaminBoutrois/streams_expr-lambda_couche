package metier;

/**
 * Classe Cours : représente un cours à l'école.
 *
 */
public class Cours {
	
	private String theme;
	private int nombreHeures;
	
	/**
	 * Constructeur de la classe Cours.
	 * @param theme Thème du cours.
	 * @param nombreHeures Nombre d'heures de ce cours.
	 */
	public Cours(String theme, int nombreHeures) {
		super();
		this.theme = theme;
		this.nombreHeures = nombreHeures;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getNombreHeures() {
		return nombreHeures;
	}

	public void setNombreHeures(int nombreHeures) {
		this.nombreHeures = nombreHeures;
	}

	@Override
	public String toString() {
		return "Cours [theme=" + theme + ", nombreHeures=" + nombreHeures + "]";
	}
}
