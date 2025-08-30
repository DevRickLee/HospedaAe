package br.com.devlee.hospedaae.service;

import br.com.devlee.hospedaae.dto.EmpresaResponseDTO;
import br.com.devlee.hospedaae.dto.QuartoResponseDTO;
import br.com.devlee.hospedaae.dto.TierResponseDTO;
import br.com.devlee.hospedaae.dto.UserResponseDTO;
import br.com.devlee.hospedaae.model.EmpresaModel;
import br.com.devlee.hospedaae.model.QuartoModel;
import br.com.devlee.hospedaae.model.TierModel;
import br.com.devlee.hospedaae.model.UserModel;
import br.com.devlee.hospedaae.repository.EmpresaRepository;
import br.com.devlee.hospedaae.repository.QuartoRepository;
import br.com.devlee.hospedaae.repository.TierRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QuartoService {
    @Autowired
    private QuartoRepository repository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private TierRepository tierRepository;

    public QuartoModel save(@Valid QuartoModel model) {
        QuartoModel savedQuarto = repository.save(model);
        EmpresaModel empresaCompleta = empresaRepository.findById(savedQuarto.getEmpresa().getId()).get();
        savedQuarto.setEmpresa(empresaCompleta);

        TierModel tierCompleto = tierRepository.findById(savedQuarto.getTier_quarto().getId()).get();
        savedQuarto.setTier_quarto(tierCompleto);

        return savedQuarto;

    }

    public List<QuartoResponseDTO> getAll() {
        List<QuartoModel> quartos = repository.findAll();
        return quartos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }


    public QuartoModel update(UUID id, @Valid QuartoModel model) {
        return repository.findById(id).map( quarto -> {
            quarto.setNome_quarto(model.getNome_quarto());
            quarto.setTier_quarto(model.getTier_quarto());
            quarto.setTipo_cama(model.getTipo_cama());
            quarto.setCapacidade_maxima(model.getCapacidade_maxima());
            return repository.save(quarto);
        }).orElseThrow(() -> new RuntimeException("Não foi possível localizar nenhum quarto através do ID fornecido."));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public QuartoModel searchById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Não foi possível localizar nenhum quarto através do ID fornecido."));
    }

    public QuartoResponseDTO toDTO(QuartoModel quartoModel){
        QuartoResponseDTO dto = new QuartoResponseDTO();
        dto.setId(quartoModel.getId());
        dto.setNome_quarto(quartoModel.getNome_quarto());
        dto.setCapacidade_maxima(quartoModel.getCapacidade_maxima());
        dto.setTipo_cama(quartoModel.getTipo_cama());

        if(quartoModel.getEmpresa() != null){
            EmpresaResponseDTO empresaDTO = new EmpresaResponseDTO();
            empresaDTO.setId(quartoModel.getEmpresa().getId());
            empresaDTO.setNomeFantasia(quartoModel.getEmpresa().getNomeFantasia());
            empresaDTO.setCnpj(quartoModel.getEmpresa().getCnpj());
            dto.setEmpresa(empresaDTO);
        }
        if(quartoModel.getId() != null){
            TierResponseDTO tierDto = new TierResponseDTO();
            tierDto.setId(quartoModel.getTier_quarto().getId());
            tierDto.setNome(quartoModel.getTier_quarto().getName());
            tierDto.setDescricao(quartoModel.getTier_quarto().getDescricao());
            tierDto.setValor_diaria(quartoModel.getTier_quarto().getValor_diaria());
            dto.setTier(tierDto);
        }
        return dto;
    }
}
