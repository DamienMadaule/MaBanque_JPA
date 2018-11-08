package fr.ynov.manager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.ynov.models.Utilisateur;

public class UtilisateurManager extends BaseManager {
	public static void saveClient(Utilisateur utilisateur) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(utilisateur);
		em.getTransaction().commit();
	}
	
	public static Utilisateur loadClientByLogin(String utilisateurNom) {
		EntityManager em = getEntityManager();
		Utilisateur uti = em.find(Utilisateur.class, utilisateurNom);
		return uti;
	}
	public static Utilisateur LoadClientByLoginAndPassword(String login,String password) {
		EntityManager em = getEntityManager();
		TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login='"+login+"' and u.password ='"+password+"'",Utilisateur.class);
		try {
			Utilisateur uti = query.getSingleResult(); 
			return uti;
		} catch (Exception e) {
			System.out.println("erreur ici :");
			e.printStackTrace();
		}
		Utilisateur uti = null;
		return uti;
		

	}
	public static void updateClient(Utilisateur utilisateur) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(utilisateur);
		em.getTransaction().commit();
		
	}
	public static void purgeTable() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.createQuery("delete from Utilisateur").executeUpdate();
		
	}

}
