package br.com.devlee.hospedaae.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserResponseDTO {
    private UUID id;
    private String email;
    private String nomeCompleto;
    private String cpf;
    private boolean administrador;
    private EmpresaResponseDTO empresa;
}
