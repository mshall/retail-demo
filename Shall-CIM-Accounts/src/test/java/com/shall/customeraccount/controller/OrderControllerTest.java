package com.shall.customeraccount.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.JsonNode;
import com.shall.customeraccount.dto.ItemDTO;
import com.shall.customeraccount.dto.OrderDTO;
import com.shall.customeraccount.dto.ResultDTO;
import com.shall.customeraccount.service.OrderService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { OrderController.class, TestContext.class })
@EnableWebMvc
public class OrderControllerTest extends BaseControllerTest {

	@MockBean
	private OrderService orderService;
	ResultDTO result = new ResultDTO();
	OrderDTO order = new OrderDTO();
	ItemDTO item = new ItemDTO();
	List<ItemDTO> items = new ArrayList<>();

	@Before
	public void setup() {
		setupMock();
		item.setItemId(1L);
		item.setItemCount(2L);
		items.add(item);
		order.setIncomingItems(items);
		order.setCustomerId(1L);
	}

	@Test
	public void givenOrderWhenProcessOrderThenShouldProceed() {
		given(orderService.processOrder(order)).willReturn(result);
		whenProcessingOrder(order);
		thenHttpResponseStatusCodeIs(200);
		thenResponseBodyHasContentWithSuccessfulResponse(result);
	}

	private void whenProcessingOrder(OrderDTO order) {
		String serializedOrder = getSerializedObject(order);

		try {
			result.setMessage("Thanks!");
			result.setDiscountPercentage(10L);
			result.setOutstandingAmount(180);
			result.setDiscountedAmount(20);
			result.setBeforeDiscountAmount(200);
			requestResult = mockMvc.perform(post("/v1/order/").content(serializedOrder)
					.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)).andReturn();

		} catch (Exception e) {
			fail("Test failed: Cannot apply POST to the controller: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private void thenResponseBodyHasContentWithSuccessfulResponse(ResultDTO result) {

		try {
			String body = requestResult.getResponse().getContentAsString();
			JsonNode responseNode = getJSONNodeFromString(body);
			JsonNode resultsNode = responseNode.get("results");
			String actualResultString = resultsNode.toString();
			ResultDTO actualResult = (ResultDTO) getObjectFromString(actualResultString, ResultDTO.class);

			assertEquals(actualResult, result);
		} catch (UnsupportedEncodingException e) {
			fail("Test failed: cannot check response body");
		}

	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	class ResultDTOWrapper {
		String message;
		ResultDTO results;
	}

}
