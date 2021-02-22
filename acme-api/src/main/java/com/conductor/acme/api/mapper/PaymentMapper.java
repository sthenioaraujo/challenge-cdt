package com.conductor.acme.api.mapper;

import java.util.List;

import com.conductor.acme.api.model.Payment;
import com.conductor.acme.api.request.PaymentRequestDto;
import com.conductor.acme.api.response.PaymentResponseDto;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class PaymentMapper {

	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private MapperFacade mapperFacade = mapperFactory.getMapperFacade();

	public Payment dtoToEntity(PaymentResponseDto prd) {
		return mapperFacade.map(prd, Payment.class);
	}

	public Payment dtoToEntity(PaymentRequestDto prd) {
		return mapperFacade.map(prd, Payment.class);
	}

	public PaymentResponseDto entityToDto(Payment entity) {
		return mapperFacade.map(entity, PaymentResponseDto.class);
	}

	public List<PaymentResponseDto> entitiesToDtos(List<Payment> entities) {
		return mapperFacade.mapAsList(entities, PaymentResponseDto.class);
	}
}
