package fr.m2i.crm;

import fr.m2i.crm.dao.CustomerDAO;
import fr.m2i.crm.helper.SessionHelper;
import fr.m2i.crm.model.Customer;
import fr.m2i.crm.model.Order;
import fr.m2i.crm.state.CustomerState;

import javax.persistence.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        // some action with jpa with DAO
        CustomerDAO customerDAO = new CustomerDAO();

//        List<Customer> customerList = customerDAO.findAll();
//
//        for (Customer customer : customerList) {
//            System.out.println("company_name: " + customer.getCompanyName());
//
//            for (Order order : customer.getOrderList()) {
//                System.out.println("order designation:" + order.getDesignation());
//            }
        }

//        Customer customer = customerDAO.findById(2L);
//
//        if (customer != null) {
//            System.out.println("company_name: " + customer.getCompanyName());
//        }

//        Customer newCustomer = new Customer();
//        newCustomer.setAddress("1 rue de la paix");
//        newCustomer.setCity("Paris");
//        newCustomer.setCompanyName("Le nom de mon entreprise");
//        newCustomer.setCountry("France");
//        newCustomer.setCustomerState(CustomerState.INACTIVE);
//        newCustomer.setEmail("new-customer@email.com");
//        newCustomer.setFirstname("New");
//        newCustomer.setLastname("Customer");
//        newCustomer.setPhone("0612121212");
//        newCustomer.setZipCode("75001");
//
//        customerDAO.create(newCustomer);
//
//        Customer otherCustomer = null;
//        customerDAO.create(otherCustomer);

//        Customer customerData = new Customer();
//        customerData.setCompanyName("Mon nouveau nom d'entreprise");
//
//        // Attention sur l'id qu'on envoi ici
//        customerDAO.update(3L, customerData);

        entityManager.close();
    }
}
