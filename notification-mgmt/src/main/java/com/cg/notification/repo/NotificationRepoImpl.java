package com.cg.notification.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.notification.Notification;

@Repository
public class NotificationRepoImpl implements NotificationRepo {

	@Autowired
	private MongoRepo mongoRepo;

	@Override
	public Notification saveNotification(Notification notification) {
		return mongoRepo.insert(notification);
	}

	@Override
	public Notification updateNotification(Notification notification) {
		return mongoRepo.save(notification);
	}

	@Override
	public List<Notification> getAllNotification() {
		return mongoRepo.findAll();
	}

	@Override
	public Notification getNotificationById(String id) {
		return mongoRepo.findOne(id);
	}

	@Override
	public List<Notification> getByRecipientId(String id) {
		return mongoRepo.findByRecipientId(id);
	}

}
