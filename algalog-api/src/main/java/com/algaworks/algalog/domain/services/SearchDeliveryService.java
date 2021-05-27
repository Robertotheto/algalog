package com.algaworks.algalog.domain.services;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.EntityNotMeetException;
import com.algaworks.algalog.domain.models.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SearchDeliveryService {
	
	private DeliveryRepository deliveryRepository;
	
	public Delivery buscar(Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new EntityNotMeetException("Delivery not found"));
	}
}
