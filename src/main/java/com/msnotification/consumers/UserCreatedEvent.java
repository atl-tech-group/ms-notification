package com.msnotification.consumers;

import com.msnotification.entity.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.kafka.common.protocol.types.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatedEvent {
    private Long id;
    private String email;
    private Boolean status;

    public static Notification eventToNotificationEntity(UserCreatedEvent event) {
        return Notification.builder()
                .userId(event.getId())
                .email(event.getEmail())
                .isSend(Boolean.TRUE)
                .build();
    }
}
