package com.shall.customeraccount.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shall.customeraccount.model.Customer;
import com.shall.customeraccount.model.CustomerType;
import com.shall.customeraccount.model.Item;
import com.shall.customeraccount.repository.CustomerRepository;
import com.shall.customeraccount.repository.CustomerTypeRepository;
import com.shall.customeraccount.repository.ItemRepository;
import com.shall.customeraccount.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { OrderService.class })
public class OrderServiceTest {

	@Autowired
	private OrderService orderService;
	@MockBean
	private CustomerRepository customerRepository;
	@MockBean
	private ItemRepository itemRepository;
	@MockBean
	private CustomerTypeRepository customerTypeRepository;
	Customer customer = new Customer();
	CustomerType customerType = new CustomerType();
	Item item = new Item();
	List<Item> items;
	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
	Date firstDate;
	

	@Before
	public void setUp() {
		try {
			firstDate = dateformat.parse("17/07/2018");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		customer.setFirstName("Mohamed");
		customer.setLastName("Shall");
		customer.setCity("Dubai");
		customer.setEmail("mohamed.s.elshall2011@gmail.com");
		customer.setCustomerId(1L);
		customer.setCustomerTypeId(2L);
		customer.setMemberSince(firstDate);
		customerType.setCustomerTypeId(2L);
		customerType.setPercentageDiscount((long) 10);
		item.setItemId(1L);
		item.setItemName("Tomate");
		item.setItemPrice(5);
		item.setItemType(1L);
		items = new ArrayList<>();
		items.add(item);
	}

	@Test
	public void givenCustomerIdWhenGetDiscountPercentageThenReturnValue() {
		Mockito.when(customerRepository.findOne((long) 1)).thenReturn(customer);
		Mockito.when(customerTypeRepository.findOne((long) 2)).thenReturn(customerType);
		Long discountPercentage = orderService.getDiscountPercentage(1L);
		Long expectedValue = 10L;
		Assert.assertEquals(discountPercentage, expectedValue);
	}
	
	@Test 
	public void givenGroceryWhenGetItemsBasedOnTypeThenReturnGrocery() {
		Mockito.when(itemRepository.findByItemType(1L)).thenReturn(items);
		List<Item> incomingItems = orderService.getItemsBasedOnType(true);
		assertEquals(incomingItems, items);
		
	}
}
