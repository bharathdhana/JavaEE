package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistCRUD {
    public static void main(String[] args) {
        //Entity Manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();

        // Transient begin
        em.getTransaction().begin();

        // Transient state
//        Customer customer = new Customer();
//        customer.setFullName("ram");
//        customer.setUserName("ramcl");
//        customer.setAadhar(Long.parseLong("5661616465"));
//        customer.setEmail("ram@gmail.com");
//        customer.setMonthlyIncome(55000);
//        em.persist(customer);


        //Read state
//        Customer exist = em.find(Customer.class,"ramclient");
//        System.out.println(exist);


   //   update
//        exist.setMonthlyIncome(100000);


        //remove state

//        em.remove(exist);

        // Transaction end - commit
        em.getTransaction().commit();
        em.close();
    }
}
