package com.edisonmaciel.dslearn.services;

import com.edisonmaciel.dslearn.dto.DeliverRevisionDTO;
import com.edisonmaciel.dslearn.repositories.DeliverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeliverService {

    private final DeliverRepository deliverRepository;

    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    @Transactional
    public void saveRevision(Long id, DeliverRevisionDTO deliverRevisionDTO){
        final var deliver = deliverRepository.getById(id);
        deliver.setStatus(deliverRevisionDTO.getStatus());
        deliver.setFeedback(deliverRevisionDTO.getFeedback());
        deliver.setCorrectCount(deliverRevisionDTO.getCorrectCount());
        deliverRepository.save(deliver);
    }
}
