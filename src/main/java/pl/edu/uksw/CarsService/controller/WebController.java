package pl.edu.uksw.CarsService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.uksw.CarsService.entity.Car;
import pl.edu.uksw.CarsService.repository.CarsRepository;

import java.util.List;

/**
 * Created by Nogaz on 13.07.2017.
 */
@RestController
public class WebController {

    @Autowired
    CarsRepository repository;

    @RequestMapping("/cars")
    public String getAllCars(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        repository.findAll().forEach(car -> sb.append("<div>"+car.toString()+"</div>"));
        sb.append("</htmml>");
        return sb.toString();
    }

    @Transactional
    @RequestMapping("/addcar")
    public String addNewCar(@RequestParam("producer") String producer,
                          @RequestParam("model") String model,
                          @RequestParam("year") int year,
                          @RequestParam("capacity") int capacity,
                          @RequestParam("type") String type){
        Car newUser = new Car(producer, model, year, capacity, type);
        repository.save(newUser);
        return "User: " + newUser.toString() + " added succesfully!";
    }

    @Transactional
    @RequestMapping("/addcar")
    public List<Car> getCarByProducerName(@RequestParam("producer") String producer){
        return repository.getCarsByProducerName(producer);
    }
}
