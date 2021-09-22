package com.finoculus.finoculus.service;

import com.finoculus.finoculus.entity.CategoryT;
import com.finoculus.finoculus.entity.ItemsT;

public interface ItemsService {
	
	ItemsT addItem(ItemsT itemsT);

	CategoryT addCategory(CategoryT categoryT);

	Iterable<ItemsT> getAllItems();

	Iterable<CategoryT> getCategories();

}
