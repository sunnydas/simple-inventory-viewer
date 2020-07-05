package com.sunny.inventory.management.backend.rest;

import com.sunny.inventory.management.backend.dataservice.InventoryDataService;
import com.sunny.inventory.management.backend.dataservice.model.InvDataSvcInvItem;
import com.sunny.inventory.management.backend.mapper.MapperService;
import com.sunny.inventory.management.backend.rest.dto.InventoryItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory-items")
public class InventoryController {

    @Autowired
    private InventoryDataService inventoryDataService;

    @Autowired
    private MapperService mapperService;

    @RequestMapping
    public List<InventoryItemDTO> getInventoryItems(@RequestParam(value = "page",
            required = false) Integer page,
                                           @RequestParam(value = "size",
            required = false) Integer size){
        List<InvDataSvcInvItem> invDataSvcInvItems = inventoryDataService.getInventoryItems(page,size);
        return mapperService.mapList(invDataSvcInvItems,InventoryItemDTO.class);
    }

}
