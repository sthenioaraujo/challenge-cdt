package com.conductor.acme.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.conductor.acme.api.mapper.PaymentMapper;
import com.conductor.acme.api.model.Payment;
import com.conductor.acme.api.request.PaymentRequestDto;
import com.conductor.acme.api.response.PaymentResponseDto;
import com.conductor.acme.api.response.StoreResponseDto;
import com.conductor.acme.api.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "")
@RequestMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Cadastrar pagamento", notes = "Cadastra um pagamento referente a um pedido")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Pagamento realizado com sucesso", response = StoreResponseDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public PaymentResponseDto executePayment(@RequestBody @ApiParam(value = "Dados da modalidade de postagem", required = true) PaymentRequestDto dto) throws Exception {
		Payment order = paymentService.executePayment(dto);
		return new PaymentMapper().entityToDto(order);
	}
	
	@PostMapping("/refund/")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Cadastra reembolso", notes = "Cadastra o reembolso referente a um pagamento")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Reembolso realizado com sucesso", response = StoreResponseDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public PaymentResponseDto refundPayment(@RequestBody @ApiParam(value = "Dados da modalidade de postagem", required = true) PaymentRequestDto dto) throws Exception {
		Payment order = paymentService.refundPayment(dto);
		return new PaymentMapper().entityToDto(order);
	}
}
