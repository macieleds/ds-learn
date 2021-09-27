package com.edisonmaciel.dslearn.repositories;

import com.edisonmaciel.dslearn.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
