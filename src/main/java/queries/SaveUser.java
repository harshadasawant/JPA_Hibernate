package queries;

import entity.User;
import entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction t = session.beginTransaction();
        User user = new User();
        user.setName("Harshada");
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("BMW");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("skoda");
        user.getVehicleList().add(vehicle);
//        vehicle.setUser(user);
//        vehicle1.setUser(user);
        user.getVehicleList().add(vehicle1);
//        user.setVehicle(vehicle);
        session.save(user);
        session.save(vehicle);
        session.save(vehicle1);
        t.commit();
        System.out.println("successfully saved");
        session.close();
        factory.close();
    }
}
