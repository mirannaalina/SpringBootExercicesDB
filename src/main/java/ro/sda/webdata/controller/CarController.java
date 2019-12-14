package ro.sda.webdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String save(@RequestBody CarSaveBody carSaveBody){
        carService.save(carSaveBody);
        return"OK";
    }

    @GetMapping(value ="all", produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    //cu ajutorul dependintei jackson, am reusit sa schimbam default-ul json in xml
    //cand am medyaType si xml si json, stie sa le ia amandoua tipurile
    @ResponseBody
    public List<CarEntity> all(){
        List<CarEntity> cars = carService.findAll();
        return cars;
    }

    @GetMapping(value = "search/{model}", produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<CarEntity> search(@PathVariable("model") String carModel ){
        return carService.findByModel(carModel);
    }

}
