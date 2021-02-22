package com.conductor.acme.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.conductor.acme.api.mapper.OrderMapper;
import com.conductor.acme.api.model.Order;
import com.conductor.acme.api.request.OrderRequestDto;
import com.conductor.acme.api.response.OrderResponseDto;
import com.conductor.acme.api.response.StoreResponseDto;
import com.conductor.acme.api.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "")
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderResource {

	@Autowired
	private OrderService orderService;

	@GetMapping("/findOrders/")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Buscar todos os pedidos", notes = "Retorna todos os pedidos cadastrados na api")
	@ApiResponses({ @ApiResponse(code = 200, message = "Pedidos encontrados", response = OrderResponseDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public List<OrderResponseDto> findOrders() throws Exception {

		List<Order> orders = orderService.findAllOrders();
		return new OrderMapper().entitiesToDtos(orders);

	}

	@GetMapping("/findOrders/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Buscar pedido pelo Id", notes = "Retorna pedido pelo id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Pedido encontrado", response = OrderResponseDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public OrderResponseDto findOrderById(
			@ApiParam(value = "Id do pedido", required = true) @PathVariable("id") Long id) throws Exception {

		Order order = orderService.findOrderById(id);
		return new OrderMapper().entityToDto(order);
	}
	
	@GetMapping("/findOrders/status/{status}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Buscar pedidos pelo status", notes = "Retorna todos pedidos pelo status informado")
	@ApiResponses({ @ApiResponse(code = 200, message = "Pedidos encontrados", response = OrderResponseDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public List<OrderResponseDto> findOrderByStatus(
			@ApiParam(value = "Status do pedido", required = true) @PathVariable("status") Long status) throws Exception {

		List<Order> order = orderService.findOrderByStatus(status);
		return new OrderMapper().entitiesToDtos(order);
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Cadastra um pedido", notes = "Cadastra um novo pedido na api")
	@ApiResponses({
			@ApiResponse(code = 201, message = "Cadastro efetuado com sucesso", response = StoreResponseDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public OrderResponseDto createOrder(
			@RequestBody @ApiParam(value = "Dados da modalidade de postagem", required = true) OrderRequestDto dto)
			throws Exception {
		Order order = orderService.saveOrder(dto);
		return new OrderMapper().entityToDto(order);
	}

}
