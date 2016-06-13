package com.jpmc.model;

import java.util.Date;

public class Trade {
	private Stock stock;
	 private Date timestamp;
	 private Double sharesQuantity;
	 private BuyOrSellType buyOrSellIndicator;
	 public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public Trade(Stock stock, Date timestamp, Double sharesQuantity, BuyOrSellType buyOrSellIndicator, Double price) {
		super();
		this.stock = stock;
		this.timestamp = timestamp;
		this.sharesQuantity = sharesQuantity;
		this.buyOrSellIndicator = buyOrSellIndicator;
		this.price = price;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Double getSharesQuantity() {
		return sharesQuantity;
	}
	public void setSharesQuantity(Double sharesQuantity) {
		this.sharesQuantity = sharesQuantity;
	}
	public BuyOrSellType getBuyOrSellIndicator() {
		return buyOrSellIndicator;
	}
	public void setBuyOrSellIndicator(BuyOrSellType buyOrSellIndicator) {
		this.buyOrSellIndicator = buyOrSellIndicator;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	private Double price;
	 
	 

}
