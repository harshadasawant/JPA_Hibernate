package queries;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class getDataFromSession {
    public static void main(String[] args) {
        //      step1 - to get session factory object
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
//step2: create seesion from session factory
        Session session = factory.getCurrentSession();
// for select-> first create query, execute query and get the result, iterate the result
       session.beginTransaction();
       Employee emp = session.get(Employee.class,1);
        System.out.print(emp.getId());
        System.out.print("       "+emp.getFirstName());
        System.out.println("       "+emp.getLastName());
        System.out.println("successfully fetch");
        session.close();
        factory.close();

    }
}
