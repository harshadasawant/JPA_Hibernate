package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;

//    @OneToOne
//    @JoinColumn(name="VEHICLE_ID")
//    private Vehicle vehicle;

//    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    @OneToMany
//    @JoinColumn(name = "user_id")
//    @JoinTable(name="User_Vehicle", joinColumns = @JoinColumn(name="USER_ID"),
//            inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
//    @OneToMany(mappedBy = "user")
//    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();
//
//    public List<Vehicle> getVehicleList() {
//        return vehicleList;
//    }
//
//    public void setVehicleList(List<Vehicle> vehicleList) {
//        this.vehicleList = vehicleList;
//    }


    @ManyToMany(cascade = CascadeType.PERSIST)
//    @ManyToMany
    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

}
