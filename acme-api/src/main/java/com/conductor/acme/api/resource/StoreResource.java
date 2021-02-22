package com.conductor.acme.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.conductor.acme.api.mapper.StoreMapper;
import com.conductor.acme.api.model.Store;
import com.conductor.acme.api.request.StoreRequestDto;
import com.conductor.acme.api.response.StoreResponseDto;
import com.conductor.acme.api.service.StoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "")
@RequestMapping(value = "/store", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoreResource {

	@Autowired
	private StoreService storeService;
	
	@GetMapping("/findStores/")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Buscar todas as lojas", notes = "Retorna todas as lojas cadastradas na api")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Lojas encontradas com sucesso", response = StoreResponseDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public List<StoreResponseDto> findStore() throws Exception {
		
		List<Store> stores = storeService.findAllStore();
		return new StoreMapper().entitiesToDtos(stores);
	}
	
	@GetMapping("/findStores/{name}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Buscar a loja pelo nome", notes = "Retorna uma loja pelo nome")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Loja encontradas com sucesso", response = StoreResponseDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public List<StoreResponseDto> findStoreByName(@ApiParam(value = "Nome da loja", required = true) @PathVariable("name") String name) throws Exception {
		
		List<Store> store = storeService.findStoreByName(name);
		return new StoreMapper().entitiesToDtos(store);
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Cadastra uma loja", notes = "Cadastro uma nova loja na api")
	@ApiResponses({
			@ApiResponse(code = 201, message = "Loja cadastrada com sucesso", response = StoreResponseDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public StoreResponseDto createStore(@RequestBody @ApiParam(value = "Dados da modalidade de postagem", required = true) StoreRequestDto dto) throws Exception {
		Store store = storeService.saveStore(dto);
		return new StoreMapper().entityToDto(store);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Atualizar loja", notes = "Atualiza uma loja de acordo com o id informado")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Loja atualiazada com sucesso", response = StoreResponseDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public StoreResponseDto updateStore(@PathVariable Long id, @RequestBody @ApiParam(value = "Dados da modalidade de postagem", required = true) StoreRequestDto dto) throws Exception {
		Store store = storeService.atualizarStore(id, dto);
		return new StoreMapper().entityToDto(store);
	}
}
