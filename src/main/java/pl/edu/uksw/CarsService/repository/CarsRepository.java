package pl.edu.uksw.CarsService.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.uksw.CarsService.entity.Car;

import java.util.List;

/**
 * Created by Nogaz on 13.07.2017.
 */
public interface CarsRepository extends CrudRepository<Car, Long> {
    public List<Car> getCarsByProducerName(String producer);
}
