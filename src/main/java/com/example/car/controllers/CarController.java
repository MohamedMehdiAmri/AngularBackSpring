package com.example.car.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.car.entity.Car;
import com.example.car.services.CarService;

import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@CrossOrigin
@RestController
@RequestMapping("carService")
public class CarController {

	@Autowired
	private CarService service;
	
	public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads";
	
	
	@PostMapping("/upload")
	public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") MultipartFile file) throws IOException{
		List<String> filenames = new ArrayList<>();
		
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		
		Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
		
		Files.copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
		filenames.add(filename);
		
		return ResponseEntity.ok().body(filenames);
		
	}

	@GetMapping(path = "/getImage/{imgName}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getImages(@PathVariable("imgName") String imgName) throws IOException {
		File f = new File(System.getProperty("user.home"));
		Path p = Paths.get(f + "/Downloads/uploads/" + imgName);
		return Files.readAllBytes(p);
	}
	
	@GetMapping("car/all")
	public ResponseEntity<List<Car>> getBooks(){

		List<Car> books = service.listAllCars();
		return new ResponseEntity<List<Car>>(books, HttpStatus.OK);

	}

	@GetMapping("car/{id}")
	public ResponseEntity<Car> getBook(@PathVariable("id") Integer id){
		Car book = service.getCarById(id);
		return new ResponseEntity<Car>(book, HttpStatus.OK);
	}
	
	@GetMapping("car/brand/{brand}")
	public ResponseEntity<List<Car>> getBook(@PathVariable("brand") String brand){
		List<Car> book = service.getCarByBrand(brand);
		return new ResponseEntity<List<Car>>(book, HttpStatus.OK);
	}

	@PostMapping("car")
	public ResponseEntity<Car> createBook(@RequestBody Car book ){
		System.out.println("$$$$$$$$$$$");
		System.out.println(book);
		Car b = service.saveCar(book);
		return new ResponseEntity<Car>(b, HttpStatus.OK);

	}

	@PutMapping("car/{id}")
	public ResponseEntity<Car> updateBook(@PathVariable("id") int id, @RequestBody Car book){

		System.out.println("$$$$$$$$$$$");
		System.out.println(book);
		Car b = service.updateCar(id, book);
		return new ResponseEntity<Car>(b, HttpStatus.OK);
	}

	@DeleteMapping("car/{id}")
	public ResponseEntity<JSONObject> deleteBook(@PathVariable("id") int id) {
        service.deleteCar(id);
        JSONObject responseContent = new JSONObject();
        responseContent.put("response", "Car has been deleted successfully");
        return new ResponseEntity<JSONObject>(responseContent, HttpStatus.OK);

    }
}
