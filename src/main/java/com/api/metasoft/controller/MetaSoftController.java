package com.api.metasoft.controller;

import com.api.metasoft.repository.FuncionariosRepository;
import com.metasoft.thymeleaf.Pedidos;
import com.metasoft.thymeleaf.Parceiros;
import com.api.metasoft.repository.PedidosRepository;
import com.api.metasoft.repository.ParceirosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MetaSoftController {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ParceirosRepository parceirosRepository;
    
    @Autowired
    private FuncionariosRepository funcionariosRepository;
    
    // ========== PARCEIROS ==========
    @PostMapping("/parceiro")
    public String salvarParceiro(@ModelAttribute Parceiros parceiro) {
        parceirosRepository.save(parceiro);
        return "redirect:/parceiro";
    }

    @GetMapping("/deletar-parceiro/{id}")
    public String deletarParceiro(@PathVariable("id") Long id) {
        parceirosRepository.deleteById(id);
        return "redirect:/administracao";
    }

    // ========== PEDIDOS ==========
    @PostMapping("/pedidos")
    public String salvarPedido(@ModelAttribute Pedidos pedido) {
        pedidosRepository.save(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/deletar-pedido/{id}")
    public String deletarPedido(@PathVariable("id") Long id) {
        pedidosRepository.deleteById(id);
        return "redirect:/administracao";
    }
    
    // ========== FUNCIONÁRIOS ==========
    @GetMapping("/deletar-funcionario/{id}")
    public String deletarFuncionario(@PathVariable("id") Long id) {
        funcionariosRepository.deleteById(id);
        return "redirect:/administracao";
    }
}
