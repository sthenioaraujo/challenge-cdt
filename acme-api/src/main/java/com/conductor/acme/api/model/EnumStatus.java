package com.conductor.acme.api.model;

public enum EnumStatus {

	AWAITING_PAYMENT(0L, "Awaiting payment"), PAYMENT_ACCEPT(1L, "Payment accept"), DENIED(2L, "Denied"), CANCELED(3L,
			"Canceled"), REFUNDED(4L, "Refunded");

	private Long status;
	private String description;

	EnumStatus(Long status, String description) {
		setStatus(status);
		setDescStatus(description);
	}

	public static EnumStatus getDescStatus(Long status) {
		for (EnumStatus s : values()) {
			if (s.status == status) {
				return s;
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
