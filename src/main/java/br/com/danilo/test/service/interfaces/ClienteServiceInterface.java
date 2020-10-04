package br.com.danilo.test.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.danilo.test.model.Cliente;

public interface ClienteServiceInterface extends ServiceInterface<Cliente> {

	Optional<Cliente> findById(Long id) throws Exception;
	
	List<Cliente> findAllCostumers() throws Exception;
		
    void deleteCliente(Cliente client) throws Exception;	
}
