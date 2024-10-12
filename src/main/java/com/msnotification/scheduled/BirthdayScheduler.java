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

    @Scheduled(cron = "0 1 0 * * ?")
    public void checkAndSendBirthdayEmails() {
        LocalDate today = LocalDate.now();
        String datePattern = String.format("%02d-%02d", today.getMonthValue(), today.getDayOfMonth());

        List<Notification> usersWithBirthdayToday = notificationRepository.findUsersWithBirthday(datePattern);

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
