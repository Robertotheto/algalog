package com.algaworks.algalog.domain.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.models.Delivery;
import com.algaworks.algalog.domain.models.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OccurrenceService {
	
	private SearchDeliveryService searchDeliveryService;
	
	@Transactional
	public Occurrence registrar(Long deliveryId, String description) {
		Delivery delivery = searchDeliveryService.buscar(deliveryId);
		
		return delivery.addOccurrence(description);
	}
}
