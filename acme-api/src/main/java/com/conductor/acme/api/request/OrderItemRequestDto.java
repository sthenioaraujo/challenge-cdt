package com.conductor.acme.api.request;

import java.io.Serializable;

public class OrderItemRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;
	private Double unitPrice;
	private Long quantity;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
