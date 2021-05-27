package com.algaworks.algalog.domain.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.algaworks.algalog.domain.ValiditionGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ConvertGroup(from = Default.class, to = ValiditionGroups.ClientId.class)
	@NotNull
	@ManyToOne
	private Client client;
	
	@Valid
	@NotNull
	@Embedded
	private Recipient recipient;
	
	@NotNull
	private BigDecimal rate;
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
	private List<Occurrence> occorences = new ArrayList<>();
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusDelivery status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dateOrder;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dateFinish;

	public Occurrence addOccurrence(String description) {
		
		Occurrence occurrence = new Occurrence();
		occurrence.setDescription(description);
		occurrence.setDateRegistration(OffsetDateTime.now());
		occurrence.setDelivery(this);
		
		this.getOccorences().add(occurrence);
		return occurrence;
	}
}
