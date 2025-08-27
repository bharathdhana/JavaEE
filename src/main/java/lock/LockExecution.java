package lock;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LockExecution {
    public static void debt(int required, String app) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try{
            System.out.println(app+"trying debit");
            SavingsAccount exist = session.find(SavingsAccount.class,1L, LockMode.PESSIMISTIC_WRITE);
            System.out.println(app+"debt holded");
            if(exist.getBalance()>=required){
                exist.setBalance(exist.getBalance()-required);
                System.out.println(required+"debt successful"+app);
            }
            tx.commit();
            System.out.println(app+"account release");
        } catch (Exception e) {
            tx.rollback();
            System.out.println(app+"debt failed"+app);
        }
        session.close();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(()-> debt(500,"gpay"));
        Thread thread2 = new Thread(()-> debt(15000,"phonepe"));

        thread1.start();
        try{
            thread2.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread2.start();
    }
}
