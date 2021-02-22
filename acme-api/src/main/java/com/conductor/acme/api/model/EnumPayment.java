package com.conductor.acme.api.model;

public enum EnumPayment {

	PAID_OUT(1L, "Paid out"), CANCELED(2L, "Canceled"),  REFUNDED(3L, "Refunded");

	private Long status;
	private String description;

	EnumPayment(Long status, String description) {
		setStatus(status);
		setDescStatus(description);
	}

	public static EnumPayment getDescStatus(Long status) {
		for (EnumPayment payment : values()) {
			if (payment.status == status) {
				return payment;
			}
		}
		return null;
	}

	public Long getStatus() {
		return status;
	}

	private void setStatus(Long status) {
		this.status = status;
	}

	public String getDescStatus() {
		return description;
	}

	private void setDescStatus(String description) {
		this.description = description;
	}
}
