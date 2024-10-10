package com.msnotification.repository;

import com.msnotification.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
}
