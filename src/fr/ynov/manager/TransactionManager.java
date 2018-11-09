package fr.ynov.manager;

import javax.persistence.EntityManager;

import fr.ynov.models.Transaction;

public class TransactionManager extends BaseManager {
	
	public static void saveTransaction(Transaction transaction) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(transaction);
		em.getTransaction().commit();
	}

}
