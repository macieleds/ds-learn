package com.edisonmaciel.dslearn.repositories;

import com.edisonmaciel.dslearn.entities.Topic;
import com.edisonmaciel.dslearn.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
