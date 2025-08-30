package br.com.devlee.hospedaae.controller;

import br.com.devlee.hospedaae.model.EmpresaModel;
import br.com.devlee.hospedaae.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<EmpresaModel>getAll(){return empresaService.getAll();}

    @PostMapping
    public EmpresaModel create(@Valid @RequestBody EmpresaModel empresa){return empresaService.save(empresa);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){empresaService.delete(id);}

    @PutMapping("/{id}")
    public EmpresaModel update(@PathVariable UUID id, @Valid @RequestBody EmpresaModel updatedEmpresa){
        return empresaService.update(id, updatedEmpresa);
    }

    @GetMapping("{id}")
    public EmpresaModel searchById(@PathVariable UUID id){
        return empresaService.searchById(id);
    }

}
