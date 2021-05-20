package com.algaworks.algalog.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.models.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClientController {
	
	private ClientRepository clientRepository;
	
	@GetMapping("/clients")
	public List<Client> list() {
		return clientRepository.findAll();
	}
}
