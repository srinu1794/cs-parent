package com.cg.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.notification.Notification;

import reactor.bus.Event;
import reactor.fn.Consumer;

@Service
public class NotificationConsumer implements Consumer<Event<Notification>> {

	@Autowired
	private NotificationService notificationService;

	@Override
	public void accept(Event<Notification> notificationEvent) {
		Notification notification = notificationEvent.getData();
		// TODO add logic to send email/sms notification
		System.err.println("From reveiver");
	}
}