package ro.tuc.ds2020.services;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import ro.tuc.ds2020.dtos.DeviceDetailsDTO;
import ro.tuc.ds2020.dtos.MeasurementsDTO;
import ro.tuc.ds2020.dtos.MeasurementsDetailsDTO;
import ro.tuc.ds2020.entities.Device;

import java.rmi.server.UID;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Queue;
import java.util.UUID;

@Controller
public class RabbitConsumer {
    static final String QUEUE = "device_simulator_queue";
    public final MeasurementsService measurementsService;
    public final DeviceService deviceService;

    public RabbitConsumer(MeasurementsService measurementsService, DeviceService deviceService){
        this.deviceService= deviceService;
        this.measurementsService = measurementsService;
    }

    @RabbitListener(queues = QUEUE)
    public void run(String incomingMessage) throws Exception {
        JSONParser jsonParser = new JSONParser();
        try{
            JSONObject jsonObject = (JSONObject) jsonParser.parse(incomingMessage);
            System.out.println(jsonObject);
            Double consumption = Double.parseDouble(jsonObject.get("consumption").toString());

            long date_long = Long.parseLong((String) jsonObject.get("timestamp"));
            LocalDateTime dateTime1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(date_long), ZoneOffset.UTC);
            String date_string = jsonObject.get("timestamp").toString();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
//            LocalDateTime dataTime = LocalDateTime.parse(date_string, formatter);
            Timestamp timestamp = Timestamp.valueOf(dateTime1);

            String uuidString = jsonObject.get("deviceId").toString();
//            long mostSig = Long.parseLong(uuidString.substring(0, 16), 16);
//            long leastSig = Long.parseLong(uuidString.substring(16, 32), 16);
            UUID uuid = UUID.fromString(uuidString);

            DeviceDetailsDTO deviceDetailsDTO = deviceService.findDeviceById(uuid);
            sentPeakNotification("New measurement detected!");
            MeasurementsDetailsDTO measurementsDTO = new MeasurementsDetailsDTO(consumption.intValue(), timestamp, deviceDetailsDTO.getId() );
            measurementsService.insertMeasurements(measurementsDTO);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void sentPeakNotification(String message){
        System.out.println(message);
    }
}
