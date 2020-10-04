package br.com.danilo.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.danilo.test.model.Cliente;
import br.com.danilo.test.repository.ClienteRepository;
import br.com.danilo.test.service.interfaces.ClienteServiceInterface;
import lombok.AllArgsConstructor;

@Service("ClienteService")
@AllArgsConstructor
public class ClienteService implements ClienteServiceInterface{
	
    ClienteRepository clienteRepository;
    
	
	@Override
	public Optional<Cliente> findById(Long id) throws Exception {
		return clienteRepository.findById(id); 
	}

	@Override
	public Cliente save(Cliente cliente) throws Exception {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> findAllCostumers() throws Exception{
		return clienteRepository.findAll();
	}

	@Override
	public void deleteCliente(Cliente cliente) throws Exception {
		 clienteRepository.delete(cliente);
	}

}
