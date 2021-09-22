package com.finoculus.finoculus.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inventory_t database table.
 * 
 */
@Entity
@Table(name="inventory_t")
@NamedQuery(name="InventoryT.findAll", query="SELECT i FROM InventoryT i")
public class InventoryT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private int quantity;

	//bi-directional many-to-one association to ItemSku
	@ManyToOne
	@JoinColumn(name="item_sku_id", insertable = false, updatable = false)
	private ItemSkuT itemSku;
	
	@Column(name="item_sku_id")
	private String itemSkuId;

	public InventoryT() {
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ItemSkuT getItemSku() {
		return this.itemSku;
	}

	public void setItemSku(ItemSkuT itemSku) {
		this.itemSku = itemSku;
	}

	public String getItemSkuId() {
		return itemSkuId;
	}

	public void setItemSkuId(String itemSkuId) {
		this.itemSkuId = itemSkuId;
	}

	
}