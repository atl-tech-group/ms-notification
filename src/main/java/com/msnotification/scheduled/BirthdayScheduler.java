package com.msnotification.scheduled;

import com.msnotification.entity.Notification;
import com.msnotification.repository.NotificationRepository;
import com.msnotification.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class BirthdayScheduler {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    @Scheduled(cron = "0 1 0 * * ?")  // At 00:01 AM every day
    public void checkAndSendBirthdayEmails() {
        System.out.println("50 sec");
        LocalDate today = LocalDate.now();
        System.out.println("LocalDate.now()" + LocalDate.now());
        List<Notification> usersWithBirthdayToday = notificationRepository.findByDateOfBirth(today);

        if (usersWithBirthdayToday.isEmpty()) {
            log.info("No birthdays found for today: {}", today);
            return;
        }

        for (Notification notification : usersWithBirthdayToday) {
            emailService.sendBirthdayEmail(notification.getEmail());
            log.info("Birthday email sent to: {}", notification.getEmail());
        }
    }
}