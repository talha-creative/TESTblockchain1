package models;

public class Personne<role> {
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private role role;
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personne(int id, String nom, String prenom, String email, String mdp, role role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.role = role;
	}
	public Personne(String nom, String prenom, String email, String mdp, role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.role = role;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public role getRole() {
		return role;
	}
	public void setRole(role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp
				+ ", role=" + role + "]";
	}
	public Object getrole() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setrole1(models.role comit) {
		// TODO Auto-generated method stub
		
	}
	public void setrole(models.role admin) {
		// TODO Auto-generated method stub
		
	}
	
	

}