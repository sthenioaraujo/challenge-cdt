package com.conductor.acme.api.request;

import java.io.Serializable;
import java.util.List;

public class OrderRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private List<OrderItemRequestDto> orderItem;
	private String adress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderItemRequestDto> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItemRequestDto> orderItem) {
		this.orderItem = orderItem;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

}
