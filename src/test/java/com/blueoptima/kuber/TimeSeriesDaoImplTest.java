package com.blueoptima.kuber;

import com.blueoptima.kuber.pojo.Currency;
import com.blueoptima.kuber.pojo.CurrencyRate;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NavigableMap;

import static org.junit.Assert.*;

public class TimeSeriesDaoImplTest {
    private TimeSeriesDao timeSeriesDao;

    @Test
    public void testPersist() {
        timeSeriesDao = new TimeSeriesDaoImpl();
        timeSeriesDao.persist(123,Arrays.asList(new CurrencyRate(Currency.rupee,60), new CurrencyRate(Currency.dollar,1)));
        List<CurrencyRate> rates = timeSeriesDao.getCurrencies(123);
        Assert.assertEquals(2, rates.size());
    }

    @Test
    public void testPersistUpdate() {
        timeSeriesDao = new TimeSeriesDaoImpl();
        timeSeriesDao.persist(123,Arrays.asList(new CurrencyRate(Currency.rupee,60)));
        timeSeriesDao.persist(123,Arrays.asList(new CurrencyRate(Currency.dollar,1)));
        List<CurrencyRate> rates = timeSeriesDao.getCurrencies(123);
        Assert.assertEquals(2, rates.size());
    }

    @Test
    public void getCurrencyInRange() {
        timeSeriesDao = new TimeSeriesDaoImpl();
        timeSeriesDao.persist(123,Arrays.asList(new CurrencyRate(Currency.rupee,60), new CurrencyRate(Currency.dollar,1)));
        timeSeriesDao.persist(126,Arrays.asList(new CurrencyRate(Currency.rupee,60.01), new CurrencyRate(Currency.dollar,1)));
        timeSeriesDao.persist(129,Arrays.asList(new CurrencyRate(Currency.rupee,60.04), new CurrencyRate(Currency.dollar,1)));
        NavigableMap<Long, List<CurrencyRate>> response = timeSeriesDao.getCurrencyInRange(123,126);
        Assert.assertEquals(2, response.size());
    }

    @Test
    public void getParticularCurrencyInRange() {
        timeSeriesDao = new TimeSeriesDaoImpl();
        timeSeriesDao.persist(123,Arrays.asList(new CurrencyRate(Currency.rupee,60), new CurrencyRate(Currency.dollar,1)));
        timeSeriesDao.persist(126,Arrays.asList(new CurrencyRate(Currency.rupee,60.01), new CurrencyRate(Currency.dollar,1)));
        timeSeriesDao.persist(129,Arrays.asList(new CurrencyRate(Currency.rupee,60.04), new CurrencyRate(Currency.dollar,1)));
        NavigableMap<Long, CurrencyRate> response = timeSeriesDao.getParticularCurrencyInRange(Currency.rupee.getId(),123,126);
        Assert.assertEquals(2, response.size());
    }
}