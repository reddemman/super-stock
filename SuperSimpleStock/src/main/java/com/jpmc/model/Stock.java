package com.jpmc.model;

public class Stock {

private String stockSymbol;
private double lastDividend;
private double price;
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getStockSymbol() {
	return stockSymbol;
}
public void setStockSymbol(String stockSymbol) {
	this.stockSymbol = stockSymbol;
}
public double getLastDividend() {
	return lastDividend;
}
public Stock(String stockSymbol,StockType stocktype, double lastDividend, double fixedDividend, int parValue,double price) {
	super();
	this.stockSymbol = stockSymbol;
	this.lastDividend = lastDividend;
	this.parValue = parValue;
	this.fixedDividend = fixedDividend;
	this.stocktype = stocktype;
}
public void setLastDividend(double lastDividend) {
	this.lastDividend = lastDividend;
}
public int getParValue() {
	return parValue;
}
public void setParValue(int parValue) {
	this.parValue = parValue;
}
public double getFixedDividend() {
	return fixedDividend;
}
public void setFixedDividend(double fixedDividend) {
	this.fixedDividend = fixedDividend;
}
public StockType getStocktype() {
	return stocktype;
}
public void setStocktype(StockType stocktype) {
	this.stocktype = stocktype;
}
private int parValue;
private double fixedDividend;
private StockType stocktype;
	
}
