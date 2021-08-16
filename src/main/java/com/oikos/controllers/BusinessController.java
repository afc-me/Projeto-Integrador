package com.oikos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oikos.models.Business;
import com.oikos.models.Profile;
import com.oikos.repositories.BusinessRepository;
import com.oikos.services.BusinessService;


@RestController
@RequestMapping("/business")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class BusinessController {

	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
	private BusinessService businessService;

	
	@GetMapping("/all")
	public ResponseEntity<List<Business>> GetAll() {
		return ResponseEntity.ok(businessRepository.findAll());
	}
	
	@GetMapping("/{businessId}")
	public ResponseEntity<Business> profileGetById(@PathVariable long businessId) {
		return businessRepository.findById(businessId).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
}
