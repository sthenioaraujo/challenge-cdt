package com.conductor.acme.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conductor.acme.api.mapper.PaymentMapper;
import com.conductor.acme.api.model.EnumPayment;
import com.conductor.acme.api.model.EnumStatus;
import com.conductor.acme.api.model.Order;
import com.conductor.acme.api.model.Payment;
import com.conductor.acme.api.repository.PaymentRepository;
import com.conductor.acme.api.request.PaymentRequestDto;

@Service
public class PaymentService {

	@Autowired
    private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderService orderService;

	public Payment executePayment(PaymentRequestDto dto) throws Exception {
		Order order = orderService.findOrderById(dto.getId());
		
		Payment payment = new PaymentMapper().dtoToEntity(dto);
		try{
			paymentRepository.pagarPedido(order.getId(), dto.getNumberCard());
		} catch (Exception e) {
			orderService.rejectOrder(order);
		}		
		
		payment.setOrder(order);
		payment.setPaymentDate(new Date());
		payment.setStatus(EnumPayment.PAID_OUT.getStatus());
		
		return payment;
	}

	public Payment refundPayment(PaymentRequestDto dto) throws Exception {
		Order order = orderService.findOrderById(dto.getId());
		
		if(order.getStatus() != EnumStatus.PAYMENT_ACCEPT.getStatus()) {
			throw new Exception("Não é possível realizar o reembolse deste pedido");
		}
		
		// Stored Procedure
		boolean reembolsado = paymentRepository.reembolsarPedido(dto.getId());
		
		Payment payment = new PaymentMapper().dtoToEntity(dto);
		
		if (reembolsado) {
			payment.setStatus(EnumPayment.REFUNDED.getStatus());
			payment.setNumberCard(dto.getNumberCard());
		}
				
		return payment;
	}
}
