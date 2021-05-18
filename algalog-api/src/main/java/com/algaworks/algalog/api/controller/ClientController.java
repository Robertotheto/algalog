package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.models.Client;

@RestController
public class ClientController {
	@GetMapping("/clients")
	public List<Client> listar() {
		
		var client1 = new Client();
		client1.setId(1L);
		client1.setNome("Roberto");
		client1.setEmail("roberto@gmail.com");
		client1.setTelefone("66 9 99523354");
		
		var client2 = new Client();
		client2.setId(2L);
		client2.setNome("lucas");
		client2.setEmail("lucas@gmail.com");
		client2.setTelefone("66 9 99520000");
		
		return Arrays.asList(client1, client2);	
	}
}
