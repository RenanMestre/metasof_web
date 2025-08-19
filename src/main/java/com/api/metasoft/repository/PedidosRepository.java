package com.api.metasoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metasoft.thymeleaf.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
}
