package com.api.metasoft.controller;

import com.api.metasoft.service.PedidosService;
import com.metasoft.thymeleaf.Pedidos;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    // Método para listar pedidos
    @GetMapping
    public String listarPedidos(Model model, HttpSession session) {
        model.addAttribute("pedidos", pedidosService.listarTodos());

        // Adiciona tema à página
        String theme = (String) session.getAttribute("theme");
        model.addAttribute("theme", theme != null ? theme : "light");

        return "pedidos/lista"; // Crie a view em templates/pedidos/lista.html
    }

    // Exibe o formulário de cadastro
    @GetMapping("/novo")
    public String novoPedido(Model model, HttpSession session) {
        model.addAttribute("pedido", new Pedidos());

        String theme = (String) session.getAttribute("theme");
        model.addAttribute("theme", theme != null ? theme : "light");

        return "pedidos/form"; // Crie a view em templates/pedidos/form.html
    }

    // Salva novo pedido
    @PostMapping
    public String salvarPedido(@ModelAttribute Pedidos pedido) {
        pedidosService.salvar(pedido);
        return "redirect:/pedidos";
    }

    // Deletar pedido
    @GetMapping("/deletar/{id}")
    public String deletarPedido(@PathVariable("id") Long id) {
        pedidosService.deletar(id);
        return "redirect:/pedidos";
    }

    // Editar pedido
    @GetMapping("/editar/{id}")
    public String editarPedido(@PathVariable("id") Long id, Model model, HttpSession session) {
        Pedidos pedido = pedidosService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado: " + id));

        model.addAttribute("pedido", pedido);

        String theme = (String) session.getAttribute("theme");
        model.addAttribute("theme", theme != null ? theme : "light");

        return "pedidos/form"; // mesma view do novo, mas preenchida
    }
}
