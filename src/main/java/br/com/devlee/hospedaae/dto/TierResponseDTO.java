package br.com.devlee.hospedaae.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TierResponseDTO {
    private UUID id;
    private String nome;
    private String descricao;
    private Double valor_diaria;
}
