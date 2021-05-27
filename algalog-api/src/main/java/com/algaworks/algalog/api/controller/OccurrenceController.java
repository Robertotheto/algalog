package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.assembler.OccurrenceAssembler;
import com.algaworks.algalog.api.model.OccurrenceModel;
import com.algaworks.algalog.api.model.input.OccurrenceInput;
import com.algaworks.algalog.domain.models.Delivery;
import com.algaworks.algalog.domain.models.Occurrence;
import com.algaworks.algalog.domain.services.OccurrenceService;
import com.algaworks.algalog.domain.services.SearchDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliverys/{deliveryId}/occurrences")

public class OccurrenceController {
	
	private OccurrenceService occurrenceService;
	private OccurrenceAssembler occurrenceAssembler;
	private SearchDeliveryService searchDeliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OccurrenceModel registrar(@PathVariable Long deliveryId, 
			@Valid @RequestBody OccurrenceInput occurrenceInput) {
		Occurrence occurrenceRegistration = occurrenceService.registrar(deliveryId, 
				occurrenceInput.getDescription());
		
		return occurrenceAssembler.toModel(occurrenceRegistration);
	}
	@GetMapping
	public List<OccurrenceModel> listar(@PathVariable Long deliveryId){
		
		Delivery delivery = searchDeliveryService.buscar(deliveryId);
		return occurrenceAssembler.toCollectionModel(delivery.getOccorences());
	}

}
