package org.uha.ensisa.fanfan.APIvols;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindVols {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("APIvols");
		EntityManager entitymanager = emfactory.createEntityManager();
        Query query = entitymanager.createQuery("from Vol v", Vol.class);

		System.out.println(query.getResultList());
	}
}
