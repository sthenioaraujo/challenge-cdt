package com.conductor.acme.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.conductor.acme.api.mapper.StoreMapper;
import com.conductor.acme.api.model.Store;
import com.conductor.acme.api.repository.StoreRepository;
import com.conductor.acme.api.request.StoreRequestDto;

@Service
public class StoreService {

	@Autowired
	private StoreRepository storeRepository;

	public List<Store> findAllStore() {
		return storeRepository.findAll();
	}

	public List<Store> findStoreByName(String name) {
		return storeRepository.findByName(name);
	}

	public Store saveStore(StoreRequestDto dto) {
		Store store = new StoreMapper().dtoToEntity(dto);
		return storeRepository.save(store);
	}

	public Optional<Store> findById(Long id) {
		return storeRepository.findById(id);
	}

	public Store atualizarStore(Long id, StoreRequestDto dto) {
		Store saveStore = buscarPessoaPeloCodigo(id);
		BeanUtils.copyProperties(dto, saveStore, "codigo");
		return storeRepository.save(saveStore);
	}

	private Store buscarPessoaPeloCodigo(Long id) {
		Optional<Store> saveStore = storeRepository.findById(id);
		if(!saveStore.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return saveStore.get();
	}

}
