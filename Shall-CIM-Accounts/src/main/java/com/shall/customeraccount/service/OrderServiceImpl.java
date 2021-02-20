package com.shall.customeraccount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.shall.customeraccount.model.Customer;
import com.shall.customeraccount.repository.CustomerRepository;

@Service
public class OrderServiceImpl implements GenericService<Customer, Long> {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CrudRepository<Customer, Long> getRepository() {
		// TODO Auto-generated method stub
		return customerRepository;
	}

	@Override
	public Long getId(Customer entity) {
		return entity.getCustomerId();
	}

	@Override
	public Customer save(Customer entity) {
		return GenericService.super.save(entity);
	}

	public Customer findByCustomerEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	/*
	 * @Override public Customer createCustomer(Customer Customer) { return
	 * CustomerRepository.save(Customer); }
	 * 
	 * @Override public Customer getCustomer(Long id) { return
	 * CustomerRepository.findOne(id); }
	 * 
	 * @Override public Customer editCustomer(Customer Customer) { return
	 * CustomerRepository.save(Customer); }
	 * 
	 * @Override public void deleteCustomer(Customer Customer) {
	 * CustomerRepository.delete(Customer); }
	 * 
	 * @Override public void deleteCustomer(Long id) {
	 * CustomerRepository.delete(id); }
	 * 
	 * @Override public List<Customer> getAllCustomers(int pageNumber, int
	 * pageSize) { return CustomerRepository.findAll(new PageRequest(pageNumber,
	 * pageSize)).getContent(); }
	 * 
	 * @Override public List<Customer> getAllCustomers() { return
	 * CustomerRepository.findAll(); }
	 * 
	 * @Override public long countCustomers() { return
	 * CustomerRepository.count(); }
	 */
}
