package com.cg.notification.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.notification.Notification;

public interface MongoRepo extends MongoRepository<Notification, String> {

	public List<Notification> findByRecipientId(String id);
}
