package br.com.devlee.hospedaae.controller;

import br.com.devlee.hospedaae.dto.QuartoResponseDTO;
import br.com.devlee.hospedaae.model.QuartoModel;
import br.com.devlee.hospedaae.service.QuartoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/quarto")
public class QuartoController {
    @Autowired
    public QuartoService service;

    @PostMapping
    public QuartoModel create(@Valid @RequestBody QuartoModel model){
        return service.save(model);
    }

    @GetMapping
    public List<QuartoResponseDTO> getAll(){
        return service.getAll();
    }

    @PutMapping(("/{id}"))
    public QuartoModel update(@PathVariable UUID id, @Valid @RequestBody QuartoModel model){
        return service.update(id, model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public QuartoModel SearchById(@PathVariable UUID id){
        return service.searchById(id);
    }
}
