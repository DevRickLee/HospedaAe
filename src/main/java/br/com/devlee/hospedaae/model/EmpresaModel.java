package br.com.devlee.hospedaae.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_empresas")
public class EmpresaModel {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String nomeFantasia;
    @Column(nullable = false)
    private String cnpj;

    @PrePersist
    public void generateId(){
        if(this.id == null){
            this.id = UUID.randomUUID();
        }
    }

    //NoArgs
    public EmpresaModel() {
    }

    //AllArgs
    public EmpresaModel(UUID id, String nomeFantasia, String cnpj) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
