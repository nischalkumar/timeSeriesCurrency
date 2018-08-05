package com.blueoptima.kuber;


import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class KuberServiceImpl implements KubserService {
    private final TimeSeriesDao timeSeries;
    private final Aggregator defaultAggregator;
    private Converter converter;

    public KuberServiceImpl() {
        this.timeSeries = new TimeSeriesDaoImpl();
        this.defaultAggregator = null;
        this.converter = new Converter();
    }

    @Override
    public List<CurrencyRate> getCurrencies(long utc) {
        return timeSeries.getCurrencies(utc);
    }

    @Override
    public CurrencyRate getCurrencyRateInRange(int currencyId, Aggregator aggregator, long startTime, long endTime) {
        return aggregator.aggregate(timeSeries.getParticularCurrencyInRange(currencyId, startTime, endTime).values());
    }

    @Override
    public Map<Long, List<CurrencyRate>> getCurrencyInRange(long startTime, long endTime) {
        return timeSeries.getCurrencyInRange(startTime, endTime);
    }

    @Override
    public Map<Long, CurrencyRate> getParticularCurrencyInRange(int currencyId, long startTime, long endTime) {
        return timeSeries.getParticularCurrencyInRange(currencyId, startTime, endTime);
    }

    @Override
    public int persist(long utc, List<CurrencyRate> currencies) {
        return timeSeries.persist(utc, currencies);
    }

    @Override
    public int persist(long utc, CurrencyRate currencie) {
        return timeSeries.persist(utc, Arrays.asList(currencie));
    }

    @Override
    public CurrencyRate getCurrencyRate(int currencyId, long startTime, long endTime) {
        return defaultAggregator.aggregate(timeSeries.getParticularCurrencyInRange(currencyId, startTime, endTime).values());
    }

    @Override
    public void crawl(URI uri, CrawlRequest crawlRequest) {
        throw new IllegalArgumentException();
    }

    @Override
    public CurrencyRate convert(int fromCurrencyId, int toCurrencyId, long startTime, long endTime) {
        CurrencyRate fromCurrencyRate = getCurrencyRateInRange(fromCurrencyId, defaultAggregator, startTime, endTime);
        CurrencyRate toCurrencyRate = getCurrencyRateInRange(toCurrencyId, defaultAggregator, startTime, endTime);
        Currency currency = getCurrency(toCurrencyId);
        return new CurrencyRate(currency, converter.convert(fromCurrencyRate, toCurrencyRate));
    }

    Currency getCurrency(int currencyId) {
        for (Currency currency : Currency.values()) {
            if (currency.getId() == currencyId) {
                return currency;
            }
        }
        throw new RuntimeException();
    }
}
