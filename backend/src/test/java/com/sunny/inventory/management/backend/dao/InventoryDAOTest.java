package com.sunny.inventory.management.backend.dao;

import com.sunny.inventory.management.backend.BackendApplication;
import com.sunny.inventory.management.backend.dao.repo.entity.InventoryItem;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class)
@ComponentScan("com.sunny.inventory.management.backend")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class InventoryDAOTest {

    @Autowired InventoryDAO inventoryDAO;

    @Test
    public void testGetInventoryItemsDefault() {
        List<InventoryItem> inventoryItemList = inventoryDAO.getInventoryItems(0, 10);
        assertNotNull(inventoryItemList);
        assertFalse(inventoryItemList.isEmpty());
        inventoryItemList.forEach(inventoryItem -> assertTrue(inventoryItem.getSku() != null
           && inventoryItem.getName() != null && inventoryItem.getCount() >= 0));
    }

    @Test
    public void testGetNonExistentPage(){
        List<InventoryItem> inventoryItemList = inventoryDAO.getInventoryItems(1, 10);
        assertNotNull(inventoryItemList);
        assertTrue(inventoryItemList.isEmpty());
    }

    @Test
    public void testGetInvalidPageIndexValue(){
        try {
            inventoryDAO.getInventoryItems(-1, 10);
        }catch (IllegalArgumentException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testGetInvalidPageLimitValue(){
        try {
            inventoryDAO.getInventoryItems(0, -1);
        }catch (IllegalArgumentException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testGetInventoryItemsUnpaged() {
        List<InventoryItem> inventoryItemList = inventoryDAO.getInventoryItems(null, null);
        assertNotNull(inventoryItemList);
        assertFalse(inventoryItemList.isEmpty());
        inventoryItemList.forEach(inventoryItem -> assertTrue(inventoryItem.getSku() != null
                && inventoryItem.getName() != null && inventoryItem.getCount() >= 0));
    }
}