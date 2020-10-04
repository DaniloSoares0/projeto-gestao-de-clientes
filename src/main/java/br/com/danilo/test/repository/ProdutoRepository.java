package br.com.danilo.test.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.danilo.test.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Optional<Produto> findById(Long id);
	
    
}
