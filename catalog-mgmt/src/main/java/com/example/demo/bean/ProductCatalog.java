package com.example.demo.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Catalog_Products")
public class ProductCatalog {

	@Id
	private String Id;
	
	
	private String product_id_parent;
	private String product_id_child;
	private String price;
	
	
	/**
	 * @return the product_id_parent
	 */
	public String getProduct_id_parent() {
		return product_id_parent;
	}
	/**
	 * @param product_id_parent the product_id_parent to set
	 */
	public void setProduct_id_parent(String product_id_parent) {
		this.product_id_parent = product_id_parent;
	}
	/**
	 * @return the product_id_child
	 */
	public String getProduct_id_child() {
		return product_id_child;
	}
	/**
	 * @param product_id_child the product_id_child to set
	 */
	public void setProduct_id_child(String product_id_child) {
		this.product_id_child = product_id_child;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the gift_card_id
	 */
	/*public String getGift_card_id() {
		return gift_card_id;
	}
	*//**
	 * @param gift_card_id the gift_card_id to set
	 *//*
	public void setGift_card_id(String gift_card_id) {
		this.gift_card_id = gift_card_id;
	}*/
	
}
