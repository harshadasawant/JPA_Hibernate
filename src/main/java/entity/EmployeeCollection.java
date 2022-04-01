package entity;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "EmployeeCollection")
public class EmployeeCollection {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName,lastName;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name="Employee_Address")
    @GenericGenerator(name="sequence_gen", strategy = "sequence")
    @CollectionId(columns = {@Column(name = "Address_Id")},generator = "sequence_gen" ,type = @Type(type = "long"))
    private List<Address> addressSet = new ArrayList<Address>();

    public List<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(List<Address> addressSet) {
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



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
