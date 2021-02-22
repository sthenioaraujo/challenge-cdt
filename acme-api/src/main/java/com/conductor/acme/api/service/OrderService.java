package com.conductor.acme.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conductor.acme.api.mapper.OrderItemMapper;
import com.conductor.acme.api.mapper.OrderMapper;
import com.conductor.acme.api.model.EnumStatus;
import com.conductor.acme.api.model.Order;
import com.conductor.acme.api.model.OrderItem;
import com.conductor.acme.api.model.Store;
import com.conductor.acme.api.repository.OrderRepository;
import com.conductor.acme.api.request.OrderItemRequestDto;
import com.conductor.acme.api.request.OrderRequestDto;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private StoreService storeService;

	public List<Order> findAllOrders() {
		return orderRepository.findAll();
	}

	public Order findOrderById(Long id) throws Exception {
		return orderRepository.findById(id)
				.orElseThrow(() -> new Exception(String.format("O pedido %s: ", id, " não foi encontrado.")));
	}

	public Order saveOrder(OrderRequestDto ord) throws Exception {
		Store store = storeService.findById(ord.getId()).orElseThrow(
				() -> new Exception(String.format("A loja de Id: %s: ", ord.getId()," não foi encontrada.")));

		Order order = new OrderMapper().dtoToEntity(ord);
		order.setStatus(EnumStatus.AWAITING_PAYMENT.getStatus());
		order.setReleaseDate(new Date());
		order.setStore(store);

		order.setOrderItems(saveOrderItems(ord.getOrderItem(), order));

		return orderRepository.save(order);
	}

	private List<OrderItem> saveOrderItems(List<OrderItemRequestDto> orderItems, Order order) {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();

		for (OrderItemRequestDto item : orderItems) {
			OrderItem orderItem = new OrderItemMapper().dtoToEntity(item);
			orderItemList.add(orderItem);
		}

		return orderItemList;
	}

	public Order confirmOrder(Order entity) {
		entity.setReleaseDate(new Date());
		entity.setStatus(EnumStatus.PAYMENT_ACCEPT.getStatus());

		return orderRepository.save(entity);
	}

	public Order cancelOrder(Order entity) {
		entity.setStatus(EnumStatus.CANCELED.getStatus());

		return orderRepository.save(entity);
	}

	public Order rejectOrder(Order entity) {
		entity.setStatus(EnumStatus.DENIED.getStatus());

		return orderRepository.save(entity);
	}

	public Order refundOrder(Order entity) {
		entity.setStatus(EnumStatus.REFUNDED.getStatus());

		return orderRepository.save(entity);
	}

	public List<Order> findOrderByStatus(Long status) {
		return orderRepository.findByStatus(status);
	}
}
