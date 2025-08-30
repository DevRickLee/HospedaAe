package br.com.devlee.hospedaae.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_quartos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuartoModel {
    @Id
    private UUID id;
    @NotBlank
    @Column(nullable = false)
    private String nome_quarto;
    @NotNull
    @Column(nullable = false)
    private int capacidade_maxima;
    @NotNull
    @Column(nullable = false)
    private String tipo_cama;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tier")
    private TierModel tier_quarto;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private EmpresaModel empresa;

    @PrePersist
    public void generateId(){
        if(this.id == null){
            this.id = UUID.randomUUID();
        }
    }
}
