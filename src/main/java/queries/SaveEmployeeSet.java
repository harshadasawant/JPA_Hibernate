package queries;

import entity.Address;
import entity.EmployeeCollection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployeeSet {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeCollection.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction t = session.beginTransaction();

        EmployeeCollection e1=new EmployeeCollection();
//        e1.setId(1);
        e1.setFirstName("Gaurav1");
        e1.setLastName("Chawala1");
        Address address = new Address();
        address.setCity("Mumbai");
        address.setLocation("location1");
        address.setPincode("400092");
        e1.getAddressSet().add(address);
        Address address1 = new Address();
        address1.setCity("Mumbai");
        address1.setLocation("Borivali");
        address1.setPincode("400072");
        e1.getAddressSet().add(address1);

        session.save(e1);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();

    }
}
