package com.api.metasoft.service;

import com.api.metasoft.repository.FuncionariosRepository;
import com.metasoft.thymeleaf.Funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosService {

    @Autowired
    private FuncionariosRepository repository;

    public List<Funcionarios> listarTodos() {
        return repository.findAll();
    }

    public Funcionarios salvar(Funcionarios funcionarios) {
        return repository.save(funcionarios);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Funcionarios buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
