package ro.sda.webdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.sda.webdata.persistence.car.CarEntity;
import ro.sda.webdata.service.car.CarService;

import java.util.List;
//putem pune @RestController sa nu mai punem @Controller si @ResponseBody
@Controller
@RequestMapping("car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService =carService;
    }

    @PostMapping("save")
    @ResponseBody
    public String save(@RequestBody CarSaveBody carSaveBody){
        carService.save(carSaveBody);
        return"OK";
    }

    @GetMapping("all")
    @ResponseBody
    public List<CarEntity> all(){
        List<CarEntity> cars = carService.findAll();
        return cars;
    }

}
