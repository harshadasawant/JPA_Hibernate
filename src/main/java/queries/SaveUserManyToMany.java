package queries;

import entity.User1;
import entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class SaveUserManyToMany {
    public static void main(String[] args) {
            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory();

            Session session = factory.getCurrentSession();
            Transaction t = session.beginTransaction();
            User1 user = new User1();
            user.setName("Harshada");

            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleName("BMW1");

            Vehicle vehicle1 = new Vehicle();
            vehicle1.setVehicleName("skoda1");

            user.getVehicleList().add(vehicle);
            user.getVehicleList().add(vehicle1);

            vehicle.getUserList().add(user);
            vehicle1.getUserList().add(user);

//            session.save(user);
//            session.save(vehicle);
//            session.save(vehicle1);

//         Criteria criteria = session.createCriteria(Vehicle.class);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Vehicle> cr = cb.createQuery(Vehicle.class);
        Root<Vehicle> root = cr.from(Vehicle.class);
        cr.select(root);

        Query<Vehicle> query = session.createQuery(cr);
        List<Vehicle> results = query.getResultList();

        System.out.println(results.get(0).getVehicleName());

            session.persist(user);
            t.commit();
            System.out.println("successfully saved");
            session.close();
            factory.close();
    }
}
