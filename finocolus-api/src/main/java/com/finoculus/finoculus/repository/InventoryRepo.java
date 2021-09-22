package com.finoculus.finoculus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finoculus.finoculus.entity.InventoryT;

@Repository
public interface InventoryRepo extends CrudRepository<InventoryT, Integer> {

	InventoryT findByItemSkuId(String itemSkuId);

}
