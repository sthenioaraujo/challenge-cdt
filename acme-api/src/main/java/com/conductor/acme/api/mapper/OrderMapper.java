package com.conductor.acme.api.mapper;

import java.util.List;

import com.conductor.acme.api.model.Order;
import com.conductor.acme.api.request.OrderRequestDto;
import com.conductor.acme.api.response.OrderResponseDto;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrderMapper {

	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private MapperFacade mapperFacade = mapperFactory.getMapperFacade();

	public Order dtoToEntity(OrderResponseDto ord) {
		return mapperFacade.map(ord, Order.class);
	}

	public Order dtoToEntity(OrderRequestDto ord) {
		return mapperFacade.map(ord, Order.class);
	}

	public OrderResponseDto entityToDto(Order entity) {
		return mapperFacade.map(entity, OrderResponseDto.class);
	}

	public List<OrderResponseDto> entitiesToDtos(List<Order> entities) {
		return mapperFacade.mapAsList(entities, OrderResponseDto.class);
	}
}
