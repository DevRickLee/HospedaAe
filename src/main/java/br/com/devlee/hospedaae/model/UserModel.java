package br.com.devlee.hospedaae.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class UserModel {
    @Id
    private UUID id;
    @Column(nullable = false)
    @NotBlank
    private String email;
    @Column(nullable = false)
    @NotBlank
    private String senha;
    @Column(nullable = false)
    @NotBlank
    private String nomeCompleto;
    @Column(nullable = false)
    @NotBlank
    private String cpf;
    @Column(nullable = false)
    private boolean administrador;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa", nullable = false)
    private EmpresaModel empresa;

    @PrePersist
    public void generateId(){
        if(this.id == null){
            this.id = UUID.randomUUID();
        }
    }

    public UserModel() {
    }

    public UserModel(UUID id, EmpresaModel empresa, boolean administrador, String cpf, String nomeCompleto, String senha, String email) {
        this.id = id;
        this.empresa = empresa;
        this.administrador = administrador;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public EmpresaModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }
}
