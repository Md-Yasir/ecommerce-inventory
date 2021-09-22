package com.finoculus.finoculus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.finoculus.finoculus.entity.PurchaseEntryT;

@Repository
public interface PurchaseEntryRepo extends CrudRepository<PurchaseEntryT, Integer> {

}
