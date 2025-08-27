package htcl;

import org.example.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;

public class HiberTransactExecution {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        SessionFactoryImpl sessionFactory=(SessionFactoryImpl)factory;
        EventListenerRegistry registry= sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);


        TransactionListener transactionListener = new TransactionListener();
        registry.appendListeners(EventType.POST_INSERT,transactionListener);
        registry.appendListeners(EventType.POST_UPDATE,transactionListener);
        registry.appendListeners(EventType.POST_DELETE,transactionListener);

        Session session= factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            //insertion
//            Customer customer = new Customer("Anand","anandtcs",24641646146L,"anand@gmail.com",40000);
//            session.persist(customer);
//            tx.commit();
//            System.out.println("Customer has been persisted successfully");


            //read and update
//            Customer exists= session.find(Customer.class,"vimalclient");
//            exists.setMonthlyIncome(80000);
//            tx.commit();

            //remove
            Customer toDelete = session.find(Customer.class,"mohanclient");
            session.remove(toDelete);
            tx.commit();


        }
        catch (Exception e){
            tx.rollback();
            System.out.println("Rolling back");
        }
        session.close();
        factory.close();
    }
}
