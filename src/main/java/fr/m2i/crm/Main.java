package fr.m2i.crm;

import fr.m2i.crm.helper.SessionHelper;

import javax.persistence.*;

public class Main {

    public static void main(String[] args) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        // some action with jpa with DAO

        entityManager.close();
    }
}
