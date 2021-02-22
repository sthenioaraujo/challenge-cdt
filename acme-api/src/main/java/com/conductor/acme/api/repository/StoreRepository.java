package com.conductor.acme.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conductor.acme.api.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

	List<Store> findByName(String name);
	
}
