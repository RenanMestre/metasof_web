package com.api.metasoft.service;

import com.api.metasoft.repository.ParceirosRepository;
import com.metasoft.thymeleaf.Parceiros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParceirosService {

    @Autowired
    private ParceirosRepository repository;

    public List<Parceiros> listarTodos() {
        return repository.findAll();
    }

    public Parceiros salvar(Parceiros parceiro) {
        return repository.save(parceiro);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Parceiros buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
