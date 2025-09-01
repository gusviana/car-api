package com.car_api.car_api.repository;

import com.car_api.car_api.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {

}
