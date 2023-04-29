package  com.example.car.services;

import com.example.car.entity.Car;
import com.example.car.repositroies.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Product service implement.
 */
@Service
public class CarServiceImpl implements CarService {
     @Autowired
     private CarRepository carRepository;

    

    @Override
    public List<Car> listAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepository.findById(id).get();
    }

    @Override
    public Car saveCar(Car product) {
        return carRepository.save(product);
    }
    @Override
    public Car updateCar(Integer id, Car carUpdate){
        Car car = carRepository.getReferenceById(id);
        car.setCategory(carUpdate.getCategory());
        car.setName(carUpdate.getName());
        car.setPrice(carUpdate.getPrice());
        car.setPhone_number(carUpdate.getPhone_number());
        car.setYear(carUpdate.getYear());
        car.setKilometrage(carUpdate.getKilometrage());
        car.setBrand(carUpdate.getBrand());
        car.setAuthor(carUpdate.getAuthor());
        car.setPuissance(carUpdate.getPuissance());
        car.setQuantity(carUpdate.getQuantity());
        car = carRepository.save(car);
        return  car;
    }

    @Override
    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }
    
    @Override
	public List<Car> getCarByBrand(String brand) {
		
		 return carRepository.findAllByBrandName(brand);
		 
	}

}
