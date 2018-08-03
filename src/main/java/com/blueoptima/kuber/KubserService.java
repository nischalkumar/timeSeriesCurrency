package com.blueoptima.kuber;

import lombok.AllArgsConstructor;

import java.net.URI;
import java.util.List;
import java.util.Map;

public interface KubserService {

    List<CurrencyRate> getCurrencies(long utc);

   CurrencyRate getCurrencyRateInRange(int currencyId, Aggregator aggregator, long startTime, long endTime);

    Map<Long, List<CurrencyRate>> getCurrencyInRange(long startTime, long endTime);
    Map<Long, List<CurrencyRate>> getCurrencyInRange(long startTime, long endTime, PageRequest pageRequest);

    Map<Long, CurrencyRate> getParticularCurrencyInRange(String currencyId, long startTime, long endTime);
    Map<Long, CurrencyRate> getParticularCurrencyInRange(String currencyId, long startTime, long endTime, PageRequest pageRequest);

    int persist(long utc, List<CurrencyRate> currencies);
    int persist(long utc, CurrencyRate currencie);

    CurrencyRate getCurrencyRate(int currencyId, long startTime, long endTime);

    void crawl(URI uri, CrawlRequest crawlRequest);

    CurrencyRate convert(CurrencyRate currencyRate, long utc);


}
