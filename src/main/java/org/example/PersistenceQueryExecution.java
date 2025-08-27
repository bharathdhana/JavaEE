package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.Arrays;
import java.util.List;

public class PersistenceQueryExecution {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //Read All Customers via JPQL
//        Query query = (Query) em.createQuery("from Customer", Customer.class);
//        List<Customer> customers = query.getResultList();
//        System.out.println(customers);

        // Read All Customers name via JPQL
//        Query query = (Query) em.createQuery("select FullName from Customer", String.class);
//        List<Customer> customers = query.getResultList();
//        System.out.println(customers);


        //Read All Customers via SQL name, tablename and columns
//        Query query = (Query) em.createNativeQuery("select client_name from clients",String.class);
//        List<String> customers = query.getResultList();
//        System.out.println(customers);


        //Read All Customers name and salary via JPQL
//        Query query =(Query) em.createQuery("select FullName,MonthlyIncome from Customer", Object[].class);
//        List<Object[]> customers = query.getResultList();
//        for(Object[] obj : customers) {
//            System.out.println(Arrays.toString(obj));
//        }


        //Read Specific Rows
        Query query = (Query) em.createQuery("from Customer where MonthlyIncome between :start and :end", Customer.class);
        query.setParameter("start",40000);
        query.setParameter("end",90000);
        List<Customer> customers = query.getResultList();
        System.out.println(customers);


        em.getTransaction().commit();
        em.close();

    }
}
