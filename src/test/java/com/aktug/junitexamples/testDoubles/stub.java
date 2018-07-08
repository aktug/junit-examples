package com.aktug.junitexamples.testDoubles;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class stub {

    public class Trade {
        public Integer value;

        public Trade(Integer value) {
            this.value = value;
        }
    }

    public class PricingRepository {
        public Integer getPriceForTrade(Trade trade) {
            return trade.value;
        }
    }

    public class PricingService {
        PricingRepository repository;

        public PricingService(PricingRepository pricingRepository) {
            this.repository = pricingRepository;
        }

        public Integer priceTrade(Trade trade) {
            return repository.getPriceForTrade(trade);
        }

        public Integer getTotalPriceForTrades(Collection<Trade> trades) {
            Integer totalPrice = 0;
            for (Trade trade : trades) {
                Integer tradePrice = repository.getPriceForTrade(trade);
                totalPrice = totalPrice + tradePrice;
            }
            return totalPrice;
        }
    }

    @Test
    public void testGetHighestPricedTrade() {
        Integer price1 = 10;
        Integer price2 = 15;
        Integer price3 = 25;

        PricingRepository pricingRepository = mock(PricingRepository.class);
        when(pricingRepository.getPriceForTrade(any(Trade.class)))
                .thenReturn(price1, price2, price3);

        PricingService service = new PricingService(pricingRepository);
        List<Trade> trades = Arrays.asList(new Trade(10000), new Trade(33));
        Integer highestPrice = service.getTotalPriceForTrades(trades);

        assertEquals(price3, highestPrice);
    }


    @Test(expected = Exception.class)
    public void testGetHighestPricedTrade_saboteur() {
        Integer price3 = 25;

        PricingRepository pricingRepository = mock(PricingRepository.class);
        when(pricingRepository.getPriceForTrade(any(Trade.class)))
                .thenThrow(new Exception());


        PricingService service = new PricingService(pricingRepository);
        List<Trade> trades = Arrays.asList(new Trade(10000), new Trade(33));
        Integer highestPrice = service.getTotalPriceForTrades(trades);

        assertEquals(price3, highestPrice);
    }


}