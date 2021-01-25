package org.uha.ensisa.fanfan.APIvols;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateVols {

	public static void main( String[ ] args ) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("APIvols");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Vol vol1 = new Vol("SXB123", "Strasbourg", "Paris", 1250);
		Vol vol2 = new Vol("SXB127", "Strasbourg", "Paris", 1420);
		Vol vol3 =new Vol("CDC129", "Poitiers", "Paris", 1710);

		entitymanager.persist(vol1);
		entitymanager.persist(vol2);
		entitymanager.persist(vol3);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}
