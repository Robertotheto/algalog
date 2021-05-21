package com.algaworks.algalog.domain.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Recipient {
	
	@NotBlank
	@Column(name = "recipient_nome")
	private String nome;
	
	@NotBlank
	@Column(name = "recipient_logradouro")
	private String logradouro;
	
	@NotBlank
	@Column(name = "recipient_numero")
	private String numero;
	
	@NotBlank
	@Column(name = "recipient_complemento")
	private String complemento;
	
	@NotBlank
	@Column(name = "recipient_bairro")
	private String bairro;
}
