package br.com.devlee.hospedaae.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tb_reservas")
public class ReservaModel {
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "quarto_model_id")
    private QuartoModel quartoModel;
    private int qtdHospedes;
    @Embedded
    private Responsavel responsavel;
    private LocalDate checkin;
    private LocalDate checkout;
    private LocalDateTime data_emissao;
}
