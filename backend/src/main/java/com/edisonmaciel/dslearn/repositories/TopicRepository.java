package com.edisonmaciel.dslearn.repositories;

import com.edisonmaciel.dslearn.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
