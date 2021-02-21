package com.shall.customeraccount.model;

import java.util.Date;

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
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	private String city;
	@Column(name = "customer_type_id")
	private Long customerTypeId;
	@Column(name = "member_since")
	private Date memberSince;

}
