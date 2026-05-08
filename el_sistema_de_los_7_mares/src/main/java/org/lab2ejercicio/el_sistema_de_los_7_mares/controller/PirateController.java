package org.lab2ejercicio.el_sistema_de_los_7_mares.controller;

import lombok.AllArgsConstructor;
import org.lab2ejercicio.el_sistema_de_los_7_mares.domain.entity.Pirate;
import org.lab2ejercicio.el_sistema_de_los_7_mares.service.impl.PirateServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pirate")
@AllArgsConstructor
public class PirateController {
    private final PirateServiceImpl pirateService;

    @PostMapping("/create")
    public ResponseEntity<Pirate> create(@RequestBody Pirate pirate) {
        pirateService.create(pirate);
        return ResponseEntity
                .status(201)
                .body(pirate);
    }

    @PostMapping("/findAll")
    public ResponseEntity<List<Pirate>> findAll() {
        List<Pirate> pirates = pirateService.findAll();
        return ResponseEntity
                .ok(pirates);
    }

    @PostMapping("/findById")
    public ResponseEntity<Pirate> findById(@RequestBody String id) {
        Pirate pirate = pirateService.findById(java.util.UUID.fromString(id));
        if (pirate != null) {
            return ResponseEntity
                    .ok(pirate);
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Void> update(@RequestBody Pirate pirate) {
        pirateService.update(pirate.getId(), pirate);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping("/deleteById")
    public ResponseEntity<Void> deleteById(@RequestBody String id) {
        pirateService.deleteById(java.util.UUID.fromString(id));
        return ResponseEntity
                .noContent()
                .build();
    }
}
