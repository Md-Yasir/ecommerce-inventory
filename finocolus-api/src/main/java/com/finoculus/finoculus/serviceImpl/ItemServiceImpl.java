package com.finoculus.finoculus.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finoculus.finoculus.entity.CategoryT;
import com.finoculus.finoculus.entity.InventoryT;
import com.finoculus.finoculus.entity.ItemSkuT;
import com.finoculus.finoculus.entity.ItemsT;
import com.finoculus.finoculus.repository.CategoryRepo;
import com.finoculus.finoculus.repository.InventoryRepo;
import com.finoculus.finoculus.repository.ItemRepo;
import com.finoculus.finoculus.repository.ItemSkuRepo;
import com.finoculus.finoculus.service.ItemsService;

@Service
public class ItemServiceImpl implements ItemsService{

	@Autowired 
	private ItemRepo itemRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ItemSkuRepo itemSkuRepo;
	@Autowired 
	private InventoryRepo inventoryRepo;

	@Override
	@Transactional
	public ItemsT addItem(ItemsT itemsT) {
		
		List<ItemSkuT> itemSkus = itemsT.getItemSkus();
		itemsT.setItemSkus(null);
		ItemsT items = itemRepo.save(itemsT);
		List<InventoryT> inventories = new ArrayList<InventoryT>();
		
		itemSkus = itemSkus.stream().map(sku -> {
			System.out.println(items.getId());
			sku.setItemId(items.getId());
			String skuCode = items.getId() + "_" + sku.getColor() + "_" + sku.getSize();
			sku.setSkuCode(skuCode);
			InventoryT inventory = new InventoryT();
			inventory.setQuantity(0);
			inventory.setItemSkuId(skuCode);
			inventories.add(inventory);
			System.out.println(sku.getItemId());
			return sku;
		}).collect(Collectors.toList());

		itemSkuRepo.saveAll(itemSkus);
		inventoryRepo.saveAll(inventories);
		
		return items;

	}

	@Override
	public CategoryT addCategory(CategoryT categoryT) {
		return categoryRepo.save(categoryT);
	}

	@Override
	public Iterable<ItemsT> getAllItems() {
		return itemRepo.findAll();
	}

	@Override
	public Iterable<CategoryT> getCategories() {
		
		return categoryRepo.findAll();
	}

}
