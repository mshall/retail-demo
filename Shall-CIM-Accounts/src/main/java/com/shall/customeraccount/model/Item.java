package com.shall.customeraccount.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private Long itemId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "item_price")
	private double itemPrice;
	@Column(name = "item_type")
	private Long itemType;

	

}
