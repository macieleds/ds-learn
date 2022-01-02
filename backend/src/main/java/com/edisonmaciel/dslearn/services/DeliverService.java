package com.edisonmaciel.dslearn.services;

import com.edisonmaciel.dslearn.dto.DeliverRevisionDTO;
import com.edisonmaciel.dslearn.observers.DeliverRevisionObserver;
import com.edisonmaciel.dslearn.repositories.DeliverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class DeliverService {

    private final DeliverRepository deliverRepository;

    private Set<DeliverRevisionObserver> deliverRevisionObservers = new LinkedHashSet<>();

    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    @Transactional
    public void saveRevision(Long id, DeliverRevisionDTO deliverRevisionDTO){
        final var deliver = deliverRepository.getById(id);
        deliver.setStatus(deliverRevisionDTO.getStatus());
        deliver.setFeedback(deliverRevisionDTO.getFeedback());
        deliver.setCorrectCount(deliverRevisionDTO.getCorrectCount());
        deliverRepository.save(deliver);
        for (DeliverRevisionObserver observer : deliverRevisionObservers) {
            observer.onSaveRevision(deliver);
        }
    }

    public void subscribeDeliverRevisionObserver(DeliverRevisionObserver observer){
        deliverRevisionObservers.add(observer);
    }
}
