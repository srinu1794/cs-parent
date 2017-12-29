package com.cg.notification.service;

import java.util.List;

import com.cg.notification.Notification;
import com.cg.notification.RecipientType;

public interface NotificationService {

	public Notification saveNotification(Notification notification);

	public Notification updateNotification(Notification notification);

	public List<Notification> getAllNotification();

	public Notification getNotificationById(String id);

	public List<Notification> getByRecipientId(String recipientId);

	public List<Notification> getByRecipientType(RecipientType recipientType);

}