package queries;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ReadData {
    public static void main(String[] args) {
        //      step1 - to get session factory object
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
//step2: create seesion from session factory
        Session session = factory.getCurrentSession();
// for select-> first create query, execute query and get the result, iterate the result
        String hql = "from Employee";
        Query query = session.createQuery(hql);
        List result = query.list();
        Employee emp = (Employee)result.get(0);
        System.out.println(emp.getId());
        System.out.println(emp.getFirstName());
        System.out.println(emp.getLastName());
        System.out.println("successfully fetch");
        session.close();
        factory.close();

    }
}
