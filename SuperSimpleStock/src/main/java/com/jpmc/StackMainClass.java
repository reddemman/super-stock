package com.jpmc;

import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.jpmc.impl.StockCalculateHelperImpl;
import com.jpmc.impl.StockCalculateServiceImpl;
import com.jpmc.model.BuyOrSellType;
import com.jpmc.model.Stock;
import com.jpmc.model.StockType;
import com.jpmc.model.Trade;
import com.jpmc.shared.StockCalculateHelper;
import com.jpmc.shared.StockCalculateService;
import com.jpmc.shared.StockCalculatorException;

public class StackMainClass {

	public static void main(String[] args) {
		StockCalculateHelper stockCalculatorHelper = new StockCalculateHelperImpl();
		StockCalculateService stockCalculatorService = new StockCalculateServiceImpl();

		Stock tea = new Stock("TEA", StockType.COMMON, 0d, 0, 100, 800d);
		Stock pop = new Stock("POP", StockType.COMMON, 8d, 0, 100, 100d);
		Stock ale = new Stock("ALE", StockType.COMMON, 23d, 0, 60, 100d);
		Stock gin = new Stock("GIN", StockType.PREFERRED, 8d, 2d, 100, 100d);
		Stock joe = new Stock("JOE", StockType.COMMON, 13d, 0, 250, 1200d);

		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(tea);
		stocks.add(pop);
		stocks.add(ale);
		stocks.add(gin);
		stocks.add(joe);

		Stock stock = null;
		Trade trade = null;
		List<Trade> trades = null;

		Random rand = new Random();

		int nbTrades = rand.nextInt(100 - 10 + 1) + 10;

		Map<Stock, List<Trade>> map = new HashMap<Stock, List<Trade>>();

		for (int i = 0; i < nbTrades; i++) {

			stock = stocks.get(rand.nextInt(stocks.size() - 1));

			trades = map.get(stock);

			if (trades == null) {

				trades = new ArrayList<Trade>();

				map.put(stock, trades);
			}

			trade = new Trade(stock, new Date(), (rand.nextDouble() * 1000d + 50d),
					rand.nextBoolean() ? BuyOrSellType.BUY : BuyOrSellType.SELL, (rand.nextDouble() * 1000d + 50d));

			trades.add(trade);
		}

		StringBuffer buff = null;
		Formatter formatter = null;

		System.out.println("+--------+----------------+-----------+-------------+");
		System.out.println("| Symbol | Dividend yield | P/E ratio | Stock price |");
		System.out.println("+--------+----------------+-----------+-------------+");

		for (Stock stockForCalculs : stocks) {

			trades = map.get(stockForCalculs);

			buff = new StringBuffer();
			formatter = new java.util.Formatter(buff);

			try {
				formatter.format("| %6s | %14.2f | %9.2f | %11.2f |", stockForCalculs.getStockSymbol(),

						stockForCalculs.getStocktype().equals(StockType.COMMON)
								? stockCalculatorHelper.calculateDividendYieldCommon(stockForCalculs.getParValue(),
										stockForCalculs.getLastDividend())
								: stockCalculatorHelper.calculateDividendYieldPreferred(stockForCalculs.getParValue(),
										stockForCalculs.getParValue(), stockForCalculs.getFixedDividend()),
						stockCalculatorHelper.calculatePeRatio(stockForCalculs.getParValue(),
								stockForCalculs.getLastDividend()),

						stockCalculatorService.calculateStockPrice(trades));
			} catch (StockCalculatorException e) {

				e.printStackTrace();
			}
			System.out.println(buff);
			System.out.println("+--------+----------------+-----------+-------------+");
		}

		System.out.println();
		System.out.println();

		System.out.println("+----------------+");
		System.out.println("| GBCE All share |");
		System.out.println("+----------------+");

		buff = new StringBuffer();
		formatter = new java.util.Formatter(buff);

		formatter.format("| %14.2f |", stockCalculatorService.calculateSharesIndexes(stocks));
		System.out.println(buff);
		System.out.println("+----------------+");
		System.out.println();
		System.out.println();

	}

}