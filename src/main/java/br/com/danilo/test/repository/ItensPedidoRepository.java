package br.com.danilo.test.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.danilo.test.model.ItensdoPedido;

@Repository
public interface ItensPedidoRepository  extends JpaRepository<ItensdoPedido, Long>{

}
