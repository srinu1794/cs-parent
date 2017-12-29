package com.cg.notification.repo;

import java.util.List;

import com.cg.notification.Notification;
import com.cg.notification.RecipientType;

public interface NotificationRepo {
	public Notification saveNotification(Notification notification);

	public Notification updateNotification(Notification notification);

	public List<Notification> getAllNotification();

	public Notification getNotificationById(String id);

	public List<Notification> getByRecipientId(String recipientId);

	List<Notification> getByRecipientType(RecipientType type);
}
