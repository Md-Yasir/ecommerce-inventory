package com.finoculus.finoculus.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the purchase_entry database table.
 * 
 */
@Entity
@Table(name="purchase_entry")
public class PurchaseEntryT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)          
	private int id;

	@Column(name="agency_name")
	private String agencyName;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="item_sku_id")
	private String itemSkuId;

	private int quantity;
	
	@Column(name="transaction_id")
	private String transactionId;
	
	private int amount;

	public PurchaseEntryT() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAgencyName() {
		return this.agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getItemSkuId() {
		return this.itemSkuId;
	}

	public void setItemSkuId(String itemSkuId) {
		this.itemSkuId = itemSkuId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	

}