package com.blueoptima.kuber;

import com.blueoptima.kuber.pojo.Currency;
import com.blueoptima.kuber.pojo.CurrencyRate;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
}