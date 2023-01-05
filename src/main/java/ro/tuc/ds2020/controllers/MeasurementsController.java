package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.MeasurementsDetailsDTO;
import ro.tuc.ds2020.services.MeasurementsService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin()
@RequestMapping(value = "/measurements")

public class MeasurementsController {
    private final MeasurementsService measurementsService;

    @Autowired
    public MeasurementsController(MeasurementsService measurementsService) {
        this.measurementsService = measurementsService;
    }

    @GetMapping()
    public ResponseEntity<List<MeasurementsDetailsDTO>> getMeasurements(){
        List<MeasurementsDetailsDTO> dtos=measurementsService.findMeasurements();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody MeasurementsDetailsDTO measurementsDetailsDTO){
        System.out.println("measurements before insert"+measurementsDetailsDTO);
        UUID mesID= measurementsService.insertMeasurements(measurementsDetailsDTO);
        System.out.println(mesID);
        return new ResponseEntity<>(mesID, HttpStatus.CREATED);
    }

    @GetMapping(value="/{id_mesurement}")
    private ResponseEntity<MeasurementsDetailsDTO> getMeasurements(@PathVariable("id_mesurement") UUID deviceID) {
        MeasurementsDetailsDTO dto= measurementsService.findMeasurementsbyID(deviceID);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PostMapping(value="/updateMeasurement")
    public ResponseEntity<?> updateMeasurement(@Valid @RequestBody MeasurementsDetailsDTO measurementsDetailsDTO){
        return new ResponseEntity<>(measurementsService.updateMeasurement(measurementsDetailsDTO), HttpStatus.OK);
    }


}