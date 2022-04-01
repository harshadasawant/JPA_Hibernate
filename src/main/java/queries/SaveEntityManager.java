package queries;

import entity.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class SaveEntityManager {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Audi");
        entityManager.persist(vehicle);

        Query query = entityManager.createQuery("Select UPPER(e.name) from User1 e");
        List<String> list = query.getResultList();
        for(String name:list){
            System.out.println("===============name===============");
            System.out.println(name);
        }
//        Query query = entityManager.createQuery("UPDATE User u SET u.name = :name where u.id = :id");
//        query.setParameter("name", "Teju");
//        query.setParameter("id", 7);
//        int rowsUpdated = query.executeUpdate();
//        System.out.println("=====================rowsUpdated ==="+rowsUpdated);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
