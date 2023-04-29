package com.example.car.repositroies;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.car.entity.Car;
import com.example.car.entity.Marque;


public interface MarqueRepository extends JpaRepository<Marque, Integer> {

}

