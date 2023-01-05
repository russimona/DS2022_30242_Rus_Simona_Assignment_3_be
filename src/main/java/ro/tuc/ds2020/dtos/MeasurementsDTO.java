package ro.tuc.ds2020.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.boot.model.source.spi.IdentifierSource;
import org.springframework.hateoas.RepresentationModel;


import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementsDTO extends RepresentationModel<MeasurementsDTO> {

    private UUID id;
    private Integer consumption;
    private Timestamp timestamp;
    private UUID deviceId;

    public MeasurementsDTO(Integer consumption, Timestamp timestamp, UUID deviceId) {
        this.consumption = consumption;
        this.timestamp = timestamp;
        this.deviceId = deviceId;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getConsumption() {
        return consumption;
    }

    public void setConsumption(Integer consumption) {
        this.consumption = consumption;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public UUID getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
        this.deviceId = deviceId;
    }
}