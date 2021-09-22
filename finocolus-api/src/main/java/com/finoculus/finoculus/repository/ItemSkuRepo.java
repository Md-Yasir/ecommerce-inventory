package com.finoculus.finoculus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finoculus.finoculus.entity.ItemSkuT;

@Repository
public interface ItemSkuRepo extends CrudRepository<ItemSkuT, String> {

}
