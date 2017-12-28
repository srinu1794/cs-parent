package com.cg.catalog;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Catalog_Gift_Card")
public class GiftCardCatalog {
	
	@Id
	private String Id;
	
	private String giftCardId;
	private String giftCardValue;
	/**
	 * @return the giftCardId
	 */
	public String getGiftCardId() {
		return giftCardId;
	}
	/**
	 * @param giftCardId the giftCardId to set
	 */
	public void setGiftCardId(String giftCardId) {
		this.giftCardId = giftCardId;
	}
	/**
	 * @return the giftCardValue
	 */
	public String getGiftCardValue() {
		return giftCardValue;
	}
	/**
	 * @param giftCardValue the giftCardValue to set
	 */
	public void setGiftCardValue(String giftCardValue) {
		this.giftCardValue = giftCardValue;
	}

}
