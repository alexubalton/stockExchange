package com.stock;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector; 

public class Assignment extends AbstractModule{
	
  @Inject
  StockExchange stockExchange;
	
   String code;
   
   Integer units;
   
   @Override 
   protected void configure() {
      /*
      * Bind SpellChecker binding to WinWordSpellChecker implementation 
      * whenever spellChecker dependency is used.
      */
      bind(StockExchange.class).to(StockExchangeImpl.class);
   }
	public void trade() {
		try {
			// Call to buy but make sure that one method is getting called at the same time.
			stockExchange.buy(code,10);
			// Call to sell but make sure one method is getting called at the same time.
			stockExchange.sell(code,20);
		    
			// Reporting purpose to get the total trading cost
			System.out.print("TradingCosts-->"+stockExchange.getTradingCosts());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new Assignment());
		Assignment assignment = injector.getInstance(Assignment.class);
		assignment.code=args[1];
		assignment.trade();
	}

}
