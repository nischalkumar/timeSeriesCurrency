package com.blueoptima.kuber;

import java.net.URI;
import java.util.List;
import java.util.Map;

public interface KubserService {

    List<CurrencyRate> getCurrencies(long utc);

    CurrencyRate getCurrencyRateInRange(int currencyId, Aggregator aggregator, long startTime, long endTime);

    Map<Long, List<CurrencyRate>> getCurrencyInRange(long startTime, long endTime);


    Map<Long, CurrencyRate> getParticularCurrencyInRange(int currencyId, long startTime, long endTime);


    int persist(long utc, List<CurrencyRate> currencies);

    int persist(long utc, CurrencyRate currencie);

    CurrencyRate getCurrencyRate(int currencyId, long startTime, long endTime);

    void crawl(URI uri, CrawlRequest crawlRequest);

    CurrencyRate convert(int fromCurrencyId, int toCurrencyId, long startTime, long endTime);
}
