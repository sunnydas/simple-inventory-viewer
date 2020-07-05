package com.sunny.inventory.management.backend.dao.repo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "inventory")
public class InventoryItem {

    @Id
    private String sku;

    private String name;

    private Integer count;

}
