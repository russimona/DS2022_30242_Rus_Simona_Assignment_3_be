package ro.tuc.ds2020.dtos;


import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

public class DeviceDetailsDTO {

    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String manufacturer;

    @NotNull
    private Integer year_manufacture;

    @NotNull
    private Integer  id_consumption;

    public DeviceDetailsDTO() {
    }

    public DeviceDetailsDTO(String name, String manufacturer, Integer year_manufacture, Integer consumption) {
        this.name=name;
        this.manufacturer=manufacturer;
        this.year_manufacture=year_manufacture;
        this.id_consumption = consumption;

    }

    public DeviceDetailsDTO(UUID id, String name, String manufacturer, Integer year_manufacture, Integer consumption) {
        this.id=id;
        this.name=name;
        this.manufacturer=manufacturer;
        this.year_manufacture=year_manufacture;
        this.id_consumption = consumption;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceDetailsDTO that = (DeviceDetailsDTO) o;
        return name == that.name &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(year_manufacture, that.year_manufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, manufacturer, year_manufacture);
    }

}
