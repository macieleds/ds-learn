package com.edisonmaciel.dslearn.repositories;

import com.edisonmaciel.dslearn.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
