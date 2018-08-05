package com.blueoptima.kuber;

import com.blueoptima.kuber.pojo.Currency;
import com.blueoptima.kuber.pojo.CurrencyRate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KuberServiceImplTest {
    KubserService kubserService;

    @Before
    public void init() {
        kubserService=new KuberServiceImpl();
    }

    @Test
    public void convert() {
        kubserService.persist(123,new CurrencyRate(Currency.dollar,1.1));
        kubserService.persist(123,new CurrencyRate(Currency.rupee,0.015));
        kubserService.persist(124,new CurrencyRate(Currency.rupee,0.0151));
        kubserService.persist(125,new CurrencyRate(Currency.euro,1.162));
        kubserService.persist(126,new CurrencyRate(Currency.euro,1.163));
        kubserService.persist(126,new CurrencyRate(Currency.dollar,1.0001));
        CurrencyRate result = kubserService.convert(Currency.euro.getId(), Currency.rupee.getId(), 120,130);
        Assert.assertEquals(0.013,result.getBaseValue(),0.001);
    }
}