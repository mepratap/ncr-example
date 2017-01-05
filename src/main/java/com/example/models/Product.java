package com.example.models;


public class Product {
	private long sku;
	private String name;
	private long storeId;
	private long count;
	
	public Product(){
		
	}
	
	public Product(long sku, String name, long storeId, long count) {
		super();
		this.sku = sku;
		this.name = name;
		this.storeId = storeId;
		this.count = count;
	}
	public long getSku() {
		return sku;
	}
	public void setSku(long sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Product [sku=" + sku + ", name=" + name + ", storeId=" + storeId + ", count=" + count + "]";
	}
	
}
