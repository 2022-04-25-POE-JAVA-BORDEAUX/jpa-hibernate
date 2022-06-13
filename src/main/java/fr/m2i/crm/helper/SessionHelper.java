package fr.m2i.crm.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionHelper {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {

        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm");
            entityManager = emf.createEntityManager();
        }

        return entityManager;
    }
}
