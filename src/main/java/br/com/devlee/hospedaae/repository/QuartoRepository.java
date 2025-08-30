package br.com.devlee.hospedaae.repository;

import br.com.devlee.hospedaae.model.QuartoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuartoRepository extends JpaRepository<QuartoModel, UUID> {
}
