package com.conductor.acme.api.mapper;

import java.util.List;

import com.conductor.acme.api.model.Store;
import com.conductor.acme.api.request.StoreRequestDto;
import com.conductor.acme.api.response.StoreResponseDto;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class StoreMapper {

	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private MapperFacade mapperFacade = mapperFactory.getMapperFacade();

	public Store dtoToEntity(StoreResponseDto srd) {
		return mapperFacade.map(srd, Store.class);
	}

	public Store dtoToEntity(StoreRequestDto srd) {
		return mapperFacade.map(srd, Store.class);
	}

	public StoreResponseDto entityToDto(Store entity) {
		return mapperFacade.map(entity, StoreResponseDto.class);
	}

	public List<StoreResponseDto> entitiesToDtos(List<Store> entities) {
		return mapperFacade.mapAsList(entities, StoreResponseDto.class);
	}
}
