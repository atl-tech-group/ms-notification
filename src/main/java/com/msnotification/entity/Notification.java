package com.msnotification.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collation = "notifications")
@Getter
@Setter
@Builder
public class Notification extends BaseEntity {

    @Id
    private String id;

    @Field("user_id")
    private Long userId;
    private String email;
    @Field("is_send")
    private Boolean isSend;

    //Document version control
    @Version
    private Long version;
}
