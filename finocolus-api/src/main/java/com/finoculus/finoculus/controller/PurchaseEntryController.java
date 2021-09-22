package com.finoculus.finoculus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finoculus.finoculus.entity.PurchaseEntryT;
import com.finoculus.finoculus.service.PurchaseEntryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("/purchaseEntry")
@RequestMapping("/purchaseEntry")
public class PurchaseEntryController {
	
	@Autowired
	private PurchaseEntryService purchaseEntryService;
	
	//ADD
	@RequestMapping(value = "/newPurchaseEntry", method = RequestMethod.POST)
	@ResponseBody
	public PurchaseEntryT addItem(@RequestBody List<PurchaseEntryT> purchaseEntryT) {
		
		return purchaseEntryService.newPurchaseEntry(purchaseEntryT);
		
	}
	
	//GET
	@RequestMapping(value = "/get/allRecords", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<PurchaseEntryT> getAllRecords() {

		return purchaseEntryService.getAllRecords();
	}	

	@RequestMapping(value = "/get/recordsById", method = RequestMethod.GET)
	@ResponseBody
	public Optional<PurchaseEntryT> getRecordsById(@RequestParam("transactionId") Integer transcationId) {

		return purchaseEntryService.getRecordsById(transcationId);
	}
}
