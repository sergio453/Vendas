package io.github.dougllasfps.domain.repository;

import io.github.dougllasfps.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidos extends JpaRepository<ItemPedido, Integer> {
}
