package br.com.devlee.hospedaae.controller;

import br.com.devlee.hospedaae.model.EmpresaModel;
import br.com.devlee.hospedaae.service.EmpresaService;
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
    public EmpresaModel create(@RequestBody EmpresaModel empresa){return empresaService.save(empresa);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){empresaService.delete(id);}

}
