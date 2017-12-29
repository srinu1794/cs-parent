package com.cg.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
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
		n.setReadStatus(ReadStatus.UNREAD);
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

	@After
	public void setupClean() {
		System.err.println("setup clean  running");
		mongoTemplate.dropCollection(Notification.class);
	}

	@Test
	public void getAllTest() {
		List<Notification> list = notificationService.getAllNotification();
		assertTrue(list.size() == 1);
	}

	@Test
	public void testCreate() {
		Notification n = new Notification();
		n.setComment("Create notification");
		n.setNotificationType(NotificationType.SUCCESS);
		n.setReadStatus(ReadStatus.UNREAD);
		n.setRecipientId("101");
		n.setRecipientType(RecipientType.SMS);
		n = notificationService.saveNotification(n);

		Notification n1 = new Notification();
		n1.setComment("create new notification");
		n1.setNotificationType(NotificationType.INFO);
		n1.setReadStatus(ReadStatus.READ);
		n1.setRecipientId("102");
		n1.setRecipientType(RecipientType.EMAIL_SMS);
		n1 = notificationService.saveNotification(n1);
		assertNotNull(n);
		assertNotNull(n.getId());
		assertTrue("Size of list returned is not as expected", notificationService.getAllNotification().size() == 3);
	}

	@Test
	public void testUpdate() {
		Notification n = notificationService.getAllNotification().get(0);
		n.setReadStatus(ReadStatus.READ);
		n.setNotificationType(NotificationType.ERROR);
		Notification n1 = notificationService.updateNotification(n);
		assertNotNull(n);
		assertTrue(n1.getId().equals(n.getId()));
		assertEquals("updated ok", ReadStatus.READ,n1.getReadStatus());
		assertFalse(n1.getId() != (n.getId()));
		assertNotEquals("not updated", n1.getReadStatus(), ReadStatus.UNREAD);
		assertNotEquals("not updated", n1.getNotificationType(), NotificationType.SUCCESS);
		assertEquals("updated ok", NotificationType.ERROR, n1.getNotificationType());
	}

	@Test
	public void notificationById() {
		Notification n = notificationService
				.getNotificationById(notificationService.getAllNotification().get(0).getId());
		assertNotNull(n.getId());
		assertEquals(notificationService.getAllNotification().get(0).getId(), n.getId());
		assertEquals(n.getNotificationType().SUCCESS,
				notificationService.getAllNotification().get(0).getNotificationType());
		assertNotEquals(notificationService.getAllNotification().get(0).getNotificationType(),
				n.getNotificationType().ERROR);
		assertNotEquals(notificationService.getAllNotification().get(0).getNotificationType(),
				n.getNotificationType().INFO);
		assertNotEquals(notificationService.getAllNotification().get(0).getNotificationType(),
				n.getNotificationType().WARNING);
	}

	@Test
	public void recipientId() {
		List<Notification> n = notificationService.getByRecipientId("102");
		assertNotNull(n);
		assertTrue(n.size() == 0);
		assertFalse(n.size() == 1);

	}

	@Test
	public void recipientType() {
		List<Notification> n = notificationService.getByRecipientType(RecipientType.EMAIL);
		System.err.println(n);
		assertNotNull(n);
		assertEquals(RecipientType.EMAIL, n.get(0).getRecipientType());
		assertNotEquals(RecipientType.SMS, n.get(0).getRecipientType());
		assertNotEquals(RecipientType.EMAIL_SMS, n.get(0).getRecipientType());
		assertNotEquals(RecipientType.WEBNOTIFICATION, n.get(0).getRecipientType());
	}
}