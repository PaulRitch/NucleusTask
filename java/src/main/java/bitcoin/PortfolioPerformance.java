package bitcoin;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.LinkedList;

public class PortfolioPerformance {

    private static final List<Price> PRICES = List.of(
            new Price(LocalDateTime.of(2021, Month.SEPTEMBER, 1, 5, 0, 0), new BigDecimal("35464.53")),
            new Price(LocalDateTime.of(2021, Month.SEPTEMBER, 2, 5, 0, 0), new BigDecimal("35658.76")),
            new Price(LocalDateTime.of(2021, Month.SEPTEMBER, 3, 5, 0, 0), new BigDecimal("36080.06")),
            new Price(LocalDateTime.of(2021, Month.SEPTEMBER, 3, 13, 0, 0), new BigDecimal("37111.11")),
            new Price(LocalDateTime.of(2021, Month.SEPTEMBER, 6, 5, 0, 0), new BigDecimal("38041.47")),
            new Price(LocalDateTime.of(2021, Month.SEPTEMBER, 7, 5, 0, 0), new BigDecimal("34029.61")));

    private static final List<Transaction> TRANSACTIONS = List.of(
            new Transaction(LocalDateTime.of(2021, Month.SEPTEMBER, 1, 9, 0, 0), new BigDecimal("0.012")),
            new Transaction(LocalDateTime.of(2021, Month.SEPTEMBER, 1, 15, 0, 0), new BigDecimal("-0.007")),
            new Transaction(LocalDateTime.of(2021, Month.SEPTEMBER, 4, 9, 0, 0), new BigDecimal("0.017")),
            new Transaction(LocalDateTime.of(2021, Month.SEPTEMBER, 5, 9, 0, 0), new BigDecimal("-0.01")),
            new Transaction(LocalDateTime.of(2021, Month.SEPTEMBER, 7, 9, 0, 0), new BigDecimal("0.1")));

    // Complete this method to return a list of daily portfolio values with one record for each day from the 01-09-2021-07-09-2021 in ascending date order
    public static List<DailyPortfolioValue> getDailyPortfolioValues() {
        BigDecimal currentPrice = new BigDecimal(0);
        BigDecimal units = new BigDecimal(0);
        List<DailyPortfolioValue> dailyPortfolioValues = new LinkedList<DailyPortfolioValue>();
    	for (int i = 1; i < 8; i++) {
    		for (int j = 0; j < PRICES.size(); j++) {
    			if(PRICES.get(j).effectiveDate().getDayOfMonth() == i) {
    				currentPrice = PRICES.get(j).price();
    			}
    		}
    		for (int k = 0; k < TRANSACTIONS.size(); k++) {
    			if(TRANSACTIONS.get(k).effectiveDate().getDayOfMonth() == i) {
    				units = units.add(TRANSACTIONS.get(k).numberOfBitcoins());
    			}
    		}
    		DailyPortfolioValue value = new DailyPortfolioValue(LocalDate.of(2021, Month.SEPTEMBER, i), currentPrice.multiply(units));
    		dailyPortfolioValues.add(value);
        }
    	return dailyPortfolioValues;
    }
}
