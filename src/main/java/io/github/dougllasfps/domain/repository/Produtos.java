package io.github.dougllasfps.domain.repository;

import io.github.dougllasfps.domain.entity.Produto;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Produtos extends JpaRepository<Produto, Integer> {

    @Query(value = "SELECT * FROM Produto p WHERE p.descricao LIKE '%:descricao%' ", nativeQuery = true)
    List<Produto> encontrarPorDescricao(@Param("descricao") String descricao);

    void deleteByDescricao(String descricao);

    boolean existsByDescricao(String descricao);


}
