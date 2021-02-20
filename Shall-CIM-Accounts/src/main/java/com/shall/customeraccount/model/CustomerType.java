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
@Table(name = "customer_type")
public class CustomerType {

	@Id
	@GeneratedValue
	@Column(name = "customer_type_id")
	private Long customerTypeId;

	@Column(name = "percentage_discount")
	private Long percentageDiscount;

}
