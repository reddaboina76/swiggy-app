package com.swiggy.controller.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotelmenu")
public class ItemInfo {
	
	@Id
	private int itemId;
	private String item;
	private String price;
	private String qty;
	private String typeofItem;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getTypeofItem() {
		return typeofItem;
	}
	public void setTypeofItem(String typeofItem) {
		this.typeofItem = typeofItem;
	}

}
