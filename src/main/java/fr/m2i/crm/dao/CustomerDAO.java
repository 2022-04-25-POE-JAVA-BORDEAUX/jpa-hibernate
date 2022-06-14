package fr.m2i.crm.dao;

import fr.m2i.crm.helper.SessionHelper;
import fr.m2i.crm.model.Customer;
import fr.m2i.crm.state.CustomerState;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CustomerDAO {

    public void create() {
        EntityManager entityManager = SessionHelper.getEntityManager();

        Customer customerToCreate = new Customer();
        customerToCreate.setAddress("une adresse");
        customerToCreate.setCity("une ville");
        customerToCreate.setCompanyName("Une company");
        customerToCreate.setCustomerState(CustomerState.ACTIVE);

        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(customerToCreate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
        }
    }

    public void update(Long id, Customer customerData) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Customer customerToUpdate = entityManager.find(Customer.class, id);

        if (customerToUpdate == null) {
            System.out.println("Le customer avec l'id:" + id + " n'existe pas");
            return;
        }

        customerToUpdate.setNotNullData(customerData);

        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(customerToUpdate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
        }
    }
}
