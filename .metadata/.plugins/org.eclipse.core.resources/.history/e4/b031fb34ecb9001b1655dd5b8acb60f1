package com.algaworks.algalog.domain.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.models.Client;
import com.algaworks.algalog.domain.models.Delivery;
import com.algaworks.algalog.domain.models.StatusDelivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeliveryService {
	
	private ClientService clientService;
	private DeliveryRepository deliveryRepository;
	
	@Transactional
	public Delivery request(Delivery delivery) {
		
		Client client = clientService.buscar(delivery.getClient().getId());
		
		delivery.setClient(client);
		delivery.setStatus(StatusDelivery.PENDENTE);
		delivery.setDateOrder(LocalDateTime.now());
		return deliveryRepository.save(delivery);
	}
}
