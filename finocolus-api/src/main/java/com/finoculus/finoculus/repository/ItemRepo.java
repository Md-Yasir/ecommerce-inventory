package com.finoculus.finoculus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finoculus.finoculus.entity.ItemsT;

@Repository
public interface ItemRepo extends CrudRepository<ItemsT, Integer> {

}
