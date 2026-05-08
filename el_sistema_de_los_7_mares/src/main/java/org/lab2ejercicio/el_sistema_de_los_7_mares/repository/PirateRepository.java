package org.lab2ejercicio.el_sistema_de_los_7_mares.repository;

import org.lab2ejercicio.el_sistema_de_los_7_mares.domain.entity.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PirateRepository extends JpaRepository<Pirate, UUID> {
}
