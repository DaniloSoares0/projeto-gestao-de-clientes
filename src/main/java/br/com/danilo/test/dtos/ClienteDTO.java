package br.com.danilo.test.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import br.com.danilo.test.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements Serializable {

	

	private static final long serialVersionUID = -3217952679314921304L;

	private Long id;

	private String nomeCompleto;

	private String  cpf;

	private String endereco;

	private String  cep;

	private String bairro;

	private String cidade;

	private String uf;

	private String  telefone;

	private List<Pedido> pedidos;
	
	private LocalDateTime criadoEm;

}
