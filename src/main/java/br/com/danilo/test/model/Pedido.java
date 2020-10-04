package br.com.danilo.test.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class Pedido implements Serializable {

	private static final long serialVersionUID = 5279673010291504681L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@ManyToOne
	private Cliente cliente;

//    @OneToMany(mappedBy = "id.pedido")
//	private List<ItensdoPedido> itensdoPedido;
//	
    @Column
	@NotNull
	private BigDecimal valorPedido;
	
    @Column
	@NotNull
	private BigDecimal valorFrete;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@CreatedDate
	private LocalDateTime criadoEm;
}
