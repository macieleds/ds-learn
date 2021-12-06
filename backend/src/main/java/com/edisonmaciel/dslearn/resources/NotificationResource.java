package com.edisonmaciel.dslearn.resources;

import com.edisonmaciel.dslearn.dto.NotificationDTO;
import com.edisonmaciel.dslearn.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {

    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> findAll(
            @RequestParam(value = "unreadOnly", defaultValue = "false") Boolean unreadOnly ,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "12") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<NotificationDTO> list = notificationService.notificationsForCurrentUser(unreadOnly, pageRequest);
        return ResponseEntity.ok().body(list);
    }
}
