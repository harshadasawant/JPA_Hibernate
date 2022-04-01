//package queries;
//
//import entity.User;
//import entity.Vehicle;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//public class ReadUser {
//    public static void main(String[] args) {
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
//                buildSessionFactory();
//
//        Session session = factory.getCurrentSession();
//        Transaction t = session.beginTransaction();
//        User user = session.get(User.class, 3);
//        System.out.println(user.getName());
////        for(Vehicle vehicle: user.getVehicleList()){
////            System.out.println(vehicle.getVehicleId());
////            System.out.println(vehicle.getVerhicleName());
////        }
//
//        Vehicle vehicle  = session.get(Vehicle.class, 1);
//        System.out.println("=================================");
//        System.out.println(vehicle.getVerhicleName()+"  "+vehicle.getUser().getName());
//        t.commit();
//        session.close();
//        factory.close();
//    }
//}
