package com.api.metasoft.controller;

import com.metasoft.thymeleaf.Parceiros;
import com.api.metasoft.service.ParceirosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/parceiros")
public class ParceirosController {

    @Autowired
    private ParceirosService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("parceiros", service.listarTodos());
        return "parceiros/lista"; // página HTML
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("parceiro", new Parceiros());
        return "parceiros/form"; // página HTML
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Parceiros parceiro) {
        service.salvar(parceiro);
        return "redirect:/parceiros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("parceiro", service.buscarPorId(id));
        return "parceiros/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/parceiros";
    }
}
