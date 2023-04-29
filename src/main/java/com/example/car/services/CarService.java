package  com.example.car.services;

import com.example.car.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> listAllCars();

    Car getCarById(Integer id);

    Car saveCar(Car product);

    Car updateCar(Integer id, Car Car);
    
    List<Car> getCarByBrand(String brand);

    void deleteCar(Integer id);

}
