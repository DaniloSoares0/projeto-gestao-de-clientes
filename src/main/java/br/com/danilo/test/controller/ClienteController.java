package br.com.danilo.test.controller;

import java.io.Serializable;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danilo.test.dtos.ClienteDTO;
import br.com.danilo.test.mappers.ClienteMapper;
import br.com.danilo.test.model.Cliente;
import br.com.danilo.test.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.tools.rmi.ObjectNotFoundException;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@Api(value = "Clientes")
@RequestMapping("/clientes")
public class ClienteController {

	private  ClienteService clienteService;
	private  ClienteMapper clienteMapper;

	
	@GetMapping("/{id}")
	@ApiOperation(value = "Busca clientes por id.")
	public ResponseEntity<ClienteDTO> findById(@PathVariable("id") Long id) throws ObjectNotFoundException {
		try {

			return ResponseEntity.ok().body(clienteService.findById(id)
					.map(clienteMapper::mapToDTO).get());

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}


	@GetMapping
	@ApiOperation(value = "Busca todo os clientes.")
	public ResponseEntity<Object> findAll() {
		try {

			return ResponseEntity.status(HttpStatus.OK)
					.body(clienteService
							.findAllCostumers()
							.stream()
							.map(clienteMapper::mapToDTO)
							.collect(Collectors.toList()));

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Um erro ocorreu ao processar a solicitação");
		}
	}


	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Cria um cliente.")
	public ResponseEntity<Serializable> save(@RequestBody @Valid ClienteDTO cliente) {

		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(clienteMapper.mapToDTO(clienteService.save(clienteMapper.mapToCliente(cliente))));

		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("O cliente já se encontra cadastrado na base");

		} catch (ConstraintViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Digite um cpf válido ");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Um erro ocorreu ao processar a solicitação");
		}
	}


	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Atualiza um cliente.")
	public  ResponseEntity<Serializable> update(@RequestBody @Valid ClienteDTO clienteDTO)  {

		try {

			Cliente cliente = clienteService.findById(clienteDTO.getId()).get();

			clienteMapper.castToCliente(cliente, clienteDTO);

			clienteMapper.mapToDTO(clienteService.save(cliente));

			return ResponseEntity.status(HttpStatus.OK)
					.body(cliente);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Um erro ocorreu ao processar a solicitação");
		}
	}


	@DeleteMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Deleta um cliente.")
	public ResponseEntity<Serializable> delete(@RequestBody @Valid ClienteDTO clienteDTO) {

		try {

			Cliente cliente = clienteService.findById(clienteDTO.getId()).get();

			clienteMapper.castToCliente(cliente, clienteDTO);

			clienteService.deleteCliente(cliente);

			return ResponseEntity.status(HttpStatus.OK)
					.body(cliente);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Cliente não encontrado");
		}
	}
}
