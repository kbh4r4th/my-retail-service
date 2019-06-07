package dev.codethat.retail.bean;

public class ProductResponse {
	private String id;

	private String name;

	private CurrentPrice currentPrice;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}

	public CurrentPrice getCurrentPrice() {
		return this.currentPrice;
	}
}
