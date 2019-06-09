/**
 * 
 */
package dev.codethat.retail.bean;

/**
 * @author Bharath
 *
 */
public class ProductRequest {

	private String id;
	
	private CurrentPrice currentPrice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}

}
