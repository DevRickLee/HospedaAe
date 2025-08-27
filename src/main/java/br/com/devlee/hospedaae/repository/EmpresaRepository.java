package br.com.devlee.hospedaae.repository;

import br.com.devlee.hospedaae.model.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, UUID> { }
