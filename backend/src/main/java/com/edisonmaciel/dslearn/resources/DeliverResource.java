package com.edisonmaciel.dslearn.resources;

import com.edisonmaciel.dslearn.dto.DeliverRevisionDTO;
import com.edisonmaciel.dslearn.services.DeliverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

    private final DeliverService deliverService;

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverRevisionDTO deliverRevisionDTO){
        deliverService.saveRevision(id, deliverRevisionDTO);
        return ResponseEntity.noContent().build();
    }
}
