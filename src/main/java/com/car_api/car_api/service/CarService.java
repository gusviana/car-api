package com.car_api.car_api.service;


import com.car_api.car_api.entity.Car;
import com.car_api.car_api.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car findById(String id){
        Optional<Car> car = carRepository.findById(id);
        return car.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Car insert(Car car){
        return carRepository.save(car);
    }

    public void delete(String id){
        if(!carRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        carRepository.deleteById(id);
    }

    public Car update(String id, Car car){
        Car entity = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        updateData(entity, car);
        return carRepository.save(entity);
    }

    private void updateData(Car entity, Car car) {
        entity.setModelo(car.getModelo());
        entity.setPlaca(car.getPlaca());
        entity.setCor(car.getCor());
    }
}
