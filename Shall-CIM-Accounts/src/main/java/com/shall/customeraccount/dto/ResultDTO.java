package com.shall.customeraccount.dto;

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
public class ResultDTO {

	private String message;
	private double beforeDiscountAmount;
	private double outstandingAmount;
	private double discountedAmount;
	private Long discountPercentage;

}
