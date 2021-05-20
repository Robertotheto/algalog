package com.algaworks.algalog.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.domain.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findByNome(String nome);
	List<Client> findByNomeContaining(String nome);
}
