package fr.ynov.manager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.ynov.models.Compte;

public class CompteManager extends BaseManager {
	public static void saveCompte(Compte compte) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(compte);
		em.getTransaction().commit();
	}
	
	public static Compte loadCompteByid(int compteId) {
		EntityManager em = getEntityManager();
		Compte compte = em.find(Compte.class, compteId);
		return compte;
	}
	
	public static void purgeTable() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.createQuery("delete from Compte").executeUpdate();
		
	}

}
