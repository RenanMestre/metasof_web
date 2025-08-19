package com.api.metasoft.controller;

import com.metasoft.thymeleaf.Funcionarios;
import com.api.metasoft.service.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {

    @Autowired
    private FuncionariosService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("funcionarios", service.listarTodos());
        return "funcionarios/lista"; // página HTML
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("funcionario", new Funcionarios());
        return "funcionarios/form"; // página HTML
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Funcionarios funcionario) {
        service.salvar(funcionario);
        return "redirect:/parceiros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("funcionario", service.buscarPorId(id));
        return "funcionarios/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/funcionarios";
    }
}
