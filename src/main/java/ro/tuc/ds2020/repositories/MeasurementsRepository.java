package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tuc.ds2020.entities.Measurements;

import java.util.UUID;

public interface MeasurementsRepository extends JpaRepository<Measurements, UUID> {

}