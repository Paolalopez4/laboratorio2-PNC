package org.lab2ejercicio.el_sistema_de_los_7_mares.service.impl;

import lombok.RequiredArgsConstructor;
import org.lab2ejercicio.el_sistema_de_los_7_mares.domain.entity.Pirate;
import org.lab2ejercicio.el_sistema_de_los_7_mares.repository.PirateRepository;
import org.lab2ejercicio.el_sistema_de_los_7_mares.service.PirateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PirateServiceImpl implements PirateService {
    private final PirateRepository pirateRepository;


    @Override
    public void create(Pirate pirate) {
        pirateRepository.save(pirate);
    }

    @Override
    public List<Pirate> findAll() {
        return pirateRepository.findAll();
    }

    @Override
    public Pirate findById(UUID id) {
        return pirateRepository.findById(id).orElse(null);
    }

    @Override
    public void update(UUID id, Pirate pirate) {
        Pirate existingPirate = pirateRepository.findById(id).orElse(null);
        if (existingPirate != null) {
            existingPirate.setName(pirate.getName());
            existingPirate.setBounty(pirate.getBounty());
            existingPirate.setCrew(pirate.getCrew());
            existingPirate.setIsAlive(pirate.getIsAlive());
            pirateRepository.save(existingPirate);
        }
    }

    @Override
    public void deleteById(UUID id) {
        pirateRepository.deleteById(id);
    }
}
