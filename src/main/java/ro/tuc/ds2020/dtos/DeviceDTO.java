package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;
import java.util.UUID;

public class DeviceDTO extends RepresentationModel<DeviceDTO> {
    private UUID id;
    private String name;
    private String manufacturer;
    private Integer year_manufacture;
    private Integer consumption;

    public DeviceDTO() {
    }

    public DeviceDTO(UUID id, String name, String manufacturer, Integer year_manufacture, Integer consumption) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.year_manufacture = year_manufacture;
        this.consumption = consumption;
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

    public Integer getConsumption() {
        return consumption;
    }

    public void setConsumption(Integer consumption) {
        this.consumption = consumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceDTO deviceDTO = (DeviceDTO) o;
        return name == deviceDTO.name &&
                Objects.equals(manufacturer, deviceDTO.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, name);
    }
}
