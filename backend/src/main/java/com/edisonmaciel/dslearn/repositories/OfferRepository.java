package com.edisonmaciel.dslearn.repositories;

import com.edisonmaciel.dslearn.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {

}
