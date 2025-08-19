package com.api.metasoft.controller;

import com.api.metasoft.repository.FuncionariosRepository;
import com.api.metasoft.repository.ParceirosRepository;
import com.api.metasoft.repository.PedidosRepository;
import com.api.metasoft.repository.LoginRepository;
import com.metasoft.thymeleaf.Login;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private LoginRepository loginRepository;
    
    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ParceirosRepository parceirosRepository;
    
    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @GetMapping("/login")
    public String loginForm(Model model) {
        // opcional: passa mensagens para login.html
        model.addAttribute("erro", null);
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model
    ) {
        Login user = loginRepository.findByUsername(username);
        if (user != null) {
            String senhaBanco = user.getPassword();
            if (senhaBanco.equals(password)) {
                session.setAttribute("usuarioLogado", user);

                // redireciona conforme o tipo
                return switch (user.getTipo()) {
                    case "admin" -> "redirect:/administracao";
                    case "pedido" -> "redirect:/pedidos";
                    case "parceiro" -> "redirect:/parceiro";
                    default -> "redirect:/index";
                };
            }
        }

        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/administracao")
    public String admin(HttpSession session, Model model) {
        Login user = (Login) session.getAttribute("usuarioLogado");

        if (user == null || !"admin".equals(user.getTipo())) {
            return "redirect:/login";
        }

        model.addAttribute("parceiros", parceirosRepository.findAll());
        model.addAttribute("pedidos", pedidosRepository.findAll());
        model.addAttribute("funcionarios", funcionariosRepository.findAll());

        return "administracao";
    }

    
    @GetMapping("/pedidos")
    public String pedidos(HttpSession session) {
        Login user = (Login) session.getAttribute("usuarioLogado");
        if (user == null || !"pedido".equals(user.getTipo())) {
            return "redirect:/login";
        }
        return "pedidos";
    }
    
    @GetMapping("/parceiro")
    public String parceiro(HttpSession session) {
        Login user = (Login) session.getAttribute("usuarioLogado");
        if (user == null || !"parceiro".equals(user.getTipo())) {
            return "redirect:/login";
        }
        return "parceiro";
    }
}
