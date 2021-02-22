package com.conductor.acme.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conductor.acme.api.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	List<Order> findByStatus(Long status);

}
