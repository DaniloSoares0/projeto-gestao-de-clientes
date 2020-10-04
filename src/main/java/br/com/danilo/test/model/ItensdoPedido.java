package br.com.danilo.test.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "itens_do_pedido")
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class ItensdoPedido implements Serializable{
	
	private static final long serialVersionUID = -7911205794128902024L;

    @EmbeddedId
	private ItemId id;

    @Column
  	@NotNull
	private BigDecimal valorTotal;
	
    @Column
  	@NotNull
	private BigDecimal quantidade;

}
