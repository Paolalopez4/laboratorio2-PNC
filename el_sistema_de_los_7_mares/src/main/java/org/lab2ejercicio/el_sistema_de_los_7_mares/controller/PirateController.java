package org.lab2ejercicio.el_sistema_de_los_7_mares.controller;

import lombok.AllArgsConstructor;
import org.lab2ejercicio.el_sistema_de_los_7_mares.domain.entity.Pirate;
import org.lab2ejercicio.el_sistema_de_los_7_mares.service.impl.PirateServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pirates")
@AllArgsConstructor
public class PirateController {
    private final PirateServiceImpl pirateService;

    @PostMapping
    public ResponseEntity<Pirate> create(@RequestBody Pirate pirate) {
        pirateService.create(pirate);
        return ResponseEntity
                .status(201)
                .body(pirate);
    }

    @GetMapping
    public ResponseEntity<List<Pirate>> findAll() {
        List<Pirate> pirates = pirateService.findAll();
        return ResponseEntity
                .ok(pirates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pirate> findById(@PathVariable UUID id) {
        Pirate pirate = pirateService.findById(id);
        if (pirate != null) {
            return ResponseEntity
                    .ok(pirate);
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pirate> update(@PathVariable UUID id, @RequestBody Pirate pirate) {
        pirateService.update(id, pirate);
        return ResponseEntity
                .ok(pirate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        pirateService.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
