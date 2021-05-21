package com.algaworks.algalog.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.BussinesException;
import com.algaworks.algalog.domain.models.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientService {
	
	private ClientRepository clientRepository;
	
	public Client buscar(Long clientId) {
		return  clientRepository.findById(clientId)
				.orElseThrow(() -> new BussinesException("Client not found"));
	}
	
	@Transactional
	public Client salvar(Client client) {
		boolean EmailUse  = clientRepository.findByEmail(client.getEmail())
				.stream()
				.anyMatch(clientExists -> !clientExists.equals(client));
		if(EmailUse) {
			throw new BussinesException("Email is exists not found");
		}
		return clientRepository.save(client);
	}
	
	@Transactional
	public void excluir(Long clientId) {
		clientRepository.deleteById(clientId);
	}
}
