package dev.codethat.retail.bean;

public class CurrentPrice {
	private double value;

	private String currencyCode;

	public void setValue(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}