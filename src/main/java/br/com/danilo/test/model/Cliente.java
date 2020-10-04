package br.com.danilo.test.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class Cliente implements Serializable{

	private static final long serialVersionUID = 7594647188080034675L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column
	@NotNull
	@Size(max = 100)
	private String nomeCompleto;

	@Column(unique = true)
	@NotNull
	@CPF(message="cpf inválido")
	@Size(max = 15)
	private String cpf;

	@Column
	@Size(max = 250)
	@NotNull
	private String endereco;

	@Column
	@Size(max = 250)
	@NotNull
	private String cep;

	@Column
	@NotNull
	@Size(max = 255)
	private String bairro;

	@Column
	@NotNull
	@Size(max = 255)
	private String cidade;

	@Column
	@NotNull
	@Size(max = 2)
	private String uf;

	@Column
	@Size(max = 11)
	@NotNull
	private String telefone;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;
	
	@Column
	@CreatedDate
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime criadoEm;

}
