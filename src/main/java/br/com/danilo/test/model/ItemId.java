package br.com.danilo.test.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ItemId implements Serializable {

	private static final long serialVersionUID = 1105709747722779853L;

	@ManyToOne
	private Produto produto;
	
    @ManyToOne
    private Pedido pedido;
}
