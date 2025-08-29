package br.com.devlee.hospedaae.repository;

import br.com.devlee.hospedaae.model.TierModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TierRepository extends JpaRepository<TierModel, UUID> {
}
