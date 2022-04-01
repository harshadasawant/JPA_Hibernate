package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vehicle {
    @Id @GeneratedValue
    private int vehicleId;

    private String vehicleName;

//    if you add here then in vehicle table extra column will be created
//    @OneToOne(mappedBy = "user")
//    private User user;

//    @ManyToOne
//    @JoinColumn(name="USER_ID")
//    private User user;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//    @ManyToMany(mappedBy = "vehicleList")
//    private List<User> userList= new ArrayList<User>();
//
//    public List<User> getUserList() {
//        return userList;
//    }
//
//    public void setUserList(List<User> userList) {
//        this.userList = userList;
//    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}

