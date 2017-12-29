package com.cg.notification.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.notification.Notification;
import com.cg.notification.RecipientType;

public interface MongoRepo extends MongoRepository<Notification, String> {

	public List<Notification> findByRecipientId(String id);

	public List<Notification> findByRecipientType(RecipientType type);
}
