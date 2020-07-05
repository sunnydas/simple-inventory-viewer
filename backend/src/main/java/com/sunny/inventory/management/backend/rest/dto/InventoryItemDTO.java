package com.sunny.inventory.management.backend.rest.dto;

import lombok.Data;

@Data
public class InventoryItemDTO {

    private String sku;

    private String name;

    private long count;

}
