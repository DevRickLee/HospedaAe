package br.com.devlee.hospedaae.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Embeddable
public class Responsavel {
    @CPF
    @NotEmpty
    private String cpf;
    @NotBlank
    private String nome;
}
