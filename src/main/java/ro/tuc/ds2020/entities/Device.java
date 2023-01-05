
package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;



@Entity
@Table(name="device")
public class Device {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Manufacturer")
    private String manufacturer;

    @Column(name = "Year_manufacture")
    private Integer year_manufacture;

    @Column(name = "Id_consumption")
    private Integer  id_consumption;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    public Device () {

    }

    public Device(UUID id, String name, String manufacturer, Integer year_manufacture, Integer consumption) {
        this.id=id;
        this.name=name;
        this.manufacturer=manufacturer;
        this.year_manufacture=year_manufacture;
        this.id_consumption = consumption;
    }

    public Device(String name, String manufacturer, Integer year_manufacture, Integer id_consumption) {
        this.name=name;
        this.manufacturer=manufacturer;
        this.year_manufacture=year_manufacture;
        this.id_consumption = id_consumption;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getYear_manufacture() {
        return year_manufacture;
    }

    public void setYear_manufacture(Integer year_manufacture) {
        this.year_manufacture = year_manufacture;
    }

    public Integer getId_consumption() {
        return id_consumption;
    }

    public void setId_consumption(Integer id_consumption) {
        this.id_consumption = id_consumption;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}