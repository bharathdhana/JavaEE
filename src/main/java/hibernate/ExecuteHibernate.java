package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecuteHibernate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Employee employee = new Employee(1001,"alex","benjamin","alex@gmail.com");
        Employee employee1 = new Employee(1002,"chris","hemsworth","hems@gmail.com");
        Employee employee2 = new Employee(1003,"tom","clank","clank@gmail.com");
        List<Employee> emps = Stream.of(employee,employee1,employee2).collect(Collectors.toList());

        Cab cab= new Cab("TN28DA2561",35,"Dennis",25141616);
        cab.setPassenger(emps);

        employee.setCab(cab);
        employee1.setCab(cab);
        employee2.setCab(cab);

        session.persist(cab);
        tx.commit();
        session.close();

    }
}
