package org.rossijr;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.rossijr.database.JPAUtil;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        if (entityManager != null) {
            //UI logic here
            JPAUtil.closeEntityManagerFactory();
        }
    }
}
