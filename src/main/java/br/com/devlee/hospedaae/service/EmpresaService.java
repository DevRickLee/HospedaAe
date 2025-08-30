package br.com.devlee.hospedaae.service;

import br.com.devlee.hospedaae.model.EmpresaModel;
import br.com.devlee.hospedaae.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public List<EmpresaModel> getAll() {return empresaRepository.findAll();}

    public EmpresaModel save(EmpresaModel empresa) {return empresaRepository.save(empresa);}

    public void delete(UUID id) {empresaRepository.deleteById(id);}

    public EmpresaModel update(UUID id, EmpresaModel updatedEmpresa) {
        return empresaRepository.findById(id).map(empresa -> {
            empresa.setNomeFantasia(updatedEmpresa.getNomeFantasia());
            empresa.setCnpj(updatedEmpresa.getCnpj());
            return empresaRepository.save(empresa);
        }).orElseThrow(() -> new RuntimeException("Empresa não encontrada com o ID: " + id));
    }

    public EmpresaModel searchById(UUID id) {
        return empresaRepository.findById(id).orElseThrow(() -> new RuntimeException("Não foi possível localizar nenhuma empresa com o ID fornecido."));
    }
}
