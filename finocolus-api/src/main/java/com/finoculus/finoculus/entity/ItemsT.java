package com.finoculus.finoculus.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the items_t database table.
 * 
 */
@Entity
@Table(name="items_t")
@NamedQuery(name="ItemsT.findAll", query="SELECT i FROM ItemsT i")
public class ItemsT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to ItemSku
	@OneToMany(mappedBy="itemsT")
	private List<ItemSkuT> itemSkus;

	@Column(name="category_id")
	private Integer categoryId;

	//bi-directional many-to-one association to CategoryT
	@ManyToOne
	@JoinColumn(name="category_id", insertable = false, updatable = false)
	private CategoryT categoryT;
	
	public ItemsT() {
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

	public List<ItemSkuT> getItemSkus() {
		return this.itemSkus;
	}

	public void setItemSkus(List<ItemSkuT> itemSkus) {
		this.itemSkus = itemSkus;
	}

	public ItemSkuT addItemSkus(ItemSkuT itemSkus) {
		getItemSkus().add(itemSkus);
		itemSkus.setItemsT(this);

		return itemSkus;
	}

	public ItemSkuT removeItemSkus(ItemSkuT itemSkus) {
		getItemSkus().remove(itemSkus);
		itemSkus.setItemsT(null);

		return itemSkus;
	}

	public CategoryT getCategoryT() {
		return this.categoryT;
	}

	public void setCategoryT(CategoryT categoryT) {
		this.categoryT = categoryT;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	

}