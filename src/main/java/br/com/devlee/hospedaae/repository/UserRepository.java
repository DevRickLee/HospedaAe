package br.com.devlee.hospedaae.repository;


import br.com.devlee.hospedaae.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
