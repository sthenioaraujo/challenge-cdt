package com.conductor.acme.api.response;

import java.io.Serializable;
import java.util.Date;

import com.conductor.acme.api.model.EnumPayment;

public class PaymentResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String numberCard;
	private Date releaseDate;
	private Long status;
	private String stDescription;

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

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getStDescription() {
		stDescription = EnumPayment.getDescStatus(status).getDescStatus();
		return stDescription;
	}

	public void setStDescription(String stDescription) {
		this.stDescription = stDescription;
	}

}
