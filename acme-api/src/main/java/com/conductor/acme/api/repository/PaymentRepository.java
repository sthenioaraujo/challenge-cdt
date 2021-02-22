package com.conductor.acme.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.conductor.acme.api.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Procedure(procedureName = "pagarPedido")
    void pagarPedido(Long idOrder, String numberCard);
    
    @Procedure(procedureName = "reembolsarPedido")
    boolean reembolsarPedido(Long idOrder);
}
