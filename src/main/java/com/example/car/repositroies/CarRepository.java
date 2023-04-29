package com.example.car.repositroies;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.car.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

	public List<Car> findAllByBrandName(String brand);
	
}

