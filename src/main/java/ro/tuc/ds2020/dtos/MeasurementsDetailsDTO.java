package ro.tuc.ds2020.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import ro.tuc.ds2020.entities.Measurements;


import java.sql.Timestamp;
import java.util.UUID;


public class MeasurementsDetailsDTO  extends RepresentationModel<MeasurementsDTO>
{
    @NotNull
    private UUID id;
    @NotNull
    Integer consumption;
    @NotNull
    Timestamp timestamp;
    @NotNull
    private UUID deviceId;

    public MeasurementsDetailsDTO(){

    }

    public MeasurementsDetailsDTO(UUID id, Integer consumption, Timestamp timestamp, UUID deviceId){
        this.id = id;
        this.consumption = consumption;
        this.timestamp = timestamp;
        this.deviceId = deviceId;
    }

    public MeasurementsDetailsDTO(Integer consumption, Timestamp timestamp, UUID deviceId){
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