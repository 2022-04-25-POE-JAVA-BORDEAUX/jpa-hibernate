package fr.m2i.crm.dao;

import fr.m2i.crm.helper.SessionHelper;
import fr.m2i.crm.model.Customer;
import fr.m2i.crm.state.CustomerState;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CustomerDAO {

    public Customer findById(Long id) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Customer customerFounded = entityManager.find(Customer.class, id);

        if (customerFounded == null) {
            System.out.println("Attention le customer avec l'id: " + id + " n'existe pas !");
        }

        return customerFounded;
    }

    public void create(Customer customerToCreate) {
        // On vérifie les données que l'on reçoit en paramètre
        if (customerToCreate == null) {
            System.out.println("L'objet customer ne peut pas être null");
            return;
        }

        EntityManager entityManager = SessionHelper.getEntityManager();

        // On déclare notre transaction avec pour valeur par défaut null
        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(customerToCreate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
            if (tx != null) {
                // Une erreur est survenue, on discard les actions entamés dans la transaction
                tx.rollback();
            }
        }
    }

    // Différente manière pour l'update :
    // public void update(Long id, String address, String city, String companyName, ........) {
    // => utiliser l'id en paramètre pour récupérer le customer que l'on souhaite modifier
    // puis set les données :
    // ...
    // customerToUpdate.setAddress(address);
    // customerToUpdate.setCity(address);
    // customerToUpdate.setCompanyName(address);
    // ...

    // Différente manière pour l'update :
    // public void update(Long id, Customer customerData) {
    // => utiliser l'id en paramètre pour récupérer le customer que l'on souhaite modifier
    // puis set les données :
    // ...
    // customerToUpdate.setNotNullData(customerData); -> on set les données uniquement si elle ne sont pas null
    // ...

    // Différente manière pour l'update :
    // public void update(Customer customerData) {
    // => utiliser customer.getId(); pour récupérer le customer que l'on souhaite modifier
    // puis set les données :
    // ...
    // customerToUpdate.setNotNullData(customerData); -> on set les données uniquement si elle ne sont pas null
    // ...

    public void update(Long id, Customer customerData) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        // On récupère le customer qu'on souhaite modifier
        Customer customerToUpdate = entityManager.find(Customer.class, id);

        // Si le customer n'existe pas on ne fait pas d'update
        if (customerToUpdate == null) {
            System.out.println("Le customer avec l'id:" + id + " n'existe pas");
            return;
        }

        // on set les données uniquement si elle ne sont pas null
        customerToUpdate.setNotNullData(customerData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(customerToUpdate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
