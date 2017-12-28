package com.cg.notification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.notification.Notification;
import com.cg.notification.repo.NotificationRepo;

import reactor.bus.Event;
import reactor.bus.EventBus;

@Service
public class NotificationServiceimpl implements NotificationService {

	@Autowired
	private NotificationRepo notificationRepo;

	@Autowired
	private EventBus eventBus;

	// public String startNotification( String param) {
	// Notification notification = new Notification();
	// notification.setId(param);
	//
	// eventBus.notify("notificationConsumer", Event.wrap(notification));
	//
	// System.out.println("Notification " + param + ": notification task submitted
	// successfully");
	//
	// return "OK";
	// }

	@Override
	public Notification saveNotification(Notification notification) {
		// TODO all business logic goes here

		notification = notificationRepo.saveNotification(notification);
		eventBus.notify("notificationConsumer", Event.wrap(notification));
		System.out.println("Notification " + notification.getId() + ": notification task submitted successfully");
		return notification;
	}

	@Override
	public Notification updateNotification(Notification notification) {
		// TTODO all business logic goes here
		return notificationRepo.updateNotification(notification);
	}

	@Override
	public List<Notification> getAllNotification() {
		// TODO all business logic goes here
		List<Notification> list = notificationRepo.getAllNotification();
		eventBus.notify("notificationConsumer", Event.wrap(list.get(0)));
		System.out.println("Notification notification task submitted successfully");
		return list;
	}

	@Override
	public Notification getNotificationById(String id) {
		// TODO all business logic goes here
		return notificationRepo.getNotificationById(id);
	}

	@Override
	public List<Notification> getByRecipientId(String recipientId) {
		return notificationRepo.getByRecipientId(recipientId);
	}
}