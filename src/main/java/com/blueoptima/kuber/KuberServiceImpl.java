package com.blueoptima.kuber;


import com.blueoptima.kuber.common.Aggregator;
import com.blueoptima.kuber.common.AvgAggregator;
import com.blueoptima.kuber.common.Converter;
import com.blueoptima.kuber.pojo.CrawlRequest;
import com.blueoptima.kuber.pojo.Currency;
import com.blueoptima.kuber.pojo.CurrencyRate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class KuberServiceImpl implements KubserService {
    private final TimeSeriesDao timeSeriesDao;
    private final Aggregator defaultAggregator;
    private Converter converter;

    public KuberServiceImpl() {
        this.timeSeriesDao = new TimeSeriesDaoImpl();
        this.defaultAggregator = new AvgAggregator();
        this.converter = new Converter();
    }

    @Override
    public List<CurrencyRate> getCurrencies(long utc) {
        return timeSeriesDao.getCurrencies(utc);
    }

    @Override
    public CurrencyRate getCurrencyRateInRange(int currencyId, Aggregator aggregator, long startTime, long endTime) {
        return aggregator.aggregate(timeSeriesDao.getParticularCurrencyInRange(currencyId, startTime, endTime).values());
    }

    @Override
    public Map<Long, List<CurrencyRate>> getCurrencyInRange(long startTime, long endTime) {
        return timeSeriesDao.getCurrencyInRange(startTime, endTime);
    }

    @Override
    public Map<Long, CurrencyRate> getParticularCurrencyInRange(int currencyId, long startTime, long endTime) {
        return timeSeriesDao.getParticularCurrencyInRange(currencyId, startTime, endTime);
    }

    @Override
    public int persist(long utc, List<CurrencyRate> currencies) {
        return timeSeriesDao.persist(utc, currencies);
    }

    @Override
    public int persist(long utc, CurrencyRate currencie) {
        return timeSeriesDao.persist(utc, Arrays.asList(currencie));
    }

    @Override
    public CurrencyRate getCurrencyRate(int currencyId, long startTime, long endTime) {
        return defaultAggregator.aggregate(timeSeriesDao.getParticularCurrencyInRange(currencyId, startTime, endTime).values());
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
