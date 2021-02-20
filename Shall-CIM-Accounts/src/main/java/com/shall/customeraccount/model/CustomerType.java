package com.shall.customeraccount.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_type_id")
public class CustomerType {
	
	@Id
	@GeneratedValue
	@Column(name="customer_type_id")
	private Long customerTypeId;
	
	@Column(name="percentage_discount")
	private int percentageDiscount;

	public CustomerType() {
		super();
	}

	public CustomerType(Long customerTypeId, int percentageDiscount) {
		super();
		this.customerTypeId = customerTypeId;
		this.percentageDiscount = percentageDiscount;
	}

	public Long getCustomerTypeId() {
		return customerTypeId;
	}

	public void setCustomerTypeId(Long customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public int getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(int percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}
	
	
	
}

