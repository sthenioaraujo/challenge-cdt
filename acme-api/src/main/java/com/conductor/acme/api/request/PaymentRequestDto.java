package com.conductor.acme.api.request;

import java.io.Serializable;

public class PaymentRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String numberCard;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

}
