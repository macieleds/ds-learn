package com.edisonmaciel.dslearn.repositories;

import com.edisonmaciel.dslearn.entities.Course;
import com.edisonmaciel.dslearn.entities.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliverRepository extends JpaRepository<Deliver, Long> {

}
