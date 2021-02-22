package com.conductor.acme.api.mapper;

import java.util.List;

import com.conductor.acme.api.model.OrderItem;
import com.conductor.acme.api.request.OrderItemRequestDto;
import com.conductor.acme.api.response.OrderItemResponseDto;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrderItemMapper {

	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    private MapperFacade mapperFacade = mapperFactory.getMapperFacade();
    
    public OrderItem dtoToEntity(OrderItemRequestDto oird) {
		return mapperFacade.map(oird, OrderItem.class);
	}
    
    public OrderItem dtoToEntity(OrderItemResponseDto oird) {
		return mapperFacade.map(oird, OrderItem.class);
	}
    
    public OrderItemResponseDto entityToDto(OrderItem entity) {
		return mapperFacade.map(entity, OrderItemResponseDto.class);
	}
	
	public List<OrderItemResponseDto> entitiesToDtos(List<OrderItem> entities){
		return mapperFacade.mapAsList(entities, OrderItemResponseDto.class);
	}
    
}
