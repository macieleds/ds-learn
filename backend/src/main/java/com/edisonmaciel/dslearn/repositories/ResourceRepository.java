package com.edisonmaciel.dslearn.repositories;

import com.edisonmaciel.dslearn.entities.Reply;
import com.edisonmaciel.dslearn.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
