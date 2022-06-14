package fr.m2i.crm;

import fr.m2i.crm.dao.CustomerDAO;
import fr.m2i.crm.helper.SessionHelper;
import fr.m2i.crm.model.Customer;
import fr.m2i.crm.state.CustomerState;

import javax.persistence.*;

public class Main {

    public static void main(String[] args) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        // some action with jpa with DAO
        CustomerDAO customerDAO = new CustomerDAO();
//        customerDAO.create();

        Customer customerData = new Customer();
        customerData.setZipCode("75001");

        customerDAO.update(2L, customerData);

        entityManager.close();
    }
}
