package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.models.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import com.algaworks.algalog.domain.services.DeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliverys")
public class DeliveryController {
	
	private DeliveryService deliveryService;
	private DeliveryRepository deliveryRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery solicitar(@Valid @RequestBody Delivery delivery) {
		
		return deliveryService.request(delivery);
	}
	
	@GetMapping
	public List<Delivery> listar(){
		return deliveryRepository.findAll();
	}
	@GetMapping("/{deliveryId}")
	public ResponseEntity<Delivery> buscar(@PathVariable Long deliveryId){
		return deliveryRepository.findById(deliveryId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
