package com.edisonmaciel.dslearn.repositories;

import com.edisonmaciel.dslearn.entities.Enrollment;
import com.edisonmaciel.dslearn.entities.pk.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {

}
