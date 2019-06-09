/**
 * 
 */
package dev.codethat.retail.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.codethat.retail.MyRetailServiceConstants;

/**
 * @author Bharath
 *
 */
@Document(collection=MyRetailServiceConstants.COLLECTION_PRODUCT)
public class Product {
	@Id
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
