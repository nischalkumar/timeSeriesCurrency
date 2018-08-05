package com.blueoptima.kuber.common;

import com.blueoptima.kuber.pojo.Currency;
import com.blueoptima.kuber.pojo.CurrencyRate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AvgAggregatorTest {
    AvgAggregator avgAggregator;

    @Before
    public void init() {
        avgAggregator= new AvgAggregator();
    }

    @Test
    public void aggregate() {
        List<CurrencyRate> currencyRates = Arrays.asList(new CurrencyRate(Currency.rupee,60), new CurrencyRate(Currency.rupee,62));
        Assert.assertEquals(61, avgAggregator.aggregate(currencyRates).getBaseValue(),0.00006);
    }

    public void emptyAggregate() {
        CurrencyRate currencyRate = avgAggregator.aggregate(new ArrayList<>());
        Assert.assertEquals(Double.NaN, currencyRate.getBaseValue());
    }
}