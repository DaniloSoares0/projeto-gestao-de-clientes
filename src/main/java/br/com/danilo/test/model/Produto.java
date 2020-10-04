package br.com.danilo.test.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.danilo.test.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class Produto implements Serializable {
	
	private static final long serialVersionUID = -3919637811512798987L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotNull
	private String descricao;

	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	@Column
	@NotNull
	private BigDecimal valorUnitario;

	@OneToMany(mappedBy = "id.produto")
	private List<ItensdoPedido> item;
	
	@Column
	@CreatedDate
	private LocalDateTime criadoEm;
}

