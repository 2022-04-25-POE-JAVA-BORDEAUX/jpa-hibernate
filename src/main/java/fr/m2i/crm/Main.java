package fr.m2i.crm;

import fr.m2i.crm.dao.CustomerDAO;

public class Main {

    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm");
//        EntityManager entityManager = emf.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//
//        try {
//            transaction.begin();
//
//            Query query = entityManager.createNativeQuery("SELECT * FROM customer");
//            query.getResultList();
//
//            transaction.commit();
//        } finally {
//            entityManager.close();
//            emf.close();
//        }

        CustomerDAO customerDAO = new CustomerDAO();
        System.out.println(customerDAO.findById(1).getCompanyName());
    }
}
