package br.com.devlee.hospedaae.controller;

import br.com.devlee.hospedaae.model.TierModel;
import br.com.devlee.hospedaae.service.TierService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tier")
public class TierController {
    private final TierService tierService;

    public TierController(TierService tierService){
        this.tierService = tierService;
    }

    @GetMapping
    public List<TierModel> getAll(){
        return tierService.getAll();
    }

    @PostMapping
    public TierModel create(@Valid @RequestBody TierModel tier){
        return tierService.save(tier);
    }

    @PutMapping("/{id}")
    public TierModel update(@PathVariable UUID id, @Valid @RequestBody TierModel tier){
        return tierService.update(id, tier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        tierService.delete(id);
    }


}
