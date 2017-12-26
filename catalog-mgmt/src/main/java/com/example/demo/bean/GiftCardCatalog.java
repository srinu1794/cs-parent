package com.example.demo.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Catalog_Gift_Card")
public class GiftCardCatalog {
	
	@Id
	private String Id;
	
	private String giftcard_id;
	private String gift_card_value;
	/**
	 * @return the gift_card_value
	 */
	public String getGift_card_value() {
		return gift_card_value;
	}
	/**
	 * @param gift_card_value the gift_card_value to set
	 */
	public void setGift_card_value(String gift_card_value) {
		this.gift_card_value = gift_card_value;
	}
	/**
	 * @return the giftcard_id
	 */
	public String getGiftcard_id() {
		return giftcard_id;
	}
	/**
	 * @param giftcard_id the giftcard_id to set
	 */
	public void setGiftcard_id(String giftcard_id) {
		this.giftcard_id = giftcard_id;
	}
}