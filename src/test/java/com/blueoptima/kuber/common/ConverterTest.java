package com.blueoptima.kuber.common;

import com.blueoptima.kuber.pojo.Currency;
import com.blueoptima.kuber.pojo.CurrencyRate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTest {
    Converter converter;
    @Before
    public void init() {
        converter= new Converter();
    }

    @Test
    public void converterTest() {
        CurrencyRate rupeeCurrencyRate= new CurrencyRate(Currency.rupee,68.52);
        CurrencyRate dollarCurrencyRate= new CurrencyRate(Currency.euro,0.86);
        double value = converter.convert(rupeeCurrencyRate, dollarCurrencyRate);
        Assert.assertEquals(0.013,value,0.01);
    }

}