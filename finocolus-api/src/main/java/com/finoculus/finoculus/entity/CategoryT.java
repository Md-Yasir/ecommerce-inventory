package com.finoculus.finoculus.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category_t database table.
 * 
 */
@Entity
@Table(name="category_t")
@NamedQuery(name="CategoryT.findAll", query="SELECT c FROM CategoryT c")
public class CategoryT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to ItemsT
//	@OneToMany(mappedBy="categoryT")
//	private List<ItemsT> itemsTs;

	public CategoryT() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
//
//	public List<ItemsT> getItemsTs() {
//		return this.itemsTs;
//	}
//
//	public void setItemsTs(List<ItemsT> itemsTs) {
//		this.itemsTs = itemsTs;
//	}
//
//	public ItemsT addItemsT(ItemsT itemsT) {
//		getItemsTs().add(itemsT);
//		itemsT.setCategoryT(this);
//
//		return itemsT;
//	}
//
//	public ItemsT removeItemsT(ItemsT itemsT) {
//		getItemsTs().remove(itemsT);
//		itemsT.setCategoryT(null);
//
//		return itemsT;
//	}

}