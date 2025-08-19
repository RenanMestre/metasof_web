package com.api.metasoft.service;

import com.api.metasoft.repository.PedidosRepository;
import com.metasoft.thymeleaf.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    public List<Pedidos> listarTodos() {
        return pedidosRepository.findAll();
    }

    public Pedidos salvar(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    public void deletar(Long id) {
        pedidosRepository.deleteById(id);
    }

    public Optional<Pedidos> buscarPorId(Long id) {
        return pedidosRepository.findById(id);
    }
}
