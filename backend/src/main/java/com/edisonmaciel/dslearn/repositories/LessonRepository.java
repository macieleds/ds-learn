package com.edisonmaciel.dslearn.repositories;

import com.edisonmaciel.dslearn.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
