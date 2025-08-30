package br.com.devlee.hospedaae.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class QuartoResponseDTO {
    private UUID id;
    private String nome_quarto;
    private int capacidade_maxima;
    private String tipo_cama;
    private TierResponseDTO tier;
    private EmpresaResponseDTO empresa;
}
