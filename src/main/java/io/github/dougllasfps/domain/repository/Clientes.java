package io.github.dougllasfps.domain.repository;

import io.github.dougllasfps.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer>{

    //@Query("SELECT c FROM Cliente c WHERE c.nome LIKE :nome ")
    @Query(value = "SELECT * FROM Cliente c WHERE c.nome LIKE '%:nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    //List<Cliente> findByNomeLike(String nome);

    void deleteByNome(String nome);

    boolean existsByNome(String nome);

    @Query(" SELECT c FROM Cliente c LEFT JOIN FETCH c.pedidos WHERE c.id = :id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}
