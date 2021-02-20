package com.shall.customeraccount.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private Long customerId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "item_price")
	private double itemPrice;
	@Column(name = "item_type")
	private Long itemType;

	public Item() {
		super();
	}

	public Item(Long customerId, String itemName, double itemPrice, Long itemType) {
		super();
		this.customerId = customerId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemType = itemType;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Long getItemType() {
		return itemType;
	}

	public void setItemType(Long itemType) {
		this.itemType = itemType;
	}

}
