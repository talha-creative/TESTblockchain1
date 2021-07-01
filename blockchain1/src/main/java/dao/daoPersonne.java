package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Personne;
import models.role;

public class daoPersonne {
	
	/*public static int inscription(Personne p) throws ClassNotFoundException, SQLException {
			String role=null;
			if(p.getRole().equals(Role.ADMIN)) {
				role="admin";
			}else if(p.getRole().equals(Role.ytilisateur)) {
				role="comit";
			}else {
				role="auteur";
			}
			Connexion.Connect();
			int res = Connexion.Maj("INSERT INTO `personne`(`nom`, `prenom`, `email`, `mdp`, `role`) VALUES ('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getEmail()+"','"+p.getMdp()+"','"+role+"')");
			Connexion.Disconnect();
			return res;
	}*/
	
	public static int AjouterEtudiant(Personne p) throws ClassNotFoundException, SQLException {
		connexion.Connect();
		int res = connexion.Maj("INSERT INTO `personne`(`nom`, `prenom`, `email`, `mdp`, `role`) VALUES ('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getEmail()+"','"+p.getMdp()+"','utilisateur')");
		connexion.Disconnect();
		return res;
	}
		
	public static boolean PersonneExiste(String email) throws ClassNotFoundException, SQLException {
		boolean exist = false ;
		connexion.Connect();
		ResultSet res = connexion.Select("select * from personne where email='"+email+"'");
		if(res.next()) {
			exist=true;
		}
		connexion.Disconnect();
		return exist;
	}
	
	public static Personne authentification(String login,String password) throws SQLException, ClassNotFoundException {
		ResultSet res = null;
		Personne p=null;
		connexion.Connect();
		res = connexion.Select("select * from personne where email='"+login+"' and mdp='"+password+"'");
		if(res.next()) {
			p=new Personne(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), null);
			if(res.getString(6).equals("utilisateur")) {
				p.setrole(role.COMIT);
			} else if(res.getString(6).equals("admin")) {
				p.setrole(role.ADMIN);
			}else {
				p.setrole(role.AUTEUR);
			}
		}
		connexion.Disconnect();
		return p;
	}

	public static ArrayList<Personne> listeAuteur() {
		// TODO Auto-generated method stub
		return null;
	}

	
}