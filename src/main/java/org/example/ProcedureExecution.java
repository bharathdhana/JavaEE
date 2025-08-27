package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProcedureExecution {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Procedure Call
        List<Customer> filter= em.createNamedStoredProcedureQuery("Customer.getMonthlyIncome").setParameter("income",500000).getResultList();
        System.out.println(filter);

        em.getTransaction().commit();
        em.close();

    }
}
