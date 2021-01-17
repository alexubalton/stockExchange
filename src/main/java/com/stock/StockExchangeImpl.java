package com.stock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StockExchangeImpl implements StockExchange{

	Map<String, Integer> stockMap = new HashMap<String, Integer>();
	Map<String, Integer> centsMap = new HashMap<String, Integer>();
	List<Integer> tradePerCentsList = new ArrayList<Integer>();
	
	StockExchangeImpl() {
		stockMap.put("NAB", 100);
		stockMap.put("CBA", 100);
		stockMap.put("QAN", 100);
		
		centsMap.put("ASX", 5);
		centsMap.put("CXA", 4);
	}
	
	public void buy(String code, Integer units) throws InsufficientUnitsException, InvalidCodeException {
		// TODO Auto-generated method stub
		AtomicInteger count = new AtomicInteger();
		centsMap.forEach((k,v)-> {
			if(k.equalsIgnoreCase(code)) {
				System.out.println("Code : " + k + " Value : " + v);				
				stockMap.forEach((key,value)-> {
						System.out.println("Code : " + key + " Value : " + value);
						if(value > 0 && count.intValue() == 0) {
							stockMap.put(key, value - units);
							count.incrementAndGet();
						}
				});				
				// track the value 
				tradePerCentsList.add(v);
			}			
		});

	}

	public void sell(String code, Integer units) throws InvalidCodeException {
		// TODO Auto-generated method stub
		AtomicInteger count = new AtomicInteger();
		centsMap.forEach((k,v)-> {
			if(k.equalsIgnoreCase(code)) {
				System.out.println("Code : " + k + " Value : " + v);				
				stockMap.forEach((key,value)-> {
						System.out.println("Code : " + key + " Value : " + value);
						if(value > 0 && count.intValue() == 0) {
							stockMap.put(key, value + units);
							count.incrementAndGet();
						}
				});				
				// track the value 
				tradePerCentsList.add(v);
			}			
		});
		
	}

	public Map<String, Integer> getOrderBookTotalVolume() {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal getTradingCosts() {
		
		long sum = tradePerCentsList.stream()
	            .mapToLong(Integer::longValue)
	            .sum();		
		BigDecimal d = new BigDecimal(sum);
		return d;
	} 
}
