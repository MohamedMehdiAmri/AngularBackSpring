package com.example.car.controllers;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.car.entity.Car;
import com.example.car.entity.Marque;
import com.example.car.services.CarService;
import com.example.car.services.MarqueService;
@CrossOrigin
@RestController
@RequestMapping("marqueService")
public class MarqueController {

	@Autowired
	private MarqueService service;

	@GetMapping("marque/all")
	public ResponseEntity<List<Marque>> getBooks(){

		List<Marque> books = service.listAllMarques();
		return new ResponseEntity<List<Marque>>(books, HttpStatus.OK);

	}

	@GetMapping("marque/{id}")
	public ResponseEntity<Marque> getBook(@PathVariable("id") Integer id){
		Marque book = service.getMarqueId(id);
		return new ResponseEntity<Marque>(book, HttpStatus.OK);
	}

	@PostMapping("marque")
	public ResponseEntity<Marque> createBook(@RequestBody Marque marque){
		
		Marque b = service.saveMarque(marque);
		return new ResponseEntity<Marque>(b, HttpStatus.OK);

	}
	@DeleteMapping("marque/{id}")
	public ResponseEntity<JSONObject> deleteMarque(@PathVariable("id") int id) {
        service.deleteMarque(id);
        JSONObject responseContent = new JSONObject();
        responseContent.put("response", "Marque has been deleted successfully");
        return new ResponseEntity<JSONObject>(responseContent, HttpStatus.OK);

    }
}
