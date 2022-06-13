package fr.m2i.crm.dao;

import fr.m2i.crm.helper.SessionHelper;
import fr.m2i.crm.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CustomerDAO {

    public List<Customer> findAll() {
        return SessionHelper.getEntityManager().createQuery("select c from Customer c").getResultList();
    }

    public Customer findById(int id) {
        return SessionHelper.getEntityManager().find(Customer.class, id);
    }

    public void create(Customer customer) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(customer);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Customer customer) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(customer);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
