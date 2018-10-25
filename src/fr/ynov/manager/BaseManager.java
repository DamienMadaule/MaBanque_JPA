package fr.ynov.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseManager {

	private static final String UNIT_NAME = "MaBanque_JPA";
	private static EntityManagerFactory factory;
	
	protected static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		}
		return factory;
	}
	public static void shutdown() {
		if(factory!=null) {
			factory.close();
		}
	}
		public static EntityManager getEntityManager() {
			EntityManagerFactory factory = getEntityManagerFactory();
			return factory.createEntityManager();
		}
		
}
