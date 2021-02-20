package com.shall.customeraccount.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shall.customeraccount.dto.ItemDTO;
import com.shall.customeraccount.dto.OrderDTO;
import com.shall.customeraccount.dto.ResultDTO;
import com.shall.customeraccount.model.Customer;
import com.shall.customeraccount.model.CustomerType;
import com.shall.customeraccount.model.Item;
import com.shall.customeraccount.repository.CustomerRepository;
import com.shall.customeraccount.repository.CustomerTypeRepository;
import com.shall.customeraccount.repository.ItemRepository;

@Service
public class OrderService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private CustomerTypeRepository customerTypeRepository;

	public ResultDTO processOrder(OrderDTO order) {
		System.out.println("OrderService.processOrder - > Start");
		Long customerId = order.getCustomerId();
		Long discountPercentage = getDiscountPercentage(customerId);
		List<ItemDTO> incomingItems = order.getIncomingItems();
		// Fetch filter items to grocery & non grocery
		Map<String, Double> dueAmount = getDueAmount(incomingItems);
		double groceryTotalAmount = dueAmount.get("groceryDueAmount");
		
		double nonGroceryDueAmount = dueAmount.get("nonGroceryDueAmount");
		double discountedAmount = (nonGroceryDueAmount / 100) * discountPercentage;
		double outstandingAmount = (nonGroceryDueAmount - discountedAmount) + groceryTotalAmount;
		double beforeDiscountAmount = nonGroceryDueAmount + groceryTotalAmount;
		System.out.println("OrderService.processOrder - > Discount percentage: "+ discountPercentage);
		System.out.println("OrderService.processOrder - > Grocery amount: "+ groceryTotalAmount);
		System.out.println("OrderService.processOrder - > Non Grocery amount: "+ nonGroceryDueAmount);
		System.out.println("OrderService.processOrder - > discounted amount: "+ discountedAmount);
		System.out.println("OrderService.processOrder - > outstanding amount: "+ outstandingAmount);
		
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setBeforeDiscountAmount(beforeDiscountAmount);
		resultDTO.setDiscountedAmount(discountedAmount);
		resultDTO.setOutstandingAmount(outstandingAmount);
		resultDTO.setDiscountPercentage(discountPercentage);
		resultDTO.setMessage("Thanks for shopping with us!");
		return resultDTO;

	}

	public Long getDiscountPercentage(long customerId) {
		Customer customer = customerRepository.findOne(customerId);
		Long customerTypeId = customer.getCustomerTypeId();
		CustomerType customerType = customerTypeRepository.findOne(customerTypeId);
		return customerType.getPercentageDiscount();
	}

	public List<Item> getItemsBasedOnType(boolean isGrocery) {
		Long itemType = (long) ((isGrocery) ? 1 : 2);
		List<Item> items = itemRepository.findByItemType(itemType);
		return items;
	}

	public Map<String, Double> getDueAmount(List<ItemDTO> items) {
		System.out.println("OrderService.getDueAmount - > Start");
		Map<String, Double> dueAmount = new HashMap<>();
		
		double groceryDueAmount = 0, nonGroceryDueAmount = 0;
		for (ItemDTO incomingItem : items) {
			// We will need to fetch item price and accumulate
			Item dbItem = itemRepository.findOne(incomingItem.getItemId());
			// Item type 1 means groceries otherwise anything else
			if (dbItem.getItemType() == 1) {
				groceryDueAmount += (dbItem.getItemPrice() * incomingItem.getItemCount());
			} else {
				nonGroceryDueAmount += (dbItem.getItemPrice() * incomingItem.getItemCount());
			}
		}
		dueAmount.put("groceryDueAmount", groceryDueAmount);
		dueAmount.put("nonGroceryDueAmount", nonGroceryDueAmount);
		System.out.println("OrderService.getDueAmount - > Grocery amount: "+ groceryDueAmount);
		System.out.println("OrderService.getDueAmount - > Non Grocery amount: "+ nonGroceryDueAmount);
		System.out.println("OrderService.getDueAmount - > End");
		return dueAmount;

	}
}
