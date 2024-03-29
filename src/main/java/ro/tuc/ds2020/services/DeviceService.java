package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.DeviceDetailsDTO;
import ro.tuc.ds2020.dtos.builders.DeviceBuilder;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.repositories.DeviceRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DeviceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceService.class);
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<DeviceDTO> findDevices() {
        List<Device> deviceList = deviceRepository.findAll();
        return deviceList.stream()
                .map(DeviceBuilder::toDeviceDTO)
                .collect(Collectors.toList());
    }

    public DeviceDetailsDTO findDeviceById(UUID id) {
        Optional<Device> prosumerOptional = deviceRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Device with id {} was not found in db", id);

        }
        return DeviceBuilder.toDeviceDetailsDTO(prosumerOptional.get());
    }

    public UUID insert(DeviceDetailsDTO deviceDTO) {
        Device device = DeviceBuilder.toEntity(deviceDTO);
        device = deviceRepository.save(device);
        LOGGER.debug("Device with id {} was inserted in db", device.getId());
        return device.getId();
    }

    public void deleteDeviceById(UUID id){
        Optional<Device> prosumerOptional = deviceRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Device with id {} was not found in db", id);
        }

        deviceRepository.delete(prosumerOptional.get());
    }

    public UUID updateDevice(DeviceDetailsDTO deviceDTO) {
        Optional<Device> prosumerOptional = deviceRepository.findById(deviceDTO.getId());
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Device with id {} was not found in db", deviceDTO.getId());
        }

        Device device = prosumerOptional.get();

        if (deviceDTO.getName() !=null){
            device.setName(deviceDTO.getName());
        }
        if (deviceDTO.getManufacturer() !=null){
            device.setManufacturer(deviceDTO.getManufacturer());
        }
        if (deviceDTO.getId_consumption() !=null){
            device.setId_consumption(deviceDTO.getId_consumption());
        }
        if(deviceDTO.getYear_manufacture()!=null) {
            device.setYear_manufacture(deviceDTO.getYear_manufacture());
        }
        deviceRepository.save(device);

        return deviceDTO.getId();
    }

}
