package com.conductor.acme.api.response;

import java.io.Serializable;
import java.util.Date;

import com.conductor.acme.api.model.EnumStatus;

public class OrderResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long status;
	private String stDescription;
	private String adress;
	private Date releaseDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getStDescription() {
		stDescription = EnumStatus.getDescStatus(status).getDescStatus();
		return stDescription;
	}

	public void setStDescription(String stDescription) {
		this.stDescription = stDescription;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}
