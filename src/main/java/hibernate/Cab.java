package hibernate;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cab")
public class Cab {
    @Column(unique = true)
    private String registrationNumber;

    @Id
    private int route;
    private String drivername;
    private long contact;

    @OneToMany(mappedBy = "cab", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Employee> employees = new ArrayList<>();

    public Cab(){}

    public Cab(String registrationNumber, int route, String drivername, long contact) {
        this.registrationNumber = registrationNumber;
        this.route = route;
        this.drivername = drivername;
        this.contact = contact;
    }

    public void setPassenger(List<Employee> employee){
        this.employees = employee;
    }

    public List<Employee> getPassenger( ){
        return employees;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }
}
