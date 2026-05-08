package org.lab2ejercicio.el_sistema_de_los_7_mares.service.impl;

import org.lab2ejercicio.el_sistema_de_los_7_mares.domain.entity.Pirate;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void create(Pirate pirate);
    List<Pirate> findAll();
    Pirate findById(UUID id);
    void update(Pirate pirate);
    void deleteById(UUID id);
}
