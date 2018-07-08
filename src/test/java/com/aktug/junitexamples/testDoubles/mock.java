package com.aktug.junitexamples.testDoubles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class mock {

    public class Trade {
        public Integer value;
        public Long id = 10L;

        public void setValue(Integer value) {
            this.value = value;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    public class TradeRepository {
        public Long createTrade(Trade trade) {
            return trade.id;
        }
    }

    public class AuditService {
        public void logNewTrade(Trade trade) {
        }

    }

    public class SimpleTradingService {

        TradeRepository tradeRepository;
        AuditService auditService;

        public SimpleTradingService(TradeRepository tradeRepository,
                                    AuditService auditService) {
            this.tradeRepository = tradeRepository;
            this.auditService = auditService;
        }

        public Long createTrade(Trade trade) {
            Long id = tradeRepository.createTrade(trade);
            auditService.logNewTrade(trade);
            return id;
        }

    }


    @Mock //WILL STUB
            TradeRepository tradeRepository;
    @Mock//WILL MOCK
            AuditService auditService;

    @Test
    public void testAuditLogEntryMadeForNewTrade() throws Exception {
        Trade trade = new Trade();
        trade.setValue(100000);
        trade.setId(9L);

        //STUB
        when(tradeRepository.createTrade(trade)).thenReturn(anyLong());

        SimpleTradingService tradingService = new SimpleTradingService(tradeRepository, auditService);
        tradingService.createTrade(trade);

        //MOCK
        verify(auditService).logNewTrade(trade);
    }


}
