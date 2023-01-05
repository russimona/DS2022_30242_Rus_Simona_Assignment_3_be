package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
public class User  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name= "surname", nullable = false)
    private String surname;

    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "role_user", nullable = false)
    private String role_user;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Device> deviceList;

    @Column(name = "password", nullable = false)
    private String password;



    public User() {
    }

    public User(String name, String surname, String email, String role_user,String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role_user = role_user;
        this.password = password;
    }

    public User(String name, String surname, String email, String role_user,String password, List<Device> devices) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role_user = role_user;
        this.password = password;
        this.deviceList = devices;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole_user() {
        return role_user;
    }

    public void setRole_user(String address) {
        this.role_user = address;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }
}
