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

import com.shall.customeraccount.model.Customer;
import com.shall.customeraccount.network.response.ResponseVO;
import com.shall.customeraccount.service.CustomerServiceImpl;
import com.shall.customeraccount.service.GenericService;

@CrossOrigin
@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

	@Autowired
	private GenericService<Customer, Long> service;

	@CrossOrigin
	@RequestMapping(value = "/all", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<ResponseVO<Iterable<Customer>>> getAllCustomerAccounts() {
		return ResponseEntity.ok(new ResponseVO<>(service.findAll()));
	}

	@CrossOrigin
	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<ResponseVO<Customer>> findCustomerByEmail(@RequestParam("email") String email) {
		return ResponseEntity.ok(new ResponseVO<>(((CustomerServiceImpl) service).findByCustomerEmail(email)));
	}

	@CrossOrigin
	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public ResponseEntity<ResponseVO<Customer>> saveCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(new ResponseVO<>(service.save(customer)));
	}

	@CrossOrigin
	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.PUT)
	public ResponseEntity<ResponseVO<Customer>> updateCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(new ResponseVO<>(service.update(customer)));
	}

	@CrossOrigin
	@RequestMapping(value = "/{customer-id}", produces = "application/json; charset=UTF-8", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseVO<Boolean>> deleteCustomer(@PathVariable("customer-id") Long customerId) {
		return ResponseEntity.ok(new ResponseVO<>(service.delete(customerId)));
	}

}
