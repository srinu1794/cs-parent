package com.cg.notification;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.notification.service.NotificationService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class NotificationTests {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private MongoTemplate mongoTemplate;

	private List<Notification> prepareData() {
		List<Notification> list = new ArrayList<>();
		Notification n = new Notification();
		n.setComment("First notification");
		n.setNotificationType(NotificationType.SUCCESS);
		n.setReadStatus(ReadStatus.READ);
		n.setRecipientId("100");
		n.setRecipientType(RecipientType.EMAIL);
		list.add(n);
		return list;
	}

	@Before
	public void setup() {
		System.err.println("setup running");
		mongoTemplate.insert(prepareData(), "notification");
	}

	@Test
	public void getAllTest() {
		List<Notification> list = notificationService.getAllNotification();
		assertTrue(list.size() == 1);
	}

	@Test
	public void getByrecipientId() {
		List<Notification> list = notificationService.getByRecipientId("100");
		assertNotNull(list);
		assertTrue(list.size() == 1);
		assertTrue(list.get(0).getRecipientId().equals("100"));

	}
}