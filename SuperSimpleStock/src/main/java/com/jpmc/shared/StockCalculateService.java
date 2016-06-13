package com.jpmc.shared;

import java.util.List;

import com.jpmc.model.Stock;
import com.jpmc.model.Trade;

/**
 * Interface of stock calculation services.
 * 
 */

public interface StockCalculateService {

	/**
	 * Calculates stock price for a given list of trades.
	 * 
	 * @param trades
	 *            the list of trades
	 * @throws StockCalculatorException
	 */
	double calculateStockPrice(List<Trade> trades) throws StockCalculatorException;

	/**
	 * Calculates gemetric mean for a given list of stocks.
	 * 
	 * @param stocks
	 *            the geometric mean
	 */
	double calculateGeometricMean(List<Stock> stocks);

	/**
	 * Calculates all shares indexes for a given list of stocks.
	 * 
	 * @param stocks
	 *            the list of stocks
	 */
	double calculateSharesIndexes(List<Stock> stocks);
}
