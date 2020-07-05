package com.sunny.inventory.management.backend.dataservice;

import com.sunny.inventory.management.backend.dao.InventoryDAO;
import com.sunny.inventory.management.backend.dao.repo.entity.InventoryItem;
import com.sunny.inventory.management.backend.mapper.MapperService;
import com.sunny.inventory.management.backend.dataservice.model.InvDataSvcInvItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryDataService {

    @Autowired
    private MapperService mapperService;

    @Autowired
    private InventoryDAO inventoryDAO;

    public List<InvDataSvcInvItem> getInventoryItems(Integer page, Integer size){
        List<InvDataSvcInvItem> invDataSvcInvItems = null;
        List<InventoryItem> inventoryItems = inventoryDAO.getInventoryItems(page, size);
        if(inventoryItems != null){
            invDataSvcInvItems = mapperService.mapList(inventoryItems, InvDataSvcInvItem.class);
        }
        return invDataSvcInvItems;
    }

}