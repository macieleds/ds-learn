package com.edisonmaciel.dslearn.repositories;

import com.edisonmaciel.dslearn.entities.Resource;
import com.edisonmaciel.dslearn.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {

}
