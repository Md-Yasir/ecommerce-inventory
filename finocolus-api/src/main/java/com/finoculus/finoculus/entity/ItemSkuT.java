package com.finoculus.finoculus.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the item_sku database table.
 * 
 */
@Entity
@Table(name="item_sku")
public class ItemSkuT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sku_code")
	private String skuCode;

	private int color;

	private float rate;

	private int size;

	//bi-directional many-to-one association to InventoryT
	@OneToMany(mappedBy="itemSku")
	private List<InventoryT> inventoryTs;

	//bi-directional many-to-one association to ItemsT
	@ManyToOne
	@JoinColumn(name="item_id", insertable = false, updatable = false)
	private ItemsT itemsT;
	
	@Column(name="item_id")
	private Integer itemId;

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<InventoryT> getInventoryTs() {
		return inventoryTs;
	}

	public void setInventoryTs(List<InventoryT> inventoryTs) {
		this.inventoryTs = inventoryTs;
	}

	public ItemsT getItemsT() {
		return itemsT;
	}

	public void setItemsT(ItemsT itemsT) {
		this.itemsT = itemsT;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

		
	
}