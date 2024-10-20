package com.msnotification.service;

import com.msnotification.entity.Notification;
import com.msnotification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void save(Notification notification) {
        Notification savedEntity = notificationRepository.save(notification);
        log.info("Saved Notification Id: {}", savedEntity.getId());
    }

}
