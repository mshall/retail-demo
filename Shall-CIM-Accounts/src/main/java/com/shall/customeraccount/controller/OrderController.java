package com.shall.customeraccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shall.customeraccount.dto.OrderDTO;
import com.shall.customeraccount.dto.ResultDTO;
import com.shall.customeraccount.model.Customer;
import com.shall.customeraccount.network.response.ResponseVO;
import com.shall.customeraccount.service.CustomerServiceImpl;
import com.shall.customeraccount.service.GenericService;
import com.shall.customeraccount.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/v1/order")
public class OrderController {

	@Autowired
	private OrderService service;



	@CrossOrigin
	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public ResponseEntity<ResponseVO<ResultDTO>> processOrder(@RequestBody OrderDTO order) {
		return ResponseEntity.ok(new ResponseVO<>(service.processOrder(order)));
	}


}
