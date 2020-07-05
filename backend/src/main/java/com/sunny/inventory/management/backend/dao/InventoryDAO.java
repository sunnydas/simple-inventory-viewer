package com.sunny.inventory.management.backend.dao;

import com.sunny.inventory.management.backend.dao.repo.InventoryRepository;
import com.sunny.inventory.management.backend.dao.repo.entity.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryDAO {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<InventoryItem> getInventoryItems(Integer page, Integer size){
        List<InventoryItem> inventoryItems = null;
        Pageable pageAble;
        if(page != null &&  size != null) {
            pageAble = PageRequest.of(page, size);
        }else{
            pageAble = Pageable.unpaged();
        }
        Page<InventoryItem> pageResult = inventoryRepository.findAll(pageAble);
        if(pageResult != null){
            inventoryItems = pageResult.getContent();
        }
        return inventoryItems;
    }

}
