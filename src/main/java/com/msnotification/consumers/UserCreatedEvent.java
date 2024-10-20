package com.msnotification.consumers;

import com.msnotification.entity.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.kafka.common.protocol.types.Field;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatedEvent {
    private Long id;
    private String email;
    private LocalDate dateOfBirth;
    private Boolean status;

    public static Notification eventToNotificationEntity(UserCreatedEvent event) {
        return Notification.builder()
                .userId(event.getId())
                .email(event.getEmail())
                .dateOfBirth(String.valueOf(event.getDateOfBirth()))
                .isSend(Boolean.TRUE)
                .build();
    }
}
