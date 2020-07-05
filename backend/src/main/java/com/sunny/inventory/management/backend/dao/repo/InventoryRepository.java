package com.sunny.inventory.management.backend.dao.repo;

import com.sunny.inventory.management.backend.dao.repo.entity.InventoryItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InventoryRepository extends PagingAndSortingRepository<InventoryItem,String> {
    @Override
    Page<InventoryItem> findAll(Pageable pageable);
}
