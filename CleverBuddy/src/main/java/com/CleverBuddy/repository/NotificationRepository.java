package com.CleverBuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cleverbuddy.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
