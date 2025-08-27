package embed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbedExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Subject sub1 = new Subject();
        sub1.setSubjId(52656);
        sub1.setSubjname("OOPS");
        sub1.setYear(3);

        Subject sub2 = new Subject();
        sub2.setSubjId(52657);
        sub2.setSubjname("Algorithms");
        sub2.setYear(3);

        Professor p1 = new Professor("Raguraman",662262466L,sub1,sub2);
        session.persist(p1);

        session.getTransaction().commit();
        session.close();

    }
}
