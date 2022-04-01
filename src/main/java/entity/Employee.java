package entity;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name= "Employee")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName,lastName;

    @ElementCollection
    private Set<Address> addressSet = new HashSet<Address>();

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }
    //    @ElementCollection
//    @JoinTable(name="Employee_Address")
//    @GenericGenerator(name="sequence_gen", strategy = "sequence")
//    @CollectionId(columns = {@Column(name = "Address_Id")},generator = "sequence_gen" ,type = @Type(type = "long"))
//    private Collection<Address> addressSet = new ArrayList<>();
//
//    public Collection<Address> getAddressSet() {
//        return addressSet;
//    }
//
//    public void setAddressSet(Collection<Address> addressSet) {
//        this.addressSet = addressSet;
//    }

//    @Embedded
//    private Address address;
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
        @Embedded
    @AttributeOverrides({
       @AttributeOverride(name="city", column=@Column(name = "home_city")),
       @AttributeOverride(name="location", column=@Column(name = "home_location")),
       @AttributeOverride(name="pincode", column=@Column(name = "home_pincode")),
    })
    Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column=@Column(name = "office_city")),
            @AttributeOverride(name="location", column=@Column(name = "office_location")),
            @AttributeOverride(name="pincode", column=@Column(name = "office_pincode")),
    })
    Address officeAddress;




    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}