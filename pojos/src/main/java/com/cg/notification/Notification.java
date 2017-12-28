package com.cg.notification;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Notification implements Serializable {

	private static final long serialVersionUID = 5493907539271796150L;
	
	@Id
	private String id;
	private ReadStatus readStatus;
	private String recipientId;
	private String comment;
	private RecipientType recipientType;
	private NotificationType notificationType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ReadStatus getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(ReadStatus readStatus) {
		this.readStatus = readStatus;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public RecipientType getRecipientType() {
		return recipientType;
	}

	public void setRecipientType(RecipientType recipientType) {
		this.recipientType = recipientType;
	}

	public NotificationType getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notification [id=");
		builder.append(id);
		builder.append(", readStatus=");
		builder.append(readStatus);
		builder.append(", recipientId=");
		builder.append(recipientId);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", recipientType=");
		builder.append(recipientType);
		builder.append(", notificationType=");
		builder.append(notificationType);
		builder.append("]");
		return builder.toString();
	}

}
