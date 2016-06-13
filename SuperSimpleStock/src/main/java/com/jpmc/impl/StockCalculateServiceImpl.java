package com.jpmc.impl;

import java.util.List;

import com.jpmc.model.Stock;
import com.jpmc.model.Trade;
import com.jpmc.shared.StockCalculateHelper;
import com.jpmc.shared.StockCalculateService;
import com.jpmc.shared.StockCalculatorException;

public class StockCalculateServiceImpl implements StockCalculateService {
	private StockCalculateHelper stockCalculateHelper = new StockCalculateHelperImpl();

	@Override
	public double calculateStockPrice(List<Trade> trades) throws StockCalculatorException {
		if (trades == null) {

			return 0d;
		}

		double[] tradesPrices = new double[trades.size()];
		double[] tradesQuantities = new double[trades.size()];

		int i = 0;
		for (Trade trade : trades) {

			tradesPrices[i] = trade.getPrice();
			tradesQuantities[i] = trade.getSharesQuantity();

			i++;
		}

		return stockCalculateHelper.calculateStockPrice(tradesPrices, tradesQuantities);
	}

	@Override
	public double calculateGeometricMean(List<Stock> stocks) {
		 double[] tradesPrices = new double[stocks.size()];
	      
	        double totalParValues = 0d;

	        int  i = 0;
	        for(Stock stock : stocks) {
	          
	            totalParValues += stock.getParValue();
	          
	            tradesPrices[i] = stock.getPrice();
	          
	            i++;
	        }

	        double geometricMean = stockCalculateHelper.calculateGeometricMean(tradesPrices);
	      
	        return geometricMean / totalParValues;
	}

	@Override
	public double calculateSharesIndexes(List<Stock> stocks) {
		 double[] tradesPrices = new double[stocks.size()];
	      
	        double totalParValues = 0d;

	        int  i = 0;
	        for(Stock stock : stocks) {
	          
	            totalParValues += stock.getParValue();
	          
	            tradesPrices[i] = stock.getPrice();
	          
	            i++;
	        }

	        double geometricMean = stockCalculateHelper.calculateGeometricMean(tradesPrices);
	      
	        return geometricMean / totalParValues;
	}

}
