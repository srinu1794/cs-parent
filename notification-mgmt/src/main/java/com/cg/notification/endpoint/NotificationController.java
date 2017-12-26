package com.cg.notification.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.notification.Notification;
import com.cg.notification.service.NotificationService;

@RestController
@RequestMapping("notification")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@PostMapping
	public Notification saveNotification(@RequestBody Notification notification) {
		return notificationService.saveNotification(notification);
	}

	@PutMapping
	public Notification updateNotification(@RequestBody Notification notification) {
		return notificationService.updateNotification(notification);
	}

	@GetMapping("all")
	public List<Notification> getAllNotification() {
		return notificationService.getAllNotification();
	}

	@GetMapping("{id}")
	public Notification getNotificationById(@PathVariable String id) {
		return notificationService.getNotificationById(id);
	}

	@GetMapping(params = { "recipientId" })
	public List<Notification> getByRecipientId(
			@RequestParam(value = "recipientId", required = true) String recipientId) {
		return notificationService.getByRecipientId(recipientId);
	}

}
