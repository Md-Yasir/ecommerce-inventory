package com.finoculus.finoculus.service;

import java.util.List;
import java.util.Optional;

import com.finoculus.finoculus.entity.PurchaseEntryT;

public interface PurchaseEntryService {
	
	PurchaseEntryT newPurchaseEntry(List<PurchaseEntryT> purchaseEntryT);

	Iterable<PurchaseEntryT> getAllRecords();

	Optional<PurchaseEntryT> getRecordsById(Integer transcationId);

}
