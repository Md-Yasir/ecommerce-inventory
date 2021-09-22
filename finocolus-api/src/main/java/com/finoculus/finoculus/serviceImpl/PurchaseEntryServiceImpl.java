package com.finoculus.finoculus.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finoculus.finoculus.entity.InventoryT;
import com.finoculus.finoculus.entity.PurchaseEntryT;
import com.finoculus.finoculus.repository.InventoryRepo;
import com.finoculus.finoculus.repository.PurchaseEntryRepo;
import com.finoculus.finoculus.service.PurchaseEntryService;

@Service
public class PurchaseEntryServiceImpl implements PurchaseEntryService{

	@Autowired
	private PurchaseEntryRepo purchaseEntryRepo;
	
	@Autowired 
	private InventoryRepo inventoryRepo;
	
	@Override
	public PurchaseEntryT newPurchaseEntry(List<PurchaseEntryT> purchaseEntryT) {
		
		Iterable<PurchaseEntryT> entries = purchaseEntryRepo.saveAll(purchaseEntryT);
		
		List<InventoryT> inventories = new ArrayList<InventoryT>();
		
		entries.forEach(entry -> {
			InventoryT inventoryT = inventoryRepo.findByItemSkuId(entry.getItemSkuId());
			Integer currentQuantity = inventoryT.getQuantity();
			Integer quantity = currentQuantity + entry.getQuantity();
			inventoryT.setQuantity(quantity);
			inventories.add(inventoryT);
//			entry.setTransactionId(entry.getId());
		});
		
		inventoryRepo.saveAll(inventories);
		
		
		return null;
	}

	@Override
	public Iterable<PurchaseEntryT> getAllRecords() {
		return purchaseEntryRepo.findAll();
	}

	@Override
	public Optional<PurchaseEntryT> getRecordsById(Integer transcationId) {
		return purchaseEntryRepo.findById(transcationId);
	}

}
