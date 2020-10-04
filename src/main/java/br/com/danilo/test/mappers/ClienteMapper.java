package br.com.danilo.test.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import br.com.danilo.test.dtos.ClienteDTO;
import br.com.danilo.test.model.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {


	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "nomeCompleto", target = "nomeCompleto"),
		@Mapping(source = "cpf", target = "cpf"),
		@Mapping(source = "endereco", target = "endereco"),
		@Mapping(source = "cep", target = "cep"),
		@Mapping(source = "bairro", target = "bairro"),
		@Mapping(source = "cidade", target = "cidade"),
		@Mapping(source = "uf", target = "uf"),
		@Mapping(source = "telefone", target = "telefone"),
		@Mapping(source = "pedidos", target = "pedidos", ignore = true),
		@Mapping(source = "criadoEm", target = "criadoEm", dateFormat = "yyyy-MM-dd HH:mm"),
	})
	ClienteDTO  mapToDTO(Cliente cliente);

	List<ClienteDTO> mapToListDTO(List<Cliente> cliente);


	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "nomeCompleto", target = "nomeCompleto"),
		@Mapping(source = "cpf", target = "cpf"),
		@Mapping(source = "endereco", target = "endereco"),
		@Mapping(source = "cep", target = "cep"),
		@Mapping(source = "bairro", target = "bairro"),
		@Mapping(source = "cidade", target = "cidade"),
		@Mapping(source = "uf", target = "uf"),
		@Mapping(source = "telefone", target = "telefone"),
		@Mapping(source = "criadoEm", target = "criadoEm", dateFormat = "yyyy-MM-dd HH:mm"),
	})
	Cliente mapToCliente(ClienteDTO cliente);
	
	
	List<Cliente>  mapToListCliente(List<ClienteDTO> cliente);

	
    void castToCliente(@MappingTarget Cliente cliente,  ClienteDTO tagetclienteDTO);
	
}

