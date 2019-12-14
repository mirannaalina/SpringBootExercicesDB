package ro.sda.webdata.service.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.webdata.controller.CarSaveBody;
import ro.sda.webdata.persistence.car.CarEntity;
import ro.sda.webdata.persistence.car.CarRepository;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Transactional(readOnly = true)
    public List<CarEntity> findAll(){
        return carRepository.findAll();
    }

    @Transactional
    public void save(CarSaveBody carSaveBody){
        CarEntity carEntity = new CarEntity();
        carEntity.setHp(carSaveBody.getHp());
        carEntity.setColor(carSaveBody.getColor());
        carEntity.setModel(carSaveBody.getModel());
        carRepository.save(carEntity);
    }

    @Transactional(readOnly = true)
    public List<CarEntity> findByModel(String model){
        return carRepository.findByModel(model);
    }
}
