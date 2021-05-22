package com.algaworks.algalog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.algalog.domain.models.StatusDelivery;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DeliveryModel {
	private Long id;
	private ClientResumoModel client;
	private RecipientModel recipient;
	private BigDecimal rate;
	private StatusDelivery status;
	private OffsetDateTime dateOrder;
	private OffsetDateTime dateFinish;
}
