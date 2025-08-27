package embed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Subject sub1 = new Subject();
        sub1.setSubjId(2145);
        sub1.setSubjname("OS");
        sub1.setYear(3);

        Subject sub2 = new Subject();
        sub2.setSubjId(2146);
        sub2.setSubjname("HP");
        sub2.setYear(3);

        List<Subject> subjects = Stream.of(sub1, sub2).collect(Collectors.toList());
        Lecturer l1 = new Lecturer("Ramkumar",526654141L,subjects);

        session.persist(l1);
        session.getTransaction().commit();
        session.close();

    }
}
