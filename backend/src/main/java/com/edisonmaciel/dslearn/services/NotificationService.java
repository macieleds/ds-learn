package com.edisonmaciel.dslearn.services;

import com.edisonmaciel.dslearn.dto.NotificationDTO;
import com.edisonmaciel.dslearn.entities.Notification;
import com.edisonmaciel.dslearn.entities.User;
import com.edisonmaciel.dslearn.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    private final AuthService authService;

    public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pageable) {
        User user = authService.authenticated();
        Page<Notification> page = notificationRepository.find(user, unreadOnly, pageable);
        return page.map(NotificationDTO::new);
    }

}
