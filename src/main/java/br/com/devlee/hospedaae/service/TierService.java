package br.com.devlee.hospedaae.service;

import br.com.devlee.hospedaae.model.TierModel;
import br.com.devlee.hospedaae.repository.TierRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class TierService {
    @Autowired
    private TierRepository repository;


    public List<TierModel> getAll() {
        return repository.findAll();
    }

    public TierModel save(@Valid TierModel tier) {
        return repository.save(tier);
    }

    public TierModel update(UUID id, @Valid TierModel updatedtier) {
        return repository.findById(id).map(tier -> {
            tier.setName(updatedtier.getName());
            tier.setDescricao(updatedtier.getDescricao());
            tier.setValor_diaria(updatedtier.getValor_diaria());
            return repository.save(tier);
        }).orElseThrow(() -> new RuntimeException("Não foi possível localizar nenhum tier atraves do ID fornecido."));
    }


    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
