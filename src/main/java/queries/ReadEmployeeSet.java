package queries;

import entity.Address;
import entity.EmployeeCollection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployeeSet {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeCollection.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        EmployeeCollection emp = session.get(EmployeeCollection.class,1);
        System.out.print(emp.getId());
        System.out.print("       "+emp.getFirstName());
        System.out.println("       "+emp.getLastName());
        System.out.println(" Employee Address ");
        session.close();
        for(Address address : emp.getAddressSet() ){
            System.out.print(address.getCity()+"    ");
            System.out.print(address.getLocation()+"    ");
            System.out.println(address.getPincode());
        }

        System.out.println("successfully fetch");
        session.close();
        factory.close();

    }
}
