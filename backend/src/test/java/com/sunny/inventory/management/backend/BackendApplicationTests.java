package com.sunny.inventory.management.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunny.inventory.management.backend.rest.dto.InventoryItemDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BackendApplicationTests {

	private final static String BACKEND_RES_PATH = "/inventory-items";

	private final static String DEF_PAGE_INDEX = "0";

	private final static String DEF_PAGE_SIZE = "10";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
    private ObjectMapper objectMapper;

	@Test
	public void testGetAllInventoryItems() throws Exception {
		MvcResult mvcResult =
				mockMvc.perform
						(get(BACKEND_RES_PATH)).
						andExpect(status().isOk()).andReturn();
		List<InventoryItemDTO> inventoryItemDTOList = convertToInventortDTOs(mvcResult);
		assertNotNull(inventoryItemDTOList);
		inventoryItemDTOList.forEach(inventoryItemDTO -> assertTrue(
				inventoryItemDTO.getSku() != null
		                && inventoryItemDTO.getName() != null));
	}

	@Test
	public void testGetAllInventoryItemsPaged() throws Exception {
		MvcResult mvcResult =
				mockMvc.perform
						(get(BACKEND_RES_PATH).param("page",
								DEF_PAGE_INDEX).
								param("size",
										DEF_PAGE_SIZE)).
						andExpect(status().isOk()).andReturn();
		List<InventoryItemDTO> inventoryItemDTOList = convertToInventortDTOs(mvcResult);
		assertNotNull(inventoryItemDTOList);
		inventoryItemDTOList.forEach(inventoryItemDTO -> assertTrue(
				inventoryItemDTO.getSku() != null
						&& inventoryItemDTO.getName() != null));
	}

	private List<InventoryItemDTO> convertToInventortDTOs(MvcResult mvcResult)
			throws com.fasterxml.jackson.core.JsonProcessingException,
			UnsupportedEncodingException {
		return objectMapper.
					readValue(mvcResult.getResponse().
							getContentAsString(),
							objectMapper.getTypeFactory().
									constructCollectionType(List.
							class, InventoryItemDTO.class));
	}


}
