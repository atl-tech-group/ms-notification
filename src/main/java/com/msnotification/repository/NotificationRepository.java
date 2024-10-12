package com.msnotification.repository;

import com.msnotification.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {

    @Query("{'date_of_birth': {'$regex': ?0}}")
    List<Notification> findUsersWithBirthday(String datePattern);
}
