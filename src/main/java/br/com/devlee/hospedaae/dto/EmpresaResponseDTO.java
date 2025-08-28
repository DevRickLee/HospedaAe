package br.com.devlee.hospedaae.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EmpresaResponseDTO {
    private UUID id;
    private String nomeFantasia;
    private String cnpj;
}
