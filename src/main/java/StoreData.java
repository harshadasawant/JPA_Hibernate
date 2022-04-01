
import entity.Address;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
    public static void main(String[] args) {
//        step1 - to get session factory object
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
//step2: create seesion from session factory
        Session session = factory.getCurrentSession();
//        step 3: create transaction from session
        Transaction t = session.beginTransaction();

        Employee e1=new Employee();
//        e1.setId(102);
        e1.setFirstName("Gaurav1");
        e1.setLastName("Chawla1");
        Address address = new Address();
        address.setCity("Mumbai");
        address.setLocation("location1");
        address.setPincode("400092");
//        e1.setAddress(address);
//        e1.setHomeAddress(address);
//        Address address1 = new Address();
//        address1.setCity("Mumbai");
//        address1.setLocation("Borivali");
//        address1.setPincode("400072");
//        e1.setOfficeAddress(address1);
//        e1.getAddressSet().add(address);
//        e1.getAddressSet().add(address1);
//step 4 : save u r object
        session.save(e1);
//        step5: commit the transaction
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
}
