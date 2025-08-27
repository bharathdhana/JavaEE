package inheritance;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.stream.Stream;

public class InheritanceExecution {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Drive drive = new Drive();
        drive.setEmail("demo@gmail.com");
        drive.setFreeSpace(10);
        drive.setTotalSpace(100);
        drive.setName("demo");

        Youtube youtube = new Youtube();
        youtube.setName("Podcast");
        youtube.setEmail("pods@gmail.com");
        youtube.setPlayList(Stream.of("feelgood","education","bollywood").toList());

        session.persist(drive);
        session.persist(youtube);

        session.getTransaction().commit();
        session.close();


    }
}
