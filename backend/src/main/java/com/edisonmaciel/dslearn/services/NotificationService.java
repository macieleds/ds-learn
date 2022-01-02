package com.edisonmaciel.dslearn.services;

import com.edisonmaciel.dslearn.dto.NotificationDTO;
import com.edisonmaciel.dslearn.entities.Deliver;
import com.edisonmaciel.dslearn.entities.Notification;
import com.edisonmaciel.dslearn.entities.User;
import com.edisonmaciel.dslearn.observers.DeliverRevisionObserver;
import com.edisonmaciel.dslearn.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class NotificationService implements DeliverRevisionObserver {

    private final NotificationRepository notificationRepository;

    private final AuthService authService;

    private final DeliverService deliverService;

    @PostConstruct
    private void initialize(){
        deliverService.subscribeDeliverRevisionObserver(this);
    }

    @Transactional(readOnly = true)
    public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pageable) {
        User user = authService.authenticated();
        Page<Notification> page = notificationRepository.find(user, unreadOnly, pageable);
        return page.map(NotificationDTO::new);
    }

    @Transactional
    public void saveDeliverNotification (Deliver deliver){
        Long sectionId = deliver.getLesson().getSection().getId();
        Long resourceId = deliver.getLesson().getSection().getResource().getId();
        Long offerId = deliver.getLesson().getSection().getResource().getOffer().getId();

        String route = "/offers/" + offerId + "/resources/" + resourceId + "/sections/" + sectionId;
        String text = deliver.getFeedback();
        Instant moment = Instant.now();
        final var user = deliver.getEnrollment().getStudent();

        final var notification = new Notification(null, text, moment, false, route, user);
        notificationRepository.save(notification);

    }

    @Override
    public void onSaveRevision(Deliver deliver) {
        saveDeliverNotification(deliver);
    }
}
